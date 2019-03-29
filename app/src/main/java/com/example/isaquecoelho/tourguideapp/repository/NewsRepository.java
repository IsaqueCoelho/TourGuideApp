package com.example.isaquecoelho.tourguideapp.repository;

import android.arch.lifecycle.MutableLiveData;

import com.example.isaquecoelho.tourguideapp.R;
import com.example.isaquecoelho.tourguideapp.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsRepository {


    private static NewsRepository instace;
    private ArrayList<News> newsDataSet = new ArrayList<>();

    public static NewsRepository getInstace(){
        if (instace == null){
            instace = new NewsRepository();
        }

        return instace;
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

        newsDataSet.add(new News(
                "Notícias de Hortolândia",
                "Dell está com nova oportunidade de emprego em Hortolândia",
                R.drawable.ic_news_first,
                "http://noticiasdehortolandia.com.br/cidade/dell-esta-com-nova-oportunidade-de-emprego-em-hortolandia/"
        ));

    }

}
