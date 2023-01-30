package com.example.shahid.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shahid.interfice.MoviesItemClickListener;
import com.example.shahid.R;
import com.example.shahid.model.moviesTwo;

import java.util.ArrayList;

public class RecyclerViewAdapterTwo extends RecyclerView.Adapter<RecyclerViewAdapterTwo.viewHolderTwo> {

    Context context ;
    ArrayList<moviesTwo> moviesTwoArrayList = new ArrayList<>();
    MoviesItemClickListener moviesItemClickListener ;

    public RecyclerViewAdapterTwo(Context context, ArrayList<moviesTwo> moviesTwoArrayList, MoviesItemClickListener listener) {
        this.context = context;
        this.moviesTwoArrayList = moviesTwoArrayList;
        this.moviesItemClickListener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterTwo.viewHolderTwo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view_2,parent,false);
        viewHolderTwo viewHolderTwo = new viewHolderTwo(view);
        return viewHolderTwo ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterTwo.viewHolderTwo holder, int position) {

        moviesTwo moviesTwo = moviesTwoArrayList.get(position);

        holder.textView.setText(moviesTwo.getName_movie_1());
        holder.imageView.setImageResource(moviesTwo.getImage_movie_2());

    }


    @Override
    public int getItemCount() {
        return moviesTwoArrayList.size();
    }


    public class viewHolderTwo extends RecyclerView.ViewHolder {

        ImageView imageView ;
        TextView textView ;

        public viewHolderTwo(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image_r_v_2);
            textView = (TextView) itemView.findViewById(R.id.text_r_v_2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    moviesItemClickListener.itemClickListener_rv_2(moviesTwoArrayList.get(getAdapterPosition()),imageView);
                }
            });
        }
    }
}
