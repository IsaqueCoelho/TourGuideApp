package com.example.isaquecoelho.tourguideapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.isaquecoelho.tourguideapp.R;
import com.example.isaquecoelho.tourguideapp.model.Park;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParkAdapter extends RecyclerView.Adapter<ParkAdapter.ParkViewHolder> {

    private List<Park> mParkList;
    private CardViewOnClickListener mCardViewOnClickListener;

    public ParkAdapter(List<Park> mParkList, CardViewOnClickListener mCardViewOnClickListener) {
        this.mParkList = mParkList;
        this.mCardViewOnClickListener = mCardViewOnClickListener;
    }

    @NonNull
    @Override
    public ParkViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View parkView =
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_park, viewGroup, false);

        return new ParkViewHolder(parkView);
    }

    @Override
    public void onBindViewHolder(@NonNull ParkViewHolder parkViewHolder, int position) {
        final Park park = mParkList.get(position);

        parkViewHolder.textViewParkName.setText(park.getParkName());
        parkViewHolder.textViewParkAvaliation.setText(park.getParkAvaliation());
        parkViewHolder.cardViewPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String queryLatLon =
                        park.getParkLatitude() + "," + park.getParkLongitude();

                String query = "geo:" + queryLatLon + "?q=" + queryLatLon;

                mCardViewOnClickListener.cardOnClick(query);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mParkList.size();
    }

    class ParkViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.cardview_park)
        CardView cardViewPark;

        @BindView(R.id.textview_parkname)
        TextView textViewParkName;

        @BindView(R.id.textview_parkavaliation)
        TextView textViewParkAvaliation;

        ParkViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface CardViewOnClickListener{
        void cardOnClick(String query);
    }
}
