package com.example.isaquecoelho.tourguideapp.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.isaquecoelho.tourguideapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottomnavigationview_main)
    BottomNavigationView bottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            settingFragmentTransaction(item.getItemId());
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        listeningView();
        settingBottomNavigationStartItem();
    }

    private void listeningView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void settingBottomNavigationStartItem() {
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        mOnNavigationItemSelectedListener.onNavigationItemSelected(bottomNavigationView.getMenu().getItem(0));
    }

    private void settingFragmentTransaction(int menuItemSelected){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);

        switch (menuItemSelected){
            case R.id.bottomnavigation_news:
                bottomNavigationView.getMenu().getItem(0).setChecked(true);
                fragmentTransaction.replace(R.id.linearLayout_container, new NewsFragment());
                break;
            case R.id.bottomnavigation_hotels:
                bottomNavigationView.getMenu().getItem(1).setChecked(true);
                fragmentTransaction.replace(R.id.linearLayout_container, new HotelFragment());
                break;
            case R.id.bottomnavigation_restaurants:
                bottomNavigationView.getMenu().getItem(2).setChecked(true);
                fragmentTransaction.replace(R.id.linearLayout_container, new RestaurantFragment());
                break;
            case R.id.bottomnavigation_parks:
                bottomNavigationView.getMenu().getItem(3).setChecked(true);
                fragmentTransaction.replace(R.id.linearLayout_container, new ParkFragment());
                break;
            default:
                bottomNavigationView.getMenu().getItem(0).setChecked(true);
                fragmentTransaction.replace(R.id.linearLayout_container, new NewsFragment());
                break;
        }

        fragmentTransaction.commit();
    }

}
