package com.example.firstandroidproject.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstandroidproject.R;
import com.example.firstandroidproject.adapters.TemperatureDayAdapter;
import com.example.firstandroidproject.adapters.TemperatureNextDaysAdapter;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.getDrawable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TemperatureNextDaysFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TemperatureNextDaysFragment extends Fragment {

    RecyclerView recyclerViewNextDayTemperature;
    ArrayList<TemperatureNextDaysAdapter.TemperatureNextDay> temperatureNextDay = new ArrayList<TemperatureNextDaysAdapter.TemperatureNextDay>();
    // При создании фрагмента укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_temperature_next_days, container, false);
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
        TemperatureNextDaysAdapter adapter = new TemperatureNextDaysAdapter(getContext(), temperatureNextDay);

        // Будем работать со встроенным менеджером
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewNextDayTemperature.setLayoutManager(layoutManager);

        // Добавим разделитель карточек
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL);
        itemDecoration.setDrawable(getDrawable(getContext(), R.drawable.separator));
        recyclerViewNextDayTemperature.addItemDecoration(itemDecoration);

        // устанавливаем для списка адаптер
        recyclerViewNextDayTemperature.setAdapter(adapter);
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
        recyclerViewNextDayTemperature = view.findViewById(R.id.recyclerViewNextDayTemperature);
    }

    private void setInitialList(){
        temperatureNextDay.add(new TemperatureNextDaysAdapter.TemperatureNextDay("Сегодня", "-13/-21","6-11 м.с","800"));
        temperatureNextDay.add(new TemperatureNextDaysAdapter.TemperatureNextDay("Завтра", "-16/-26","6-11 м.с","800"));
        temperatureNextDay.add(new TemperatureNextDaysAdapter.TemperatureNextDay("20.01.2021", "-13/-17","6-11 м.с","800"));
        temperatureNextDay.add(new TemperatureNextDaysAdapter.TemperatureNextDay("21.01.2021", "-14/-21","6-11 м.с","800"));
        temperatureNextDay.add(new TemperatureNextDaysAdapter.TemperatureNextDay("22.01.2021", "-19/-25","6-11 м.с","800"));
        temperatureNextDay.add(new TemperatureNextDaysAdapter.TemperatureNextDay("23.01.2021", "-24/-33","6-11 м.с","800"));
        temperatureNextDay.add(new TemperatureNextDaysAdapter.TemperatureNextDay("24.01.2021", "-22/-26","6-11 м.с","800"));
        temperatureNextDay.add(new TemperatureNextDaysAdapter.TemperatureNextDay("25.01.2021", "-12/-23","6-11 м.с","800"));
        temperatureNextDay.add(new TemperatureNextDaysAdapter.TemperatureNextDay("26.01.2021", "-13/-21","6-11 м.с","800"));
    }
}