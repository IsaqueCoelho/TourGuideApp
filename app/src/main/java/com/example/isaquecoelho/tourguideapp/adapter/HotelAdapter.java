package com.example.isaquecoelho.tourguideapp.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isaquecoelho.tourguideapp.R;
import com.example.isaquecoelho.tourguideapp.model.Hotel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private List<Hotel> mHotelList;
    private CardViewOnClickListener mCardViewOnClickListener;

    public HotelAdapter(List<Hotel> mHotelList, CardViewOnClickListener mCardViewOnClickListener) {
        this.mHotelList = mHotelList;
        this.mCardViewOnClickListener = mCardViewOnClickListener;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View hotelView =
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_hotel, viewGroup, false);
        return new HotelViewHolder(hotelView);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder hotelViewHolder, int position) {
        final Hotel hotel = mHotelList.get(position);

        hotelViewHolder.imageViewHotel.setImageResource(hotel.getHotelImage());
        hotelViewHolder.textViewHotelName.setText(hotel.getHotelName());
        hotelViewHolder.textViewHotelAvaliation.setText(hotel.getHotelAvaliation());
        hotelViewHolder.textViewHotelPrice.setText(hotel.getHotelPrice());

        hotelViewHolder.cardViewHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCardViewOnClickListener.cardViewClick(hotel.getHotelLink());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHotelList.size();
    }

    class HotelViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cardview_hotel)
        CardView cardViewHotel;

        @BindView(R.id.imageview_hotelimage)
        ImageView imageViewHotel;

        @BindView(R.id.textview_hotelname)
        TextView textViewHotelName;

        @BindView(R.id.textview_hotelavaliation)
        TextView textViewHotelAvaliation;

        @BindView(R.id.textview_hotelprice)
        TextView textViewHotelPrice;

        HotelViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface CardViewOnClickListener{
        void cardViewClick(String link);
    }
}
