package com.example.firstandroidproject.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstandroidproject.R;
import com.example.firstandroidproject.adapters.CityAdapter;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;


    private static final String TAG = "myLogs";
    ArrayList<String> listCity = new ArrayList<String>();
    CheckBox pressureCheckbox;
    CheckBox windCheckbox;
    Button btnEnterCity;
    TextInputEditText editSearch;

    View root;

    // Регулярные выражения позволяют проверить на соответствие шаблону
    // Это город. Все буквы
    Pattern checkCity = Pattern.compile("^[А-Я][а-я]{2,}$");

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        root = inflater.inflate(R.layout.fragment_gallery, container, false);

        initView();
        if (savedInstanceState != null && savedInstanceState.containsKey("windCheckBox"))
            windCheckbox.setChecked(savedInstanceState.getBoolean("windCheckBox"));
        if (savedInstanceState != null && savedInstanceState.containsKey("pressureCheckBox"))
            pressureCheckbox.setChecked(savedInstanceState.getBoolean("pressureCheckBox"));

        // Чтобы не докучать пользователю при вводе каждой буквы, сделаем проверку при потере фокуса
        editSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            // Как только фокус потерян, сразу проверяем на валидность данные
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) return;
                TextView tv = (TextView) v;
                // Это сама валидация, она вынесена в отдельный метод, чтобы не дублировать код
                // см вызов ниже
                validate(tv, checkCity, "Это не имя!");
            }
        });


        setInitialCity();
        setInitRecyclerView();
        clickListener();


        return root;
    }

    // Валидация
    private void validate(TextView tv, Pattern check, String message){
        String value = tv.getText().toString();
        if (check.matcher(value).matches()){    // Проверим на основе регулярных выражений
            hideError(tv);
        }
        else{
            showError(tv, message);
        }
    }

    // Показать ошибку
    private void showError(TextView view, String message) {
        view.setError(message);
    }

    // спрятать ошибку
    private void hideError(TextView view) {
        view.setError(null);
    }


    private  void initView(){
        windCheckbox =  root.findViewById(R.id.checkbox_wind_speed);
        pressureCheckbox =  root.findViewById(R.id.checkbox_pressure);
        btnEnterCity =  root.findViewById(R.id.btnEnterCity);
        editSearch =  root.findViewById(R.id.edit_search);
    }

    private void clickListener(){
        btnEnterCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    private void setInitRecyclerView(){
        final RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.list);

        final CityAdapter.OnStateClickListener stateClickListener = new CityAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(final String cities, int position) {
                Snackbar.make(recyclerView, "Вы выбрали город "+cities, Snackbar.LENGTH_LONG)
                        .setAction("Подтвердить", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                               /* Intent intent = new Intent(MainActivity22.this, SecondActivity.class);
                                intent.putExtra(KEY_CITY, cities);
                                intent.putExtra(KEY_WIND_SPEED, windCheckbox.isChecked());
                                intent.putExtra(KEY_PRESSURE, pressureCheckbox.isChecked());
                                startActivity(intent);*/
                            }
                        }).show();
            }

        /*Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(KEY_CITY, cities);
                intent.putExtra(KEY_WIND_SPEED, windCheckbox.isChecked());
                intent.putExtra(KEY_PRESSURE, pressureCheckbox.isChecked());
                startActivity(intent);*/

        };

        // создаем адаптер
        CityAdapter adapter = new CityAdapter(getContext(), listCity, stateClickListener);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState){
        initView();
        saveInstanceState.putBoolean("windCheckBox", windCheckbox.isChecked());
        saveInstanceState.putBoolean("pressureCheckBox", pressureCheckbox.isChecked());

        super.onSaveInstanceState(saveInstanceState);
    }


    private void setInitialCity(){
        listCity.add("Москва");
        listCity.add("Санкт-петербург");
        listCity.add("Екатеринбург");
        listCity.add("Владивосток");
    }
}