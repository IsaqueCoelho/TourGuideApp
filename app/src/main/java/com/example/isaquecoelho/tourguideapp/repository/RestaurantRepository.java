package com.example.isaquecoelho.tourguideapp.repository;

import android.arch.lifecycle.MutableLiveData;

import com.example.isaquecoelho.tourguideapp.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {

    private static RestaurantRepository restaurantRepositoryInstance;
    private ArrayList<Restaurant> restaurantDataSet = new ArrayList<>();

    public static RestaurantRepository getInsance(){
        if (restaurantRepositoryInstance == null){
            restaurantRepositoryInstance = new RestaurantRepository();
        }
        return restaurantRepositoryInstance;
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

        restaurantDataSet.add(new Restaurant(
                "D'Gust Bar & Restaurante",
                " 4.7 Stars",
                " Mon - Sat (11:00 am - 03:00 pm)",
                "-22.865545",
                "-47.214358"
        ));

        restaurantDataSet.add(new Restaurant(
                "Temakeria.com",
                " 4.5 Stars",
                " Sun - Sat (11:00am - 03:00 pm; 06:00am - 00:00)",
                "-22.870660",
                "-47.202180"
        ));

        restaurantDataSet.add(new Restaurant(
                "Malungo Burger",
                " 4.6 Stars",
                " Wed - Sat (06:00pm - 00:00pm)",
                "-22.865304",
                "-47.212358"
        ));

    }
}
