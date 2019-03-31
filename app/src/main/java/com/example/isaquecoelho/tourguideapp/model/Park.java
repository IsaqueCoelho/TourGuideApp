package com.example.isaquecoelho.tourguideapp.model;

public class Park {

    private String parkName;
    private String parkAvaliation;
    private String parkLatitude;
    private String parkLongitude;

    public Park(String parkName, String parkAvaliation, String parkLatitude, String parkLongitude) {
        this.parkName = parkName;
        this.parkAvaliation = parkAvaliation;
        this.parkLatitude = parkLatitude;
        this.parkLongitude = parkLongitude;
    }

    public String getParkName() {
        return parkName;
    }

    public String getParkAvaliation() {
        return parkAvaliation;
    }

    public String getParkLatitude() {
        return parkLatitude;
    }

    public String getParkLongitude() {
        return parkLongitude;
    }
}
