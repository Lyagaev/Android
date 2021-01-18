package com.example.firstandroidproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.firstandroidproject.R;

import java.util.List;

public class TemperatureNextDaysAdapter extends RecyclerView.Adapter<TemperatureNextDaysAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<TemperatureNextDaysAdapter.TemperatureNextDay> temperatureNextDays;



    public TemperatureNextDaysAdapter(Context context, List<TemperatureNextDaysAdapter.TemperatureNextDay> temperatureNextDays) {
        this.temperatureNextDays = temperatureNextDays;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public TemperatureNextDaysAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_fragment_temperature_next_days, parent, false);
        return new TemperatureNextDaysAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TemperatureNextDaysAdapter.ViewHolder holder, final int position) {
        final TemperatureNextDaysAdapter.TemperatureNextDay temperatureNextDay = temperatureNextDays.get(position);
        holder.nextDay.setText(temperatureNextDay.day);
        holder.nextTemperature.setText(temperatureNextDay.temperature);
        holder.nextWindSpeed.setText(temperatureNextDay.windSpeed);
        holder.nextPressure.setText(temperatureNextDay.pressure);
    }

    @Override
    public int getItemCount() {
        return temperatureNextDays.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView nextDay;
        final TextView nextTemperature;
        final TextView nextWindSpeed;
        final TextView nextPressure;

        ViewHolder(View view){
            super(view);
            nextDay = (TextView) view.findViewById(R.id.textViewNextDay);
            nextTemperature = (TextView) view.findViewById(R.id.textViewNextTemperature);
            nextWindSpeed = (TextView) view.findViewById(R.id.textViewNextWindSpeed);
            nextPressure = (TextView) view.findViewById(R.id.textViewNextPressure);
        }
    }

    public static class TemperatureNextDay{
        private String day;
        private String temperature;
        private String windSpeed;
        private String pressure;


        public TemperatureNextDay(String day, String temperature, String windSpeed, String pressure) {
            this.day=day;
            this.temperature=temperature;
            this.windSpeed=windSpeed;
            this.pressure=pressure;
        }
    }
}
