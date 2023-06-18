package com.example.p1_luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {
    TextView welcomeTxt, luckyNumberTxt;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        welcomeTxt = findViewById(R.id.textView2);
        luckyNumberTxt = findViewById(R.id.lucky_number_txt);
        share_btn = findViewById(R.id.share_number_btn);

        Intent i = getIntent();
        String username = i.getStringExtra("name");

        // Random Number Generator
        int random_Num = generateRandomNumber();

        // To show Random No in LuckyNoTxt

        luckyNumberTxt.setText(""+random_Num);

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(username, random_Num);
            }
        });

    }

    public int generateRandomNumber(){

        Random random = new Random();
        int upper_limit = 1000;

        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;

    }

    public void shareData(String username, int randomNum){

        // Implicit intents
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        // Convert the int to string
        String number = String.valueOf(randomNum);

        i.putExtra(Intent.EXTRA_SUBJECT, username + " got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT,  "His lucky number is: "++  number);


        startActivity(Intent.createChooser(i,"Choose a platform"));

    }

}