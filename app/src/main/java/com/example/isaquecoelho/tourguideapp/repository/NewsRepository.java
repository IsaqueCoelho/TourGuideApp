package com.example.isaquecoelho.tourguideapp.repository;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.example.isaquecoelho.tourguideapp.R;
import com.example.isaquecoelho.tourguideapp.model.News;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsRepository {

    private static NewsRepository instace;
    private Context context;
    private ArrayList<News> newsDataSet = new ArrayList<>();

    public static NewsRepository getInstace(){
        if (instace == null){
            instace = new NewsRepository();
        }

        return instace;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void clearNewsList(){
        newsDataSet.clear();
    }

    // Pretend to get data from a webservice or Firebase
    public MutableLiveData<List<News>> getNewsList(){

        buildNewsList();
        MutableLiveData<List<News>> newsData = new MutableLiveData<>();
        newsData.setValue(newsDataSet);

        return newsData;
    }

    private void buildNewsList(){

        List<String> descriptionList = Arrays.asList(context.getResources().getStringArray(R.array.array_news_description));
        List<String> linkList = Arrays.asList(context.getResources().getStringArray(R.array.array_news_description));
        List<Integer> imageList = new ArrayList<>();

        imageList.add(R.drawable.ic_news_first);
        imageList.add(R.drawable.ic_news_second);
        imageList.add(R.drawable.ic_news_third);
        imageList.add(R.drawable.ic_news_fourth);

        for (int countItem = 0; countItem < descriptionList.size(); countItem++) {

            newsDataSet.add(new News(
                    context.getString(R.string.array_news_title),
                    descriptionList.get(countItem),
                    imageList.get(countItem),
                    linkList.get(countItem)
            ));
        }
    }
}
