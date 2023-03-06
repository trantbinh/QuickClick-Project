package com.example.testapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testapplication.fragment.AccountFragment;
import com.example.testapplication.fragment.HomeFragment;
import com.example.testapplication.fragment.ShoppingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btnavView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnavView = findViewById(R.id.nevMenu);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Main");
        actionBar.setDisplayHomeAsUpEnabled(true);

        btnavView.setOnItemSelectedListener(getBtnListener());

    }

    @NonNull
    private NavigationBarView.OnItemSelectedListener getBtnListener() {
        return new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mnHome:
                        getSupportActionBar().setTitle(item.getTitle());
                        loadFragment(new HomeFragment());
                        return true;
                    case R.id.mnShopping:
                        getSupportActionBar().setTitle(item.getTitle());
                        loadFragment(new ShoppingFragment());
                        return true;
                    case R.id.mnAccount:
                        getSupportActionBar().setTitle(item.getTitle());
                        loadFragment(new AccountFragment());
                        return true;
                }
                return true;
            }

        };
    }


    ///load fragment
    void loadFragment (Fragment fmnew){
        FragmentTransaction fmDang = getSupportFragmentManager().beginTransaction();
        fmDang.replace(R.id.main_fragment,fmnew);
        fmDang.addToBackStack(null);
        fmDang.commit();
    }
}