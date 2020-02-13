package com.example.dicoding1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Intent2Activity extends AppCompatActivity {
    public static final String EXTRA_NAME="name";
    public static final String EXTRA_AGE="age";
    TextView tvview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);

        tvview = findViewById(R.id.tv_view);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE,0);

        String text = "Name : " + name + "\nAND Age : " + age;
        tvview.setText(text);

    }
}
