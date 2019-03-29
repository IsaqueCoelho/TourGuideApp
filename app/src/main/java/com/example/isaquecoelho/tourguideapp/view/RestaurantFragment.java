package com.example.isaquecoelho.tourguideapp.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.isaquecoelho.tourguideapp.R;
import com.example.isaquecoelho.tourguideapp.viewModel.RestaurantViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantFragment extends Fragment {

    private RestaurantViewModel mViewModel;

    @BindView(R.id.textview_message)
    TextView textViewMessage;

    public static RestaurantFragment newInstance() {
        return new RestaurantFragment();
    }

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
        mViewModel = ViewModelProviders.of(this).get(RestaurantViewModel.class);
        // TODO: Use the ViewModel
    }

}
