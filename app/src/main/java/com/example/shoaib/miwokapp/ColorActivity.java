package com.example.shoaib.miwokapp;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class ColorActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
             releaseMediaPlayer();
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

       final ArrayList<Word> word = new ArrayList<Word>();

        word.add(new Word("Red" ,"Weṭeṭṭi",R.drawable.color_red ,R.raw.color_red));
        word.add(new Word("Green", "Chokokki",R.drawable.color_green ,R.raw.color_green));
        word.add(new Word("Brown", "Takaakki",R.drawable.color_brown ,R.raw.color_brown));
        word.add(new Word("Gray", "Topoppi",R.drawable.color_gray ,R.raw.color_gray));
        word.add(new Word("Black", "Kululli",R.drawable.color_black ,R.raw.color_black));
        word.add(new Word("White", "Kelelli",R.drawable.color_white ,R.raw.color_white));
        word.add(new Word("Dusty Yellow", "Topiisә",R.drawable.color_dusty_yellow ,R.raw.color_dusty_yellow));
        word.add(new Word("Musty Yellow", "Chiwiiṭә",R.drawable.color_mustard_yellow ,R.raw.color_mustard_yellow));


        WordAdapter Adapter = new WordAdapter(this,word,R.color.category_color);

        ListView activityText = (ListView) findViewById(R.id.commanIntent);

        activityText.setAdapter(Adapter);

        activityText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                releaseMediaPlayer();

                Word words = word.get(position);

                mediaPlayer = MediaPlayer.create(ColorActivity.this,words.getmAudioResource());

                int result = audioManager.requestAudioFocus(mAudioFocus,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer.start();
                    Log.d("REQUEST==", "Successfull to request audioFocus listener");
                    mediaPlayer.setOnCompletionListener(mCompletionListener);

                }

            }

        });


    }

    private void releaseMediaPlayer(){
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            audioManager.abandonAudioFocus(mAudioFocus);
        }
    }

    AudioManager.OnAudioFocusChangeListener mAudioFocus = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {
                case AudioManager.AUDIOFOCUS_LOSS:
                    releaseMediaPlayer();
                    Log.d("Stop==", "AudioFocus: received AUDIOFOCUS_LOSS");
                    break;

                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                    Log.d("Pause==", "AudioFocus: received AUDIOFOCUS_LOSS_TRANSIENT");
                    break;

                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    mediaPlayer.setVolume(0.5f, 0.5f);
                    Log.d("LossTransient==", "AudioFocus: received AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                    break;

                case AudioManager.AUDIOFOCUS_GAIN:
                    mediaPlayer.start();
                    mediaPlayer.setVolume(1.0f, 1.0f);
                    Log.d("Start=", "AudioFocus: received AUDIOFOCUS_GAIN");
                    break;

                default:
                    Log.e("Default", "Unknown audio focus change code");

            }
        }
    };


    }
