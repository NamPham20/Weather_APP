package com.example.weatherapp.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.contentcapture.DataRemovalRequest;

import com.example.weatherapp.model.CityInformation;
import com.example.weatherapp.model.FiveDays;
import com.example.weatherapp.model.GetCurrentWeather;
import com.example.weatherapp.model.LocationAPIByLL;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataLocalManager {
    public static final String JSON_LOCATION = "JSON_LOCATION";

    public static final String JSON_CURRENT_WEATHER_LIST   = "JSON_CURRENT_WEATHER_LIST";
    public static final String JSON_WEATHER_FIVE_DAY   = "JSON_WEATHER_FIVE_DAY";
    public static final String JSON_CITY_LIST   = "JSON_CITY_LIST";

    public static DataLocalManager instance;
    private MySharedPreferences mySharedPreferences;

    public static void init(Context context){
        instance = new DataLocalManager();
        instance.mySharedPreferences = new MySharedPreferences(context);
    }

    public static DataLocalManager getInstance(){
        if ( instance == null){
            instance = new DataLocalManager();
        }
        return instance;
    }

    public static void saveLocation(LocationAPIByLL locationAPIByLL){
        Gson gson = new Gson();
        String jsonLocation = gson.toJson(locationAPIByLL);
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(JSON_LOCATION,jsonLocation);
    }

    public static LocationAPIByLL getLocationFromShare(){
        String jsonLocation = DataLocalManager.getInstance().mySharedPreferences.getStringValue(JSON_LOCATION);
        Gson gson = new Gson();
        return gson.fromJson(jsonLocation,LocationAPIByLL.class);
    }

    public static void saveCurrentWeatherList(List<GetCurrentWeather> getCurrentWeatherList){
        Gson gson = new Gson();
        String jsonCurrentWeatherList = gson.toJson(getCurrentWeatherList);
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(JSON_CURRENT_WEATHER_LIST,jsonCurrentWeatherList);
    }

    public static List<GetCurrentWeather> getCurrentWeatherListFromShare() {
        String jsonCurrentWeatherList = DataLocalManager.getInstance().mySharedPreferences.getStringValue(JSON_CURRENT_WEATHER_LIST);
        Gson gson = new Gson();
        return gson.fromJson(jsonCurrentWeatherList, new TypeToken<List<GetCurrentWeather>>(){}.getType());
    }

    public static void saveCityList(List<CityInformation> cityInformationList){
        Gson gson = new Gson();
        String jsonCityList = gson.toJson(cityInformationList);
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(JSON_CITY_LIST,jsonCityList);
    }

    public static List<CityInformation> getCityListFromShare() {
        String jsonCityList = DataLocalManager.getInstance().mySharedPreferences.getStringValue(JSON_CITY_LIST);
        Gson gson = new Gson();
        return gson.fromJson(jsonCityList, new TypeToken<List<CityInformation>>(){}.getType());
    }


    public static void saveWeatherFiveDays(FiveDays fiveDays){
        Gson gson = new Gson();
        String jsonWeatherFiveDays = gson.toJson(fiveDays);
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(JSON_WEATHER_FIVE_DAY,jsonWeatherFiveDays);
    }

    public static FiveDays getWeatherFiveDaysFromShare(){
        String jsonWeatherFiveDays = DataLocalManager.getInstance().mySharedPreferences.getStringValue(JSON_WEATHER_FIVE_DAY);
        Gson gson = new Gson();
        return gson.fromJson(jsonWeatherFiveDays,FiveDays.class) ;
    }

}
