package com.example.isaquecoelho.tourguideapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.isaquecoelho.tourguideapp.R;
import com.example.isaquecoelho.tourguideapp.adapter.HotelAdapter;
import com.example.isaquecoelho.tourguideapp.model.Hotel;
import com.example.isaquecoelho.tourguideapp.viewModel.HotelViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotelFragment extends Fragment {

    private HotelViewModel mHotelViewModel;
    private HotelAdapter mHotelAdapter;

    @BindView(R.id.recyclerview_hotellist)
    RecyclerView recyclerViewHotelList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View hotelFragmentView = inflater.inflate(R.layout.hotel_fragment, container, false);
        ButterKnife.bind(this, hotelFragmentView);

        return hotelFragmentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mHotelViewModel = ViewModelProviders.of(this).get(HotelViewModel.class);
        // TODO: Use the ViewModel

        mHotelViewModel.init(getContext());
        mHotelViewModel.getmHotelList().observe(this, new Observer<List<Hotel>>() {
            @Override
            public void onChanged(@Nullable List<Hotel> hotels) {
                mHotelAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView(){
        mHotelAdapter = new HotelAdapter(mHotelViewModel.getmHotelList().getValue(), new HotelAdapter.CardViewOnClickListener() {
            @Override
            public void cardViewClick(String link) {
                String EXTRA_LINK = "LINK";

                Intent loadPageIntent = new Intent(getContext(), LoadPageActivity.class);
                loadPageIntent.putExtra(EXTRA_LINK, link);
                startActivity(loadPageIntent);
            }
        });

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerViewHotelList.setLayoutManager(linearLayoutManager);
        recyclerViewHotelList.setAdapter(mHotelAdapter);
    }

}
