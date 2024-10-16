package com.example.assu2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<News> newsList;

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_add_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.titleTextView.setText(news.getTitle());
        holder.descriptionTextView.setText(news.getDescription());
        holder.dateTextView.setText(news.getDate());
        holder.timeTextView.setText(news.getTime());
        holder.imageView.setImageResource(news.getImageResource());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, descriptionTextView, dateTextView, timeTextView;
        ImageView imageView;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.news_title_input);
            descriptionTextView = itemView.findViewById(R.id.news_description_input);
            dateTextView = itemView.findViewById(R.id.news_date_input);
            timeTextView = itemView.findViewById(R.id.news_time_input);
            imageView = itemView.findViewById(R.id.selected_image_preview);
        }
    }
}
