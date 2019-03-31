package com.example.isaquecoelho.tourguideapp.repository;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.example.isaquecoelho.tourguideapp.R;
import com.example.isaquecoelho.tourguideapp.model.Restaurant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestaurantRepository {

    private Context context;
    private static RestaurantRepository restaurantRepositoryInstance;
    private ArrayList<Restaurant> restaurantDataSet = new ArrayList<>();

    public static RestaurantRepository getInsance(){
        if (restaurantRepositoryInstance == null){
            restaurantRepositoryInstance = new RestaurantRepository();
        }
        return restaurantRepositoryInstance;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void clearRestaurantList(){
        restaurantDataSet.clear();
    }

    // Pretend to get data from a webservice or Firebase
    public MutableLiveData<List<Restaurant>> getRestaurantList(){

        buildRestaurantList();
        MutableLiveData<List<Restaurant>> restaurantData = new MutableLiveData<>();
        restaurantData.setValue(restaurantDataSet);

        return restaurantData;
    }

    private void buildRestaurantList(){

        List<String> restaurantNameList = Arrays.asList(context.getResources().getStringArray(R.array.array_restaurant_name));
        List<String> restaurantAvaliationList = Arrays.asList(context.getResources().getStringArray(R.array.array_restaurant_avaliation));
        List<String> restaurantScheduleList = Arrays.asList(context.getResources().getStringArray(R.array.array_restaurant_schedule));
        List<String> restaurantLatitudeList = Arrays.asList(context.getResources().getStringArray(R.array.array_restaurant_latitude));
        List<String> restaurantLongitudeList = Arrays.asList(context.getResources().getStringArray(R.array.array_restaurant_longitude));

        for (int countItem = 0; countItem < restaurantNameList.size(); countItem++) {

            restaurantDataSet.add(new Restaurant(
                    restaurantNameList.get(countItem),
                    restaurantAvaliationList.get(countItem),
                    restaurantScheduleList.get(countItem),
                    restaurantLatitudeList.get(countItem),
                    restaurantLongitudeList.get(countItem)
            ));
        }
    }
}
