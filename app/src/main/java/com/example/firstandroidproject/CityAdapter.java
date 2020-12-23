package com.example.firstandroidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<String> cities;

    CityAdapter(Context context, List<String> cities) {
        this.cities = cities;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item_city, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityAdapter.ViewHolder holder, int position) {
        String city = cities.get(position);
        holder.cityName.setText(city);
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView cityName;
        ViewHolder(View view){
            super(view);
            cityName = (TextView) view.findViewById(R.id.city_name);
        }
    }
}