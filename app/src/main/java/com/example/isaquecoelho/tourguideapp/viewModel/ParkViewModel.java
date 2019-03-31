package com.example.isaquecoelho.tourguideapp.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.isaquecoelho.tourguideapp.model.Park;
import com.example.isaquecoelho.tourguideapp.repository.ParkRepository;

import java.util.List;

public class ParkViewModel extends ViewModel {

    private MutableLiveData<List<Park>> mParkList;

    public void init(Context context){
        if(mParkList != null){
            return;
        }

        ParkRepository parkRepository = ParkRepository.getInstance();
        parkRepository.setContext(context);
        parkRepository.clearParkDataSet();
        mParkList = parkRepository.getParkList();
    }

    public LiveData<List<Park>> getmParkList() {
        return mParkList;
    }
}
