package com.example.weatherapp.api;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;

import com.example.weatherapp.MainActivity;
import com.example.weatherapp.SplashScreen;
import com.example.weatherapp.model.CityInformation;
import com.example.weatherapp.model.FiveDays;
import com.example.weatherapp.model.GetCurrentWeather;
import com.example.weatherapp.model.LocationAPIByLL;
import com.example.weatherapp.sharedPreferences.DataLocalManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallAPI {

   // private final String APIKEY = "snKblrjtccSQfEtGwrZDf2KUxl5zTPwP";
    private final String APIKEY = "fl0ccTJUjOz3LERxDCekgDHPcSdLEWpo";
    LocationAPIByLL locationAPIByLL;
    List<GetCurrentWeather> getCurrentWeatherList ;
    FiveDays fiveDays;
     public boolean  flagDone = false;

     List<CityInformation> cityInformationList;



    public  void   getLocation(double latitude,double longitude){
        System.out.println("get location is called");
        APIGeoposition.apiGeoposition.getLocation(latitude+","+longitude,APIKEY).enqueue(new Callback<LocationAPIByLL>() {
            @Override
            public void onResponse(Call<LocationAPIByLL> call, Response<LocationAPIByLL> response) {
                locationAPIByLL = response.body();
                if(locationAPIByLL!=null){
                    DataLocalManager.saveLocation(locationAPIByLL);
                    getCurrentWeather();
                }
            }

            @Override
            public void onFailure(Call<LocationAPIByLL> call, Throwable t) {
            }
        });

    }

    public void getCurrentWeather(){
        System.out.println("getCurrentWeather  is called");
        if(locationAPIByLL!= null){
            APIGeoposition.apiGeoposition.getCurrentWeather(locationAPIByLL.getKey(),APIKEY).enqueue(new Callback<List<GetCurrentWeather>>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onResponse(Call<List<GetCurrentWeather>> call, Response<List<GetCurrentWeather>> response) {
                    getCurrentWeatherList = response.body();
                    if(getCurrentWeatherList != null) {
                        DataLocalManager.saveCurrentWeatherList(getCurrentWeatherList);
                    }
                    getWeatherFiveDays();

                }

                @Override
                public void onFailure(Call<List<GetCurrentWeather>> call, Throwable t) {

                }
            });
        }
    }

    public void getWeatherFiveDays(){
        if(locationAPIByLL!=null){
            APIGeoposition.apiGeoposition.getWeatherFiveDays(locationAPIByLL.getKey(),APIKEY).enqueue(new Callback<FiveDays>() {
                @Override
                public void onResponse(Call<FiveDays> call, Response<FiveDays> response) {
                    fiveDays = response.body();
                    if(fiveDays!= null){
                        DataLocalManager.saveWeatherFiveDays(fiveDays);
                        flagDone = true;
                    }

                }
                @Override
                public void onFailure(Call<FiveDays> call, Throwable t) {

                }
            });
        }
    }

    public void getListCity(String cityName ){
        APIGeoposition.apiGeoposition.getListCityInformation(cityName,APIKEY).enqueue(new Callback<List<CityInformation>>() {
            @Override
            public void onResponse(Call<List<CityInformation>> call, Response<List<CityInformation>> response) {
                cityInformationList = response.body();
                if(cityInformationList!= null){
                    DataLocalManager.saveCityList(cityInformationList);
                }
            }

            @Override
            public void onFailure(Call<List<CityInformation>> call, Throwable t) {

            }
        });
    }
}
