package com.example.p1_luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.textView);
        btn = findViewById(R.id.btn);
        editText = findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name = editText.getText().toString();

                Intent i = new Intent(getApplicationContext(), LuckyNumberActivity.class);

                // Passing the name to second activity
                i.putExtra("name",user_name);

                startActivity(i);
            }
        });
    }
}