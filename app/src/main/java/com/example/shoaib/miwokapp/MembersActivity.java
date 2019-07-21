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

public class MembersActivity extends AppCompatActivity {

       private MediaPlayer mediaPlayer;
       private static final String TAG = MembersActivity.class.getSimpleName();


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onStop(){
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

      //  getActionBar().setDisplayHomeAsUpEnabled(true);

      //  onOptionsItemSelected(android.R.id.home);

        final ArrayList<Word> word = new ArrayList<Word>();


        word.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        word.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        word.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        word.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        word.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        word.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        word.add(new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        word.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        word.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        word.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));


        WordAdapter Adapter = new WordAdapter(this, word, R.color.category_members);

        ListView activityText = findViewById(R.id.commanIntent);

        activityText.setAdapter(Adapter);

        activityText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.d(TAG, "clickListener:ANDAR AYYA ");
                releaseMediaPlayer();
                Word words = word.get(position);

                mediaPlayer = MediaPlayer.create(getApplicationContext(), words.getmAudioResource());

                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });


    }
    private void releaseMediaPlayer(){
        // If the media player is not null, then it may be currently playing a sound.

        Log.d(TAG, "releaseMediaPlayer:ANDAR AYYA ");
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            Log.d(TAG, "releaseMediaPlayer:ANDAR AYYA bilkul");
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

}

