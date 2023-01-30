package com.example.shahid.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shahid.R;

public class other extends AppCompatActivity {

    ImageView imageView ;
    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_in_details);

        imageView = (ImageView) findViewById(R.id.image_movie2_other);
        textView = (TextView) findViewById(R.id.name_movie2_other);

        String name_movie = getIntent().getExtras().getString("name_movie_other");
        int image_movie = getIntent().getExtras().getInt("image_movie_other");

        textView.setText(name_movie);
        imageView.setImageResource(image_movie);

    }



}