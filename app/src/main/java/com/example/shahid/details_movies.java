package com.example.shahid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shahid.Adapters.RecyclerViewAdapterActors;
import com.example.shahid.Adapters.RecyclerViewAdapterOther;
import com.example.shahid.interfice.MovieItemClickListener;
import com.example.shahid.model.actors;
import com.example.shahid.model.moviesTwo;
import com.example.shahid.model.other;

import java.util.ArrayList;

public class details_movies extends AppCompatActivity implements MovieItemClickListener {

    ImageView imageView ;
    TextView textView ;
    RecyclerView r_v_main_actors , r_v_main_other ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_two);


        textView = (TextView) findViewById(R.id.name_movie);
        imageView = (ImageView) findViewById(R.id.details_movie);
        r_v_main_actors =(RecyclerView) findViewById(R.id.actors_rv);
        r_v_main_other = (RecyclerView) findViewById(R.id.recyclerView_other);


        String movie_name = getIntent().getExtras().getString("name_film");
        int movie_img  = getIntent().getExtras().getInt("image_film");
        int id_item = getIntent().getExtras().getInt("idItem");


        imageView.setImageResource(movie_img);
        textView.setText(movie_name);


        ArrayList<actors> actorsArrayListMain = new ArrayList<>();

        if (id_item == 1 ){

            //RecyclerViewActors

            actorsArrayListMain.add(new actors("actor name",R.drawable.actor_three));
            actorsArrayListMain.add(new actors("actor name",R.drawable.actor_two));
            actorsArrayListMain.add(new actors("actor name",R.drawable.actor_three));
            actorsArrayListMain.add(new actors("actor name",R.drawable.actor_two));

            RecyclerViewAdapterActors adapterActors = new RecyclerViewAdapterActors(this,actorsArrayListMain);
            r_v_main_actors.setAdapter(adapterActors);
            r_v_main_actors.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
            r_v_main_actors.setHasFixedSize(true);

        }else{
            if (id_item == 2){
                actorsArrayListMain.add(new actors("actor name",R.drawable.actor_three));
                actorsArrayListMain.add(new actors("actor name",R.drawable.actor_three));
                actorsArrayListMain.add(new actors("actor name",R.drawable.actor_three));
                actorsArrayListMain.add(new actors("actor name",R.drawable.actor_three));

                RecyclerViewAdapterActors adapterActors = new RecyclerViewAdapterActors(this,actorsArrayListMain);
                r_v_main_actors.setAdapter(adapterActors);
                r_v_main_actors.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
                r_v_main_actors.setHasFixedSize(true);
            }else {
                if (id_item == 3 ){
                    actorsArrayListMain.add(new actors("actor name",R.drawable.actor_two));
                    actorsArrayListMain.add(new actors("actor name",R.drawable.actor_two));
                    actorsArrayListMain.add(new actors("actor name",R.drawable.actor_two));
                    actorsArrayListMain.add(new actors("actor name",R.drawable.actor_two));

                    RecyclerViewAdapterActors adapterActors = new RecyclerViewAdapterActors(this,actorsArrayListMain);
                    r_v_main_actors.setAdapter(adapterActors);
                    r_v_main_actors.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
                    r_v_main_actors.setHasFixedSize(true);

                }
            }
        }


        ArrayList<moviesTwo> moviesTwosMain = new ArrayList<>();

        moviesTwosMain.add(new moviesTwo(R.drawable.r_v_1,"memory"));
        moviesTwosMain.add(new moviesTwo(R.drawable.r_v_2,"the gray man"));
        moviesTwosMain.add(new moviesTwo(R.drawable.r_v_1,"memory"));
        moviesTwosMain.add(new moviesTwo(R.drawable.r_v_2,"the gray man"));
        moviesTwosMain.add(new moviesTwo(R.drawable.r_v_1,"memory"));
        moviesTwosMain.add(new moviesTwo(R.drawable.r_v_2,"the gray man"));

        RecyclerViewAdapterOther adapterOther = new RecyclerViewAdapterOther(this,moviesTwosMain,this);
        r_v_main_other.setAdapter(adapterOther);
        r_v_main_other.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        r_v_main_other.setHasFixedSize(true);


    }

    @Override
    public void clickLListenerOther(moviesTwo moviesTwo, ImageView imageView) {

        Intent intent = new Intent(details_movies.this, other.class);

        intent.putExtra("image_movie_other",moviesTwo.getImage_movie_2());
        intent.putExtra("name_movie_other",moviesTwo.getName_movie_1());

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(details_movies.this,imageView
                ,"sharedNameOther");

        startActivity(intent,options.toBundle());

    }



}