package com.example.shahid.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.shahid.R;

public class viewPagerAdapter extends PagerAdapter {

    LayoutInflater inflater ;
    Context context ;


    public String [] name_film = {

            "film_1",
            "film_2",
            "film_1",
            "film_2"
    };


    public int [] page_film = {
            R.drawable.move1,
            R.drawable.move2,
            R.drawable.move1,
            R.drawable.move2
    };



    public viewPagerAdapter (Context context){
        this.context = context ;
    }


    @Override
    public int getCount() {
        return name_film.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        inflater  =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_slider_movies,container,false);

        ImageView imageView = (ImageView) view.findViewById(R.id.image_item_view_pager1);
        TextView textView = (TextView) view.findViewById(R.id.text_item_view_pager1);

        textView.setText(name_film[position]);
        imageView.setImageResource(page_film[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);

    }
}
