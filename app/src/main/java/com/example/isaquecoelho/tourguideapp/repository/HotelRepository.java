package com.example.isaquecoelho.tourguideapp.repository;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.example.isaquecoelho.tourguideapp.R;
import com.example.isaquecoelho.tourguideapp.model.Hotel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotelRepository {

    private Context context;
    private static HotelRepository hotelRepositoryInstance;
    private ArrayList<Hotel> hotelDataSet = new ArrayList<>();

    public static HotelRepository getInstance(){
        if(hotelRepositoryInstance == null){
            hotelRepositoryInstance = new HotelRepository();
        }
        return hotelRepositoryInstance;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void clearHotelList(){
        hotelDataSet.clear();
    }

    // Pretend to get data from a webservice or Firebase
    public MutableLiveData<List<Hotel>> getHotelList(){

        buildHotelList();
        MutableLiveData<List<Hotel>> hotelData = new MutableLiveData<>();
        hotelData.setValue(hotelDataSet);

        return hotelData;
    }

    private void buildHotelList(){

        List<Integer> hotelImageList = new ArrayList<>();
        hotelImageList.add(R.drawable.ic_hotel_first);
        hotelImageList.add(R.drawable.ic_hotel_second);
        hotelImageList.add(R.drawable.ic_hotel_third);

        //I can't add this links in strings.xml, sorry =/
        List<String> hotelLinkList = new ArrayList<>();
        hotelLinkList.add("https://www.google.com/travel/hotels/Hortol%C3%A2ndia/entity/CgsIgMKDgNTh2rKgARAB?ap=KigKEglawSso0uY2wBEQ2xXHEJ1HwBISCUeMAHNu2jbAERDbFcePlkfAMAJahgEKBQjeAhAAIgNCUkwqFgoHCOMPEAQYBBIHCOMPEAQYBRgBKACwAQBYAYoBKAoSCSuW1ck55zbAERDbFbcvnUfAEhIJ2IEfHtbaNsARENsVt66WR8CaAQ4SDEhvcnRvbMOibmRpYaIBGQoJL20vMDQwaGRnEgxIb3J0b2zDom5kaWGSAQIgAQ&g2lb=4207876%2C4208993%2C4223281%2C4240602%2C4242081%2C4242836%2C4242898%2C4243604%2C4247061%2C4248641%2C4244079%2C4244566&hl=pt-BR&gl=br&un=0&q=hotel%20hortol%C3%A2ndia&rp=OAFAAEgC&ictx=1&ved=0CAwQqOACKABqFwoTCOjkgtikq-ECFQAAAAAdAAAAABB0&hrf=CgUI3gIQACIDQlJMKhYKBwjjDxAEGAQSBwjjDxAEGAUYASgAsAEAWAGKASgKEglawSso0uY2wBEQ2xXHEJ1HwBISCUeMAHNu2jbAERDbFcePlkfAmgEOEgxIb3J0b2zDom5kaWGiARkKCS9tLzA0MGhkZxIMSG9ydG9sw6JuZGlhkgECIAE&tcfs=EjMKCS9tLzA0MGhkZxIMSG9ydG9sw6JuZGlhGhgKCjIwMTktMDQtMDQSCjIwMTktMDQtMDVSAA");
        hotelLinkList.add("https://www.google.com/travel/hotels/Hortol%C3%A2ndia/entity/CgsIhOjNwtLv_LOhARAB?ap=KigKEglawSso0uY2wBEQ2xXHEJ1HwBISCUeMAHNu2jbAERDbFcePlkfAMAJahgEKBQjeAhAAIgNCUkwqFgoHCOMPEAQYBBIHCOMPEAQYBRgBKACwAQBYAYoBKAoSCSuW1ck55zbAERDbFbcvnUfAEhIJ2IEfHtbaNsARENsVt66WR8CaAQ4SDEhvcnRvbMOibmRpYaIBGQoJL20vMDQwaGRnEgxIb3J0b2zDom5kaWGSAQIgAQ&g2lb=4207876%2C4208993%2C4223281%2C4240602%2C4242081%2C4242836%2C4242898%2C4243604%2C4247061%2C4248641%2C4244079%2C4244566&hl=pt-BR&gl=br&un=0&q=hotel%20hortol%C3%A2ndia&rp=OAFAAEgC&ictx=1&ved=0CCgQqOACKAJqFwoTCOjkgtikq-ECFQAAAAAdAAAAABB0&hrf=CgUI3gIQACIDQlJMKhYKBwjjDxAEGAQSBwjjDxAEGAUYASgAsAEAWAGKASgKEglawSso0uY2wBEQ2xXHEJ1HwBISCUeMAHNu2jbAERDbFcePlkfAmgEOEgxIb3J0b2zDom5kaWGiARkKCS9tLzA0MGhkZxIMSG9ydG9sw6JuZGlhkgECIAE&tcfs=EjMKCS9tLzA0MGhkZxIMSG9ydG9sw6JuZGlhGhgKCjIwMTktMDQtMDQSCjIwMTktMDQtMDVSAA");
        hotelLinkList.add("https://www.google.com/travel/hotels/Hortol%C3%A2ndia/entity/CgsIm6WR59S4jIKaARAB?ap=KigKEglawSso0uY2wBEQ2xXHEJ1HwBISCUeMAHNu2jbAERDbFcePlkfAMAJahgEKBQjeAhAAIgNCUkwqFgoHCOMPEAQYBBIHCOMPEAQYBRgBKACwAQBYAYoBKAoSCSuW1ck55zbAERDbFbcvnUfAEhIJ2IEfHtbaNsARENsVt66WR8CaAQ4SDEhvcnRvbMOibmRpYaIBGQoJL20vMDQwaGRnEgxIb3J0b2zDom5kaWGSAQIgAQ&g2lb=4207876%2C4208993%2C4223281%2C4240602%2C4242081%2C4242836%2C4242898%2C4243604%2C4247061%2C4248641%2C4244079%2C4244566&hl=pt-BR&gl=br&un=0&q=hotel%20hortol%C3%A2ndia&rp=OAFAAEgC&ictx=1&ved=0CDYQqOACKANqFwoTCOjkgtikq-ECFQAAAAAdAAAAABB0&hrf=CgUI3gIQACIDQlJMKhYKBwjjDxAEGAQSBwjjDxAEGAUYASgAsAEAWAGKASgKEglawSso0uY2wBEQ2xXHEJ1HwBISCUeMAHNu2jbAERDbFcePlkfAmgEOEgxIb3J0b2zDom5kaWGiARkKCS9tLzA0MGhkZxIMSG9ydG9sw6JuZGlhkgECIAE&tcfs=EjMKCS9tLzA0MGhkZxIMSG9ydG9sw6JuZGlhGhgKCjIwMTktMDQtMDQSCjIwMTktMDQtMDVSAA");

        List<String> hotelNameList = Arrays.asList(context.getResources().getStringArray(R.array.array_hotel_name));
        List<String> hotelAvaliationList = Arrays.asList(context.getResources().getStringArray(R.array.array_hotel_avaliation));
        List<String> hotelPriceList = Arrays.asList(context.getResources().getStringArray(R.array.array_hotel_price));

        for (int countItem = 0; countItem < hotelImageList.size(); countItem++) {

            hotelDataSet.add(new Hotel(
                    hotelImageList.get(countItem),
                    hotelNameList.get(countItem),
                    hotelAvaliationList.get(countItem),
                    hotelPriceList.get(countItem),
                    hotelLinkList.get(countItem)
            ));
        }
    }
}
