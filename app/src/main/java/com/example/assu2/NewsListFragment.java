package com.example.assu2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NewsListFragment extends Fragment {
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private List<News> newsList;

    public static NewsListFragment newInstance(ArrayList<News> newsList) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle args = new Bundle();
        args.putSerializable("newsList", newsList);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Retrieve the news list from the arguments
        if (getArguments() != null) {
            newsList = (ArrayList<News>) getArguments().getSerializable("newsList");
        } else {
            newsList = new ArrayList<>();
        }

        newsAdapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(newsAdapter);

        return view;
    }

    public void updateNewsList(List<News> updatedNewsList) {
        this.newsList = updatedNewsList;
        newsAdapter.notifyDataSetChanged();
    }
}
