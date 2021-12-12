package com.example.carz.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.carz.Fragments.HomeFragment;
import com.example.carz.Fragments.ProfileFragment;
import com.example.carz.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initlization();

    }

    private void initlization() {
        bottomNavigationView =findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment=null;
            switch (item.getItemId()){
                case R.id.home:
                    fragment= new HomeFragment();
                    break;
                case R.id.profile:
                    fragment= new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_navigation_container,fragment).commit();

            return true;
        });

        bottomNavigationView.setSelectedItemId(R.id.home);

//        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_navigation_container,new HomeFragment()).commit();
    }

//    private BottomNavigationView.OnNavigationItemReselectedListener bottomNavigationMethod=new
//            BottomNavigationView.OnNavigationItemReselectedListener() {
//                @Override
//                public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
//                    Fragment fragment=null;
//                    switch (menuItem.getItemId()){
//                        case R.id.home:
//                            fragment= new HomeFragment();
//                            break;
//                        case R.id.profile:
//                            fragment= new ProfileFragment();
//                            break;
//                    }
//                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_navigation_container,fragment).commit();
//
//                }
//            };
}