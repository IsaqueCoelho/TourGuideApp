package com.example.isaquecoelho.tourguideapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.isaquecoelho.tourguideapp.R;
import com.example.isaquecoelho.tourguideapp.model.Restaurant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private List<Restaurant> mRestaurantList;
    private CardViewOnClickListener mCardViewOnClickListener;

    public RestaurantAdapter(List<Restaurant> mRestaurantList, CardViewOnClickListener mCardViewOnClickListener) {
        this.mRestaurantList = mRestaurantList;
        this.mCardViewOnClickListener = mCardViewOnClickListener;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View restaurantView =
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_restaurant, viewGroup, false);
        return new RestaurantViewHolder(restaurantView);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder restaurantViewHolder, int position) {
        final Restaurant restaurant = mRestaurantList.get(position);

        restaurantViewHolder.textViewRestaurantName.setText(restaurant.getRestaurantName());
        restaurantViewHolder.textViewRestaurantAvaliation.setText(restaurant.getRestaurantAvaliation());
        restaurantViewHolder.textViewRestaurantSchedule.setText(restaurant.getRestaurantSchedule());
        restaurantViewHolder.cardViewRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String queryLatLon =
                        restaurant.getRestaurantLatitude() + "," + restaurant.getRestaurantLongitude();

                String query = "geo:"
                        + queryLatLon
                        + "?q="
                        + queryLatLon
                        + "(" + restaurant.getRestaurantName() + ")";

                mCardViewOnClickListener.cardOnClick(query);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mRestaurantList.size();
    }

    class RestaurantViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.cardview_restaurant)
        CardView cardViewRestaurant;

        @BindView(R.id.textview_restaurantname)
        TextView textViewRestaurantName;

        @BindView(R.id.textview_restaurantavaliation)
        TextView textViewRestaurantAvaliation;

        @BindView(R.id.textview_restalrantschedule)
        TextView textViewRestaurantSchedule;

        RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface CardViewOnClickListener{
        void cardOnClick(String query);
    }
}
