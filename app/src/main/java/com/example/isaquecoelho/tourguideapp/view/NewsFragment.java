package com.example.isaquecoelho.tourguideapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.isaquecoelho.tourguideapp.R;
import com.example.isaquecoelho.tourguideapp.adapter.NewsAdapter;
import com.example.isaquecoelho.tourguideapp.model.News;
import com.example.isaquecoelho.tourguideapp.viewModel.NewsViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsFragment extends Fragment {

    private NewsViewModel mNewsViewModel;
    private NewsAdapter mNewsAdapter;

    @BindView(R.id.recyclerview_newslist)
    RecyclerView recyclerViewNewsList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View newsFragmentView = inflater.inflate(R.layout.news_fragment, container, false);
        ButterKnife.bind(this, newsFragmentView);

        return newsFragmentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mNewsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        // TODO: Use the ViewModel

        mNewsViewModel.init(getContext());
        mNewsViewModel.getNewsList().observe(this, new Observer<List<News>>() {
            @Override
            public void onChanged(@Nullable List<News> news) {
                mNewsAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView(){
        mNewsAdapter = new NewsAdapter(mNewsViewModel.getNewsList().getValue(), new NewsAdapter.CardViewOnClickListener() {
            @Override
            public void cardViewClick(String link) {
                String EXTRA_LINK = "LINK";

                Intent loadPageIntent = new Intent(getContext(), LoadPageActivity.class);
                loadPageIntent.putExtra(EXTRA_LINK, link);
                startActivity(loadPageIntent);
            }
        });

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerViewNewsList.setLayoutManager(linearLayoutManager);
        recyclerViewNewsList.setAdapter(mNewsAdapter);
    }

}
