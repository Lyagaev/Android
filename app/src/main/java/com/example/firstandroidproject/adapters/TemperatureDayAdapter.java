package com.example.firstandroidproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.firstandroidproject.R;
import java.util.List;

public class TemperatureDayAdapter extends RecyclerView.Adapter<TemperatureDayAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<TemperatureDay> temperatureDays;



    public TemperatureDayAdapter(Context context, List<TemperatureDay> temperatureDays) {
        this.temperatureDays = temperatureDays;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public TemperatureDayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_fragment_temperature_day, parent, false);
        return new TemperatureDayAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TemperatureDayAdapter.ViewHolder holder, final int position) {
        final TemperatureDay temperatureDay = temperatureDays.get(position);
        holder.dayTemperature.setText(temperatureDay.temperature);
        holder.dayTime.setText(temperatureDay.time);
    }

    @Override
    public int getItemCount() {
        return temperatureDays.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView dayTemperature;
        final TextView dayTime;

        ViewHolder(View view){
            super(view);
            dayTemperature = (TextView) view.findViewById(R.id.dayTemperature);
            dayTime = (TextView) view.findViewById(R.id.dayTime);
        }
    }

    public static class TemperatureDay{
        private String time;
        private String temperature;

        public TemperatureDay(String s, String s1) {
            this.temperature=s1;
            this.time=s;
        }
    }
}
