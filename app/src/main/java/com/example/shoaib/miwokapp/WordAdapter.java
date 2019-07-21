package com.example.shoaib.miwokapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorPrimary;

    public WordAdapter(Context ActivityName, ArrayList<Word> word, int background) {
        super(ActivityName,0,word);
        mColorPrimary = background;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


      View listItemView = convertView;
        if (listItemView == null)

        {
            listItemView = LayoutInflater.from(getContext()).inflate
                    (R.layout.list_item, parent, false);
        }

        final Word defaultView = getItem(position);

        final TextView miwokTextView = listItemView.findViewById(R.id.mivokTrans);

        miwokTextView.setText(defaultView.getMovik());


        final TextView defaultTextView = listItemView.findViewById(R.id.defaultTrans);

        defaultTextView.setText(defaultView.getDefault());

        ImageView imageView = listItemView.findViewById(R.id.image);
       if(defaultView.hasImage()) {
           imageView.setImageResource(defaultView.getmImageResourseId());
       }

       else{
           imageView.setVisibility(View.GONE);
       }


       View colorView = listItemView.findViewById(R.id.linear_item);

       colorView.setBackgroundResource(mColorPrimary);

       return listItemView;


    }

}

