package com.example.weatherapp.listCityWeather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.weatherapp.MainActivity;
import com.example.weatherapp.R;

import java.util.ArrayList;
import java.util.List;

public class ListCityWeather extends AppCompatActivity {

    private ImageView imvBackToMainScreen;
    private RecyclerView rcvListCityWeather;

    CityWeatherItemAdapter cityWeatherItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_city_weather);
        init();

        cityWeatherItemAdapter = new CityWeatherItemAdapter(this);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvListCityWeather.setLayoutManager(linearLayoutManager);
        cityWeatherItemAdapter.setData(getCityWeatherList());


        imvBackToMainScreen. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityWeather.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }

    private List<CityWeatherItem> getCityWeatherList() {
        List<CityWeatherItem> cityWeatherItemList = new ArrayList<>();



        return cityWeatherItemList;
    }

    public void init(){
        imvBackToMainScreen = findViewById(R.id.imvBackToMainScreen);
        rcvListCityWeather = findViewById(R.id.rcvListCityWeather);
    }
}