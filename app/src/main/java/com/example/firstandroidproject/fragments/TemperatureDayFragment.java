package com.example.firstandroidproject.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstandroidproject.R;
import com.example.firstandroidproject.adapters.TemperatureDayAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TemperatureDayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TemperatureDayFragment extends Fragment {

    RecyclerView RecyclerViewDayTemperature;
    ArrayList<TemperatureDayAdapter.TemperatureDay> temperatureDay = new ArrayList<TemperatureDayAdapter.TemperatureDay>();
    // При создании фрагмента укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_temperature_day, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setInitialList();
        setInitRecyclerView(view);
    }

    private void setInitRecyclerView(View view){
               // создаем адаптер
        TemperatureDayAdapter adapter = new TemperatureDayAdapter(getContext(), temperatureDay);
        // устанавливаем для списка адаптер
        RecyclerViewDayTemperature.setAdapter(adapter);
    }

/*    // activity создана, можно к ней обращаться. Выполним начальные действия
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Определение, можно ли будет расположить рядом герб в другом фрагменте
        isExistCoatOfArms = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;

        // Если это не первое создание, то восстановим текущую позицию
        if (savedInstanceState != null) {
            // Восстановление текущей позиции.
            currentPosition = savedInstanceState.getInt("CurrentCity", 0);
        }

        // Если можно нарисовать рядом герб, то сделаем это
        if (isExistCoatOfArms) {
            listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showCoatOfArms();
        }
    }*/



    private void initViews(View view) {
        RecyclerViewDayTemperature = view.findViewById(R.id.recyclerViewDayTemperature);
    }

    private void setInitialList(){
        temperatureDay.add(new TemperatureDayAdapter.TemperatureDay("-11","00:00"));
        temperatureDay.add(new TemperatureDayAdapter.TemperatureDay("-11","01:00"));
        temperatureDay.add(new TemperatureDayAdapter.TemperatureDay("-12","02:00"));
        temperatureDay.add(new TemperatureDayAdapter.TemperatureDay("-13","03:00"));
        temperatureDay.add(new TemperatureDayAdapter.TemperatureDay("-14","04:00"));
        temperatureDay.add(new TemperatureDayAdapter.TemperatureDay("-14","05:00"));
        temperatureDay.add(new TemperatureDayAdapter.TemperatureDay("-14","06:00"));
        temperatureDay.add(new TemperatureDayAdapter.TemperatureDay("-15","07:00"));
        temperatureDay.add(new TemperatureDayAdapter.TemperatureDay("-13","08:00"));
        temperatureDay.add(new TemperatureDayAdapter.TemperatureDay("-12","09:00"));
        temperatureDay.add(new TemperatureDayAdapter.TemperatureDay("-12","10:00"));
        temperatureDay.add(new TemperatureDayAdapter.TemperatureDay("-11","11:00"));
        temperatureDay.add(new TemperatureDayAdapter.TemperatureDay("-10","12:00"));
    }

}