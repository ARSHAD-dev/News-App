package com.example.newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    public static final String TAG="Adapter";
    Context context;
    NewsListener listener;

    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList, NewsListener listener) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
        this.listener = listener;
    }

    ArrayList<ModelClass> modelClassArrayList;

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG, "onClick:+++ ");
               // listener.onNewsClicked(modelClassArrayList.get(position).getUrl());
            }
        });
        holder.mheading.setOnClickListener(view -> {
            Log.i(TAG, "onClick:+++ ");
            listener.onNewsClicked(modelClassArrayList.get(position).getUrl());
        });
        holder.mtime.setText("Publish At:-" + modelClassArrayList.get(position).getPublishedAt());
        holder.mheading.setText(modelClassArrayList.get(position).getTitle());
        holder.mauthor.setText(modelClassArrayList.get(position).getAuthor());
        holder.mcontent.setText(modelClassArrayList.get(position).getDescription());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mauthor, mtime, mcontent, mheading;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mcontent = itemView.findViewById(R.id.content);
            mauthor = itemView.findViewById(R.id.author);
            mtime = itemView.findViewById(R.id.time);
            mheading = itemView.findViewById(R.id.mainheading);
            imageView = itemView.findViewById(R.id.imageview);
            cardView = itemView.findViewById(R.id.cardview);

        }
    }
}
