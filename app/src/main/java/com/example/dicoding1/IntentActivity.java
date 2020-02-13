package com.example.dicoding1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnintent1, btnintent2, btnintent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        btnintent1 = findViewById(R.id.btn_intent1);
        btnintent1.setOnClickListener(this);

        btnintent2 = findViewById(R.id.btn_intent2);
        btnintent2.setOnClickListener(this);

        btnintent3 = findViewById(R.id.btn_intent3);
        btnintent3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_intent1:
                Intent intent = new Intent(IntentActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_intent2:
                Intent intent1 = new Intent(IntentActivity.this, Intent2Activity.class);
                intent1.putExtra(Intent2Activity.EXTRA_NAME, "kolina");
                intent1.putExtra(Intent2Activity.EXTRA_AGE, 21);
                startActivity(intent1);
                break;
            case R.id.btn_intent3:
                String phone = "08977975209";
                Intent intent3 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + phone));
                startActivity(intent3);
        }
    }
}
