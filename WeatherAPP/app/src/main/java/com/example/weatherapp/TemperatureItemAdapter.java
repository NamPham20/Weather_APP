package com.example.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TemperatureItemAdapter extends RecyclerView.Adapter<TemperatureItemAdapter.TemperatureItemViewHolder> {

    Context context;
    List<TemperatureItem> temperatureItemList;

    TemperatureItemAdapter(Context context){
        this.context =context;
    }

    public void setData(List<TemperatureItem> temperatureItemList){
        this.temperatureItemList =temperatureItemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TemperatureItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.temperature_item,parent,false);
        return new  TemperatureItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TemperatureItemViewHolder holder, int position) {
        TemperatureItem temperatureItem = temperatureItemList.get(position);
        if(temperatureItem == null){
            return;
        }
        holder.tvDayName.setText(temperatureItem.getDayName());
        holder.imvWeatherIcon.setImageResource(temperatureItem.getResourceWeatherIcon());
        holder.tvTemValue.setText((temperatureItem.getTemValue()));

    }

    @Override
    public int getItemCount() {
        if(temperatureItemList!=null)
        {
            return temperatureItemList.size();
        }
        return 0;
    }

    public static class TemperatureItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvDayName;
        ImageView imvWeatherIcon;
        TextView tvTemValue;

        public TemperatureItemViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDayName= itemView.findViewById(R.id.tvDayName);
            imvWeatherIcon = itemView.findViewById(R.id.imvWeatherIcon);
            tvTemValue = itemView.findViewById(R.id.tvTemValue);
        }
    }
}
