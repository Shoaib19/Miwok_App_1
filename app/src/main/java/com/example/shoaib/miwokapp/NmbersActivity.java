package com.example.shoaib.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NmbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }

    };

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> word = new ArrayList<Word>();

        word.add(new Word("One", "Lutti", R.drawable.number_one, R.raw.number_one));
        word.add(new Word("Two", "Otlika", R.drawable.number_two, R.raw.number_two));
        word.add(new Word("Three", "Tolookosu", R.drawable.number_three, R.raw.number_three));
        word.add(new Word("Four", "Oyyisa", R.drawable.number_four, R.raw.number_four));
        word.add(new Word("Five", "Massokka", R.drawable.number_five, R.raw.number_five));
        word.add(new Word("Six", "Temmoka", R.drawable.number_six, R.raw.number_six));
        word.add(new Word("Seven", "Kenekaku", R.drawable.number_seven, R.raw.number_seven));
        word.add(new Word("Eight", "Kawinta", R.drawable.number_eight, R.raw.number_eight));
        word.add(new Word("Nine", "Wo'e", R.drawable.number_nine, R.raw.number_nine));
        word.add(new Word("Ten", "Na'aacha", R.drawable.number_ten, R.raw.number_ten));


        WordAdapter Adapter = new WordAdapter(this, word, R.color.category_number);

        ListView activityText = findViewById(R.id.commanIntent);

        activityText.setAdapter(Adapter);


        activityText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word words = word.get(position);

                releaseMediaPlayer();

                Log.d("Clicked Numbers", "Successfully");

                mediaPlayer = MediaPlayer.create(NmbersActivity.this, words.getmAudioResource());

                mediaPlayer.start();


                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });


    }


    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

}