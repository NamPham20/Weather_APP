package com.example.weatherapp.addNewCity;

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
import com.example.weatherapp.TemperatureItem;
import com.example.weatherapp.TemperatureItemAdapter;

import java.util.List;

public class CityItemAdapter extends RecyclerView.Adapter<CityItemAdapter.CityItemViewHolder> {

    Context context;
    List<CityItem> cityItemList;

    public CityItemAdapter(Context context) {
        this.context = context;
    }
    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<CityItem> cityItemList){
        this.cityItemList =cityItemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CityItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item,parent,false);
        return new CityItemAdapter.CityItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityItemViewHolder holder, int position) {
        CityItem cityItem = cityItemList.get(position);
        if(cityItem==null){
            return;
        }
        holder.tvCityName.setText(cityItem.getNameCity());
        holder.tvCountryName.setText(cityItem.getNameCountry());
        holder.imvAddCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if (cityItemList!=null){
            return cityItemList.size();
        }
        return 0;
    }

    public static class CityItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvCityName;
        TextView tvCountryName;

        ImageView imvAddCity;

        public CityItemViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCityName= itemView.findViewById(R.id.tvCityName);
            tvCountryName= itemView.findViewById(R.id.tvCountryName);
            imvAddCity = itemView.findViewById(R.id.imvAddCity);
        }
    }
}
