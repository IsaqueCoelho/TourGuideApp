package com.example.isaquecoelho.tourguideapp.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.isaquecoelho.tourguideapp.model.Hotel;
import com.example.isaquecoelho.tourguideapp.repository.HotelRepository;

import java.util.List;

public class HotelViewModel extends ViewModel {

    private MutableLiveData<List<Hotel>> mHotelList;

    public void init(Context context){
        if (mHotelList != null){
            return;
        }

        HotelRepository mHotelRepository = HotelRepository.getInstance();
        mHotelRepository.setContext(context);
        mHotelRepository.clearHotelList();
        mHotelList = mHotelRepository.getHotelList();
    }

    public LiveData<List<Hotel>> getmHotelList() {
        return mHotelList;
    }
}
