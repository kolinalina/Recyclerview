package com.example.dicoding1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText panjang, lebar, tinggi;
    TextView hasil;
    Button hitung;
    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        panjang = findViewById(R.id.etpanjang);
        lebar = findViewById(R.id.etlebar);
        tinggi = findViewById(R.id.ettinggi);
        hitung = findViewById(R.id.btnhitung);
        hasil = findViewById(R.id.tvhasil);
        hitung.setOnClickListener(this);

        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            hasil.setText(result);
        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnhitung){
            String pjg = panjang.getText().toString().trim();
            String lbr = lebar.getText().toString().trim();
            String tngi = tinggi.getText().toString().trim();

            boolean isEmptyy = false;
            boolean isDouble = false;

            if (TextUtils.isEmpty(pjg)){
                isEmptyy = true;
                panjang.setError("Don't empty field");
            }

            if (TextUtils.isEmpty(lbr)){
                isEmptyy = true;
                lebar.setError("Don't empty field");
            }
            if (TextUtils.isEmpty(tngi)){
                isEmptyy = true;
                tinggi.setError("Don't empty field");
            }

            Double length = toDouble(pjg);
            Double width  = toDouble(lbr);
            Double height = toDouble(tngi);


            if (length == null){
                isDouble = true;
                panjang.setError("harus angka");
            }
            if (width == null){
                isDouble = true;
                lebar.setError("harus angka");
            }
            if (height == null){
                isDouble = true;
                tinggi.setError("harus angka");
            }

            if (!isEmptyy && !isDouble){
                double volume = length * width * height;
                
                hasil.setText(String.valueOf(volume));

            }

        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, hasil.getText().toString());
    }

    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
