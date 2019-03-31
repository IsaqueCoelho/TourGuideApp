package com.example.isaquecoelho.tourguideapp.model;

public class Restaurant {

    private String restaurantName;
    private String restaurantAvaliation;
    private String restaurantSchedule;
    private String restaurantLatitude;
    private String restaurantLongitude;

    public Restaurant(String restaurantName, String restaurantAvaliation, String restaurantSchedule, String restaurantLatitude, String restaurantLongitude) {
        this.restaurantName = restaurantName;
        this.restaurantAvaliation = restaurantAvaliation;
        this.restaurantSchedule = restaurantSchedule;
        this.restaurantLatitude = restaurantLatitude;
        this.restaurantLongitude = restaurantLongitude;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getRestaurantAvaliation() {
        return restaurantAvaliation;
    }

    public String getRestaurantSchedule() {
        return restaurantSchedule;
    }

    public String getRestaurantLatitude() {
        return restaurantLatitude;
    }

    public String getRestaurantLongitude() {
        return restaurantLongitude;
    }
}
