package com.example.weatherapp.api;

import com.example.weatherapp.model.CityInformation;
import com.example.weatherapp.model.FiveDays;
import com.example.weatherapp.model.GetCurrentWeather;
import com.example.weatherapp.model.LocationAPIByLL;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIGeoposition {

    //API http://dataservice.accuweather.com/locations/v1/cities/geoposition/search
    // ?q=20.983196666666664,105.8326250000000001
    // &apikey=fl0ccTJUjOz3LERxDCekgDHPcSdLEWpo

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    APIGeoposition apiGeoposition = new Retrofit.Builder()
            .baseUrl("http://dataservice.accuweather.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIGeoposition.class);

    @GET("locations/v1/cities/geoposition/search")
    Call<LocationAPIByLL> getLocation(
            @Query("q") String strQ,
            @Query ("apikey") String strApikey);


    @GET("forecasts/v1/hourly/12hour/{locationKey}")
    Call <List<GetCurrentWeather>> getCurrentWeather(
            @Path("locationKey") String locationKey,
            @Query("apikey") String apiKey);

    @GET("forecasts/v1/daily/5day/{locationKey}")
    Call <FiveDays> getWeatherFiveDays(
            @Path("locationKey") String locationKey,
            @Query("apikey") String apiKey);

    @GET("locations/v1/cities/autocomplete")
    Call<List<CityInformation>> getListCityInformation(
            @Query("q") String cityName,
            @Query("apikey") String apikey);
}
