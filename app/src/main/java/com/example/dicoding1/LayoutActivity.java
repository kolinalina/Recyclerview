package com.example.dicoding1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Shop");
        }
    }
}
