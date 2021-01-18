package com.example.firstandroidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firstandroidproject.adapters.CityAdapter;

import java.util.ArrayList;

import static com.example.firstandroidproject.SecondActivity.KEY_CITY;
import static com.example.firstandroidproject.SecondActivity.KEY_PRESSURE;
import static com.example.firstandroidproject.SecondActivity.KEY_WIND_SPEED;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";
    ArrayList<String> listCity = new ArrayList<String>();
    CheckBox pressureCheckbox;
    CheckBox windCheckbox;
    Button btnEnterCity;
    EditText editSearch;

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
        clickListener();
    }

    private  void initView(){
        windCheckbox = findViewById(R.id.checkbox_wind_speed);
        pressureCheckbox = findViewById(R.id.checkbox_pressure);
        btnEnterCity = findViewById(R.id.btnEnterCity);
        editSearch = findViewById(R.id.edit_search);
    }

    private void clickListener(){
        btnEnterCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    private void setInitRecyclerView(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        final CityAdapter.OnStateClickListener stateClickListener = new CityAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(String cities, int position) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(KEY_CITY, cities);
                intent.putExtra(KEY_WIND_SPEED, windCheckbox.isChecked());
                intent.putExtra(KEY_PRESSURE, pressureCheckbox.isChecked());
                startActivity(intent);
            }
        };

        // создаем адаптер
        CityAdapter adapter = new CityAdapter(this, listCity, stateClickListener);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
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

   /* @Override
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
*/


    private void setInitialCity(){
        listCity.add("Москва");
        listCity.add("Санкт-петербург");
        listCity.add("Екатеринбург");
        listCity.add("Владивосток");
    }
}