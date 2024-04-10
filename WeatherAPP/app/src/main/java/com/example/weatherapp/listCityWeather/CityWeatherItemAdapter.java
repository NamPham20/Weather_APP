package com.example.weatherapp.listCityWeather;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.addNewCity.CityItemAdapter;

import java.util.List;

public class CityWeatherItemAdapter extends RecyclerView.Adapter<CityWeatherItemAdapter.CityWeatherItemViewHolder> {

    Context context;
    List<CityWeatherItem> cityWeatherItemList;

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<CityWeatherItem> cityWeatherItemList){
        this.cityWeatherItemList = cityWeatherItemList;
        notifyDataSetChanged();
    }


    public CityWeatherItemAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CityWeatherItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lcity_weather_item,parent,false);
        return new CityWeatherItemAdapter.CityWeatherItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityWeatherItemViewHolder holder, int position) {
        CityWeatherItem cityWeatherItem = cityWeatherItemList.get(position);
        if ((cityWeatherItem == null)) {

            return;
        }
        holder.tvTemValueItem.setText(cityWeatherItem.getTemValue());
        holder.tvLowHeightTemItem.setText((cityWeatherItem.getLowHeightTem()));
        holder.tvLocationItem.setText(cityWeatherItem.getAddress());
        holder.tvStatusWeatherItem.setText((cityWeatherItem.getStatusWeather()));
        holder.imvResourceImageItem.setImageResource(cityWeatherItem.getImageResource());
    }

    @Override
    public int getItemCount() {
        if(cityWeatherItemList !=null){
            return cityWeatherItemList.size();
        }
        return 0;
    }

    public static class CityWeatherItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvTemValueItem;
        TextView tvLowHeightTemItem;
        TextView tvLocationItem;
        TextView tvStatusWeatherItem;
        ImageView imvResourceImageItem;


        public CityWeatherItemViewHolder(@NonNull View itemView) {
            super(itemView);

             tvTemValueItem = itemView.findViewById(R.id.tvTemValueItem);
             tvLowHeightTemItem= itemView.findViewById(R.id.tvLowHeightTemItem);
             tvLocationItem= itemView.findViewById(R.id.tvLocationItem);
             tvStatusWeatherItem= itemView.findViewById(R.id.tvStatusWeatherItem);
             imvResourceImageItem= itemView.findViewById(R.id.imvResourceImageItem);
        }
    }
}
