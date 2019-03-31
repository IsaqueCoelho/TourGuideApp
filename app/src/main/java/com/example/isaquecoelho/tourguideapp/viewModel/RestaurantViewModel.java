package com.example.isaquecoelho.tourguideapp.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.isaquecoelho.tourguideapp.model.Restaurant;
import com.example.isaquecoelho.tourguideapp.repository.RestaurantRepository;

import java.util.List;

public class RestaurantViewModel extends ViewModel {

    private MutableLiveData<List<Restaurant>> mRestaurantList;

    public void init(){
        if (mRestaurantList != null){
            return;
        }

        RestaurantRepository mRestaurantRepository = RestaurantRepository.getInsance();
        mRestaurantRepository.clearRestaurantList();
        mRestaurantList = mRestaurantRepository.getRestaurantList();
    }

    public LiveData<List<Restaurant>> getmRestaurantList() {
        return mRestaurantList;
    }
}
