package com.example.shahid.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shahid.interfice.MovieItemClickListener;
import com.example.shahid.R;
import com.example.shahid.model.moviesTwo;

import java.util.ArrayList;

public class RecyclerViewAdapterOther extends RecyclerView.Adapter<RecyclerViewAdapterOther.viewHolderOther> {

    Context context ;
    ArrayList<moviesTwo> moviesTwoArrayList = new ArrayList<>();
    MovieItemClickListener moviesItemClickListener ;


    public RecyclerViewAdapterOther(Context context, ArrayList<moviesTwo> moviesTwoArrayList, MovieItemClickListener moviesItemClickListener) {
        this.context = context;
        this.moviesTwoArrayList = moviesTwoArrayList;
        this.moviesItemClickListener = moviesItemClickListener;
    }


    @NonNull
    @Override
    public RecyclerViewAdapterOther.viewHolderOther onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_other,parent,false);
        viewHolderOther viewHolderOther = new viewHolderOther(view);
        return  viewHolderOther ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterOther.viewHolderOther holder, int position) {
        moviesTwo moviesTwo = moviesTwoArrayList.get(position);

        holder.textView.setText(moviesTwo.getName_movie_1());
        holder.imageView.setImageResource(moviesTwo.getImage_movie_2());
    }

    @Override
    public int getItemCount() {
        return moviesTwoArrayList.size();
    }

    public class viewHolderOther extends RecyclerView.ViewHolder {

        TextView textView ;
        ImageView imageView ;

        public viewHolderOther(@NonNull View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.rv_text_other);
            imageView = (ImageView) itemView.findViewById(R.id.r_v_img_other);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    moviesItemClickListener.clickLListenerOther(moviesTwoArrayList.get(getAdapterPosition()),imageView);
                }
            });



        }
    }
}
