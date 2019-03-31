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
import android.widget.Toast;

import com.example.isaquecoelho.tourguideapp.R;
import com.example.isaquecoelho.tourguideapp.adapter.ParkAdapter;
import com.example.isaquecoelho.tourguideapp.model.Park;
import com.example.isaquecoelho.tourguideapp.viewModel.ParkViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParkFragment extends Fragment {

    private ParkViewModel mParkViewModel;
    private ParkAdapter mParkAdapter;

    @BindView(R.id.recyclerview_parklist)
    RecyclerView recyclerViewParkList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View parkView = inflater.inflate(R.layout.park_fragment, container, false);
        ButterKnife.bind(this, parkView);

        return parkView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mParkViewModel = ViewModelProviders.of(this).get(ParkViewModel.class);

        mParkViewModel.init(getContext());
        mParkViewModel.getmParkList().observe(this, new Observer<List<Park>>() {
            @Override
            public void onChanged(@Nullable List<Park> parks) {
                mParkAdapter.notifyDataSetChanged();
            }
        });
        
        initRecyclerView();
    }

    private void initRecyclerView() {

        mParkAdapter = new ParkAdapter(mParkViewModel.getmParkList().getValue(), new ParkAdapter.CardViewOnClickListener() {
            @Override
            public void cardOnClick(String query) {
                try {
                    Uri geoUri = Uri.parse(query);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                } catch (Exception exception){
                    Toast.makeText(getContext(), R.string.error_toast_no_mapapp_installed, Toast.LENGTH_LONG).show();
                }
            }
        });

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerViewParkList.setLayoutManager(linearLayoutManager);
        recyclerViewParkList.setAdapter(mParkAdapter);
    }

}
