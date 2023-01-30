package com.example.shahid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class details_movies_two extends AppCompatActivity {

    TextView textView ;
    ImageView imageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movies_two);

        textView = (TextView) findViewById(R.id.name_movie2);
        imageView = (ImageView) findViewById(R.id.image_movie2);

        String name_movie_2_main = getIntent().getExtras().getString("name_film_two");
        int image_movie_2_main = getIntent().getExtras().getInt("image_film_two");

        textView.setText(name_movie_2_main);
        imageView.setImageResource(image_movie_2_main);






    }
}