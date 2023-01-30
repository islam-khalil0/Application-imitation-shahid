package com.example.shahid.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shahid.interfice.MoiveItemClickLisenter;
import com.example.shahid.R;
import com.example.shahid.model.movies;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder> {


    Context context ;
    ArrayList<movies> moviesArrayList = new ArrayList<>();
    MoiveItemClickLisenter moiveItemClick;


    public RecyclerViewAdapter(Context context, ArrayList<movies> moviesArrayList, MoiveItemClickLisenter lisenter) {
        this.context = context;
        this.moviesArrayList = moviesArrayList;
        this.moiveItemClick = lisenter;
    }


    @NonNull
    @Override
    public RecyclerViewAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view1,parent,false);
        viewHolder viewHolder = new viewHolder(view);
        return viewHolder ;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.viewHolder holder, int position) {
        movies movies = moviesArrayList.get(position);

        holder.textView.setText(movies.getName_movie());
        holder.imageView.setImageResource(movies.getImg_movie());
    }



    @Override
    public int getItemCount() {
        return moviesArrayList.size();
    }



    public class viewHolder extends RecyclerView.ViewHolder {

       private TextView textView ;
       private ImageView imageView ;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.rv_text);
            imageView = itemView.findViewById(R.id.r_v_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    moiveItemClick.OnMovieClick(moviesArrayList.get(getAdapterPosition()),imageView);

                }
            });

        }
    }


}
