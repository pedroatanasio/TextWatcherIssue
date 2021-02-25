This repository contains an app demonstrating a `IndexOutOfBoundsException` when using multiple `TextWatcher`s added to the same `TextView` and one removes itself. 

This is the internal source code for the `sendOnTextChanged` method present in the `TextView` class:

```java
void sendOnTextChanged(CharSequence text, int start, int before, int after) {
    if (mListeners != null) {
        final ArrayList<TextWatcher> list = mListeners;
        final int count = list.size();
        for (int i = 0; i < count; i++) {
            list.get(i).onTextChanged(text, start, before, after);
        }
    }

    if (mEditor != null) mEditor.sendOnTextChanged(start, before, after);
}
```

As we can see, when the text changes the code iterates over the list of listeners and notifies each one of them. The size of the list is used as the control variable of the for loop and is obtained at the beginning of the method.

```java
final int count = list.size();
```

The problem happens when the `TextWatcher` removes itself (or any other `TextWatcher`) in the `onTextChanged` method. This modifies the inital size of the list generating a `IndexOutOfBoundsException`.
