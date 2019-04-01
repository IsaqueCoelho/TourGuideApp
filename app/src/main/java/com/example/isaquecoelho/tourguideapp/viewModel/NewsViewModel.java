package com.example.isaquecoelho.tourguideapp.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.isaquecoelho.tourguideapp.model.News;
import com.example.isaquecoelho.tourguideapp.repository.NewsRepository;

import java.util.List;

public class NewsViewModel extends ViewModel {

    private MutableLiveData<List<News>> mNewsList;

    public void init(Context context){
        if (mNewsList != null){
            return;
        }

        NewsRepository mNewsRepository = NewsRepository.getInstance();
        mNewsRepository.setContext(context);
        mNewsRepository.clearNewsList();
        mNewsList = mNewsRepository.getNewsList();
    }

    public LiveData<List<News>> getNewsList(){
        return mNewsList;
    }
}
