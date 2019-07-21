package com.example.shoaib.miwokapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

     private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    TextView numbers = findViewById(R.id.clickNumber);

    numbers.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent numbersActivity = new Intent(MainActivity.this,NmbersActivity.class);
            startActivity(numbersActivity);
        }
    });

        TextView color = findViewById(R.id.clickColor);

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorActivity = new Intent(MainActivity.this,ColorActivity.class);

                startActivity(colorActivity);
            }
        });

        TextView phrase = findViewById(R.id.clickPhrases);

        phrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrasesActivity = new Intent(MainActivity.this,PhrasesActivity.class);

                startActivity(phrasesActivity);
            }
        });

        TextView members = findViewById(R.id.clickMembers);

        members.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent membersActivity = new Intent(MainActivity.this,MembersActivity.class);

                startActivity(membersActivity);
            }
        });

    }

}
