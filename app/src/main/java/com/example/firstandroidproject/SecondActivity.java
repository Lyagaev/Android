package com.example.firstandroidproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public static String KEY_CITY="keyCity";
    public static String KEY_WIND_SPEED="keyWindSpeed";
    public static String KEY_PRESSURE="keyPressure";
    private String city;
    private Boolean Pressure;
    private Boolean WindSpeed;
    TextView textViewCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        city = getIntent().getStringExtra(KEY_CITY);
        Pressure = getIntent().getBooleanExtra(KEY_PRESSURE, false);
        WindSpeed = getIntent().getBooleanExtra(KEY_WIND_SPEED, false);
        textViewCity.setText(city);
    }

    private void initView(){
        textViewCity = findViewById(R.id.textViewCity);
    }
}
