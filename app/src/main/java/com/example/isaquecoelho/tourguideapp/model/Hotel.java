package com.example.isaquecoelho.tourguideapp.model;

public class Hotel {

    private int hotelImage;
    private String hotelName;
    private String hotelAvaliation;
    private String hotelPrice;
    private String hotelLink;

    public Hotel(int hotelImage, String hotelName, String hotelAvaliation, String hotelPrice, String hotelLink) {
        this.hotelImage = hotelImage;
        this.hotelName = hotelName;
        this.hotelAvaliation = hotelAvaliation;
        this.hotelPrice = hotelPrice;
        this.hotelLink = hotelLink;
    }

    public int getHotelImage() {
        return hotelImage;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelAvaliation() {
        return hotelAvaliation;
    }

    public String getHotelPrice() {
        return hotelPrice;
    }

    public String getHotelLink() {
        return hotelLink;
    }
}
