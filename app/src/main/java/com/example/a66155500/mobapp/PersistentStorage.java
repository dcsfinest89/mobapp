package com.example.a66155500.mobapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PersistentStorage extends AppCompatActivity {

    SharedPreferences preferences;


    EditText inputText;
    Button saveButton;
    TextView textView1;
    TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistent_storage);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        inputText = findViewById(R.id.editText);
        saveButton = findViewById(R.id.button_save);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        saveButton.setOnClickListener(saveHandler);
        textView2.setText(preferences.getString("SP", ""));

    }

    View.OnClickListener saveHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("SP", inputText.getText().toString()).apply();
            textView1.setText(inputText.getText());
            textView2.setText(inputText.getText());
        }
    };

}
