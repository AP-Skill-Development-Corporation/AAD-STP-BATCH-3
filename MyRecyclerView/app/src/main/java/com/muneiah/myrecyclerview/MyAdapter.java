package com.muneiah.myrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context ctx;
    String t[];
    int images[];
    //alt+insert for create a new constructor
    //or
    //right click on generate > constractor


    public MyAdapter(Context ctx, String[] t, int[] images) {
        this.ctx = ctx;
        this.t = t;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ctx).inflate(R.layout.row_disign,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.m_title.setText(t[position]);
        holder.poster.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView m_title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            poster=itemView.findViewById(R.id.movie_poster);
            m_title=itemView.findViewById(R.id.movie_title);
        }
    }
}
