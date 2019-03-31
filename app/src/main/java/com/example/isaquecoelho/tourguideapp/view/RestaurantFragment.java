package com.example.isaquecoelho.tourguideapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
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
import com.example.isaquecoelho.tourguideapp.adapter.RestaurantAdapter;
import com.example.isaquecoelho.tourguideapp.model.Restaurant;
import com.example.isaquecoelho.tourguideapp.viewModel.RestaurantViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantFragment extends Fragment {

    private RestaurantViewModel mRestaurantViewModel;
    private RestaurantAdapter mRestaurantAdapter;

    @BindView(R.id.recyclerview_restaurantlist)
    RecyclerView recyclerViewRestaurantList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View restaurantFragmentView = inflater.inflate(R.layout.restaurant_fragment, container, false);
        ButterKnife.bind(this, restaurantFragmentView);

        return restaurantFragmentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRestaurantViewModel = ViewModelProviders.of(this).get(RestaurantViewModel.class);

        mRestaurantViewModel.init();
        mRestaurantViewModel.getmRestaurantList().observe(this, new Observer<List<Restaurant>>() {
            @Override
            public void onChanged(@Nullable List<Restaurant> restaurants) {
                mRestaurantAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView() {
        mRestaurantAdapter = new RestaurantAdapter(mRestaurantViewModel.getmRestaurantList().getValue(), new RestaurantAdapter.CardViewOnClickListener() {
            @Override
            public void cardOnClick(String query) {
                Uri geoUri = Uri.parse(query);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoUri);
                startActivity(mapIntent);
            }
        });

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerViewRestaurantList.setLayoutManager(linearLayoutManager);
        recyclerViewRestaurantList.setAdapter(mRestaurantAdapter);

    }

}
