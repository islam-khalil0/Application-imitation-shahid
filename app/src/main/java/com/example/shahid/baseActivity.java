package com.example.shahid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.shahid.Adapters.RecyclerViewAdapter;
import com.example.shahid.Adapters.RecyclerViewAdapterTwo;
import com.example.shahid.Adapters.viewPagerAdapter;
import com.example.shahid.interfice.MoiveItemClickLisenter;
import com.example.shahid.interfice.MoviesItemClickListener;
import com.example.shahid.model.movies;
import com.example.shahid.model.moviesTwo;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class baseActivity extends AppCompatActivity implements MoiveItemClickLisenter, MoviesItemClickListener {

    ViewPager viewPager ;
    TabLayout tabLayout ;
    RecyclerView r_v_main ,r_v_main_two ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_two);

        viewPager = (ViewPager) findViewById(R.id.view_pager1);
        tabLayout = (TabLayout) findViewById(R.id.indicator);
        r_v_main = (RecyclerView) findViewById(R.id.recycler_view1);
        r_v_main_two = (RecyclerView) findViewById(R.id.recycler_view2);

            viewPagerAdapter pagerAdapter = new viewPagerAdapter(this);
            viewPager.setAdapter(pagerAdapter);

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new baseActivity.sliderTime(),3000,5000);
            tabLayout.setupWithViewPager(viewPager,true);


            //RecyclerView_one
        ArrayList<movies>movies_main = new ArrayList<>();

        movies_main.add(new movies("MEMORY",R.drawable.r_v_1,1));
        movies_main.add(new movies("THE GRAY MAN",R.drawable.r_v_2,2));
        movies_main.add(new movies("LA CASA",R.drawable.r_v_3,3));
        movies_main.add(new movies("MEMORY",R.drawable.r_v_1,1));
        movies_main.add(new movies("THE GRAY MAN",R.drawable.r_v_2,2));
        movies_main.add(new movies("LA CASA",R.drawable.r_v_3,3));
        movies_main.add(new movies("MEMORY",R.drawable.r_v_1,1));
        movies_main.add(new movies("THE GRAY MAN",R.drawable.r_v_2,2));
        movies_main.add(new movies("LA CASA",R.drawable.r_v_3,3));
        movies_main.add(new movies("MEMORY",R.drawable.r_v_1,1));

        RecyclerViewAdapter viewAdapter = new RecyclerViewAdapter(this,movies_main,this);

        r_v_main.setAdapter(viewAdapter);
        r_v_main.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        r_v_main.setHasFixedSize(true);


        //RecyclerView_two

        ArrayList<moviesTwo> moviesTwo_main = new ArrayList<>();

        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_2,"the gary man"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_3,"la casa"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_2,"the gary man"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_2,"the gary man"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_3,"la casa"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_2,"the gary man"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_2,"the gary man"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_3,"la casa"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_2,"the gary man"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_2,"the gary man"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_3,"la casa"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_2,"the gary man"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_2,"the gary man"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_3,"la casa"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_2,"the gary man"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_2,"the gary man"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_3,"la casa"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_2,"the gary man"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_2,"the gary man"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_3,"la casa"));
        moviesTwo_main.add(new moviesTwo(R.drawable.r_v_2,"the gary man"));


        RecyclerViewAdapterTwo adapterTwo = new RecyclerViewAdapterTwo(this,moviesTwo_main,this);

        r_v_main_two.setAdapter(adapterTwo);
        RecyclerView.LayoutManager lm = new GridLayoutManager(this,2);
        r_v_main_two.setLayoutManager(lm);
        r_v_main_two.setHasFixedSize(true);


    }


    //listener Rv one
    @Override
    public void OnMovieClick(movies movie, ImageView movieImageView) {

        Intent intent = new Intent(baseActivity.this,details_movies.class);

        intent.putExtra("name_film",movie.getName_movie());
        intent.putExtra("image_film",movie.getImg_movie());
        intent.putExtra("idItem",movie.getId_item());


        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(baseActivity.this,movieImageView,"sharedName");

        startActivity(intent,options.toBundle());

    }



    //listener Rv two

    @Override
    public void itemClickListener_rv_2(moviesTwo moviesTwo, ImageView imageView) {

        Intent intent = new Intent(baseActivity.this,details_movies_two.class);

        intent.putExtra("name_film_two",moviesTwo.getName_movie_1());
        intent.putExtra("image_film_two",moviesTwo.getImage_movie_2());

       startActivity(intent);

    }



    class sliderTime extends TimerTask{

        @Override
        public void run() {

            baseActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem()<3){
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    }
                    else
                        viewPager.setCurrentItem(0);
                }
            });
        }
    }



}