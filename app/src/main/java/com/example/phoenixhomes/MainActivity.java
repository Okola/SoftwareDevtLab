package com.example.phoenixhomes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.phoenixhomes.databinding.ActivityMainBinding;


public class MainActivity extends DrawerBaseActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        setTitle("Home");
    }
}