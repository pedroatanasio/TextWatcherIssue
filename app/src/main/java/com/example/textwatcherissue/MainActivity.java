package com.example.textwatcherissue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView  = findViewById(R.id.text_view);
        final Button button = findViewById(R.id.button);

        final TextWatcher textWatcher1 = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.removeTextChangedListener(this);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {}
        };

        // Creates second text watcher
        final TextWatcher textWatcher2 = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.removeTextChangedListener(this);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {}
        };

        button.setOnClickListener(v -> textView.setText("New text"));
        textView.addTextChangedListener(textWatcher1);
        textView.addTextChangedListener(textWatcher2);

    }
}