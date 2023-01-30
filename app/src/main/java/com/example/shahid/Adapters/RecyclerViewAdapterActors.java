package com.example.shahid.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shahid.R;
import com.example.shahid.model.actors;

import java.util.ArrayList;

public class RecyclerViewAdapterActors extends RecyclerView.Adapter<RecyclerViewAdapterActors.viewHolderActors> {

    Context context ;
    ArrayList<actors>actorsArrayList = new ArrayList<>();

    public RecyclerViewAdapterActors(Context context, ArrayList<actors> actorsArrayList) {
        this.context = context;
        this.actorsArrayList = actorsArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterActors.viewHolderActors onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item_actors,parent,false);
        viewHolderActors viewHolderActors = new viewHolderActors(view);
        return viewHolderActors ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterActors.viewHolderActors holder, int position) {
        actors actors = actorsArrayList.get(position);

        holder.textView.setText(actors.getName_actor());
        holder.imageView.setImageResource(actors.getImage_actor());

    }

    @Override
    public int getItemCount() {
        return actorsArrayList.size();
    }

    public class viewHolderActors extends RecyclerView.ViewHolder {

        ImageView imageView ;
        TextView textView ;

        public viewHolderActors(@NonNull View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.text_actor);
            imageView = (ImageView) itemView.findViewById(R.id.image_actor);

        }
    }
}
