package com.example.isaquecoelho.tourguideapp.repository;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.example.isaquecoelho.tourguideapp.R;
import com.example.isaquecoelho.tourguideapp.model.Park;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkRepository {

    private Context context;
    private static ParkRepository parkRepositoryInstance;
    private ArrayList<Park> parkDataSet = new ArrayList<>();

    public static ParkRepository getInstance(){
        if (parkRepositoryInstance == null){
            parkRepositoryInstance = new ParkRepository();
        }
        return parkRepositoryInstance;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void clearParkDataSet(){
        parkDataSet.clear();
    }

    // Pretend to get data from a webservice or Firebase
    public MutableLiveData<List<Park>> getParkList(){

        buildParkList();
        MutableLiveData<List<Park>> ParkData = new MutableLiveData<>();
        ParkData.setValue(parkDataSet);

        return ParkData;
    }

    private void buildParkList() {

        List<String> parkNameList = Arrays.asList(context.getResources().getStringArray(R.array.array_park_name));
        List<String> parkAvaliationList = Arrays.asList(context.getResources().getStringArray(R.array.array_park_avaliation));
        List<String> parkLatitudeList = Arrays.asList(context.getResources().getStringArray(R.array.array_park_latitude));
        List<String> parkLongitudeList = Arrays.asList(context.getResources().getStringArray(R.array.array_park_longitude));

        for (int countItem = 0; countItem < parkNameList.size(); countItem++) {

            parkDataSet.add(new Park(
                    parkNameList.get(countItem),
                    parkAvaliationList.get(countItem) ,
                    parkLatitudeList.get(countItem),
                    parkLongitudeList.get(countItem)));

        }
    }
}
