package com.example.firstandroidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";
    ArrayList<String> listCity = new ArrayList<String>();
    CheckBox pressureCheckbox;
    CheckBox windCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate");

        initView();
        if (savedInstanceState != null && savedInstanceState.containsKey("windCheckBox"))
            windCheckbox.setChecked(savedInstanceState.getBoolean("windCheckBox"));
        if (savedInstanceState != null && savedInstanceState.containsKey("pressureCheckBox"))
            pressureCheckbox.setChecked(savedInstanceState.getBoolean("pressureCheckBox"));

        setInitialCity();
        setInitRecyclerView();
    }

    private  void initView(){
        windCheckbox = findViewById(R.id.checkbox_wind_speed);
        pressureCheckbox = findViewById(R.id.checkbox_pressure);
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState){
        initView();
        saveInstanceState.putBoolean("windCheckBox", windCheckbox.isChecked());
        saveInstanceState.putBoolean("pressureCheckBox", pressureCheckbox.isChecked());

        super.onSaveInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(),"onSaveInstanceState()",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onSaveInstanceState");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Toast.makeText(this, "onConfigurationChanged", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onConfigurationChanged");
    }

    @Override
    protected void onUserLeaveHint()
    {
        Toast.makeText(this, "Home button pressed", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"Home button pressed");
        super.onUserLeaveHint();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart()",Toast.LENGTH_SHORT).show();
        Log.d(TAG," onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume()", Toast.LENGTH_SHORT).show();
        Log.d(TAG," onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG," onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG," onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart", Toast.LENGTH_SHORT).show();
        Log.d(TAG," onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG," onDestroy");
    }

    private void setInitRecyclerView(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        // создаем адаптер
        CityAdapter adapter = new CityAdapter(this, listCity);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }

    private void setInitialCity(){
        listCity.add("Москва");
        listCity.add("Санкт-петербург");
        listCity.add("Екатеринбург");
        listCity.add("Владивосток");
    }
}