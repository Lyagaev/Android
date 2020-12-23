package com.example.firstandroidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listCity = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        setInitialCity();
        setInitRecyclerView();
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