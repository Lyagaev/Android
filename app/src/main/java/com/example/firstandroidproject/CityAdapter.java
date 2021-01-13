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
    private final OnStateClickListener onClickListener;


    CityAdapter(Context context, List<String> cities, OnStateClickListener onClickListener) {
        this.cities = cities;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    public interface OnStateClickListener{
        void onStateClick(String cities, int position);
    }

    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item_city, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityAdapter.ViewHolder holder, final int position) {
        final String city = cities.get(position);
        holder.cityName.setText(city);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                onClickListener.onStateClick(city, position);
            }
        });
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