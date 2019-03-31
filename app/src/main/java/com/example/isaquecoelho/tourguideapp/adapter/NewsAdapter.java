package com.example.isaquecoelho.tourguideapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isaquecoelho.tourguideapp.R;
import com.example.isaquecoelho.tourguideapp.model.News;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder>{

    private List<News> mNewsList;
    private CardViewOnClickListener mCardViewOnClickListener;

    public NewsAdapter(List<News> mNewsList, CardViewOnClickListener mCardViewOnClickListener) {
        this.mNewsList = mNewsList;
        this.mCardViewOnClickListener = mCardViewOnClickListener;
    }

    @NonNull
    @Override
    public NewsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View newsView =
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_news, viewGroup, false);
        return new NewsAdapterViewHolder(newsView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapterViewHolder newsAdapterViewHolder, final int position) {
        final News news = mNewsList.get(position);

        newsAdapterViewHolder.newsImage.setImageResource(news.getNewsImage());
        newsAdapterViewHolder.newsTitle.setText(news.getNewsTitle());
        newsAdapterViewHolder.newsDescription.setText(news.getNewsDescription());

        newsAdapterViewHolder.newsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCardViewOnClickListener.cardViewClick(news.getNewsLink());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    class NewsAdapterViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.cardview_news)
        CardView newsCardView;

        @BindView(R.id.imageview_newsimage)
        ImageView newsImage;

        @BindView(R.id.textview_newstitle)
        TextView newsTitle;

        @BindView(R.id.textview_newsdescription)
        TextView newsDescription;

        NewsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface CardViewOnClickListener{
        void cardViewClick(String link);
    }
}
