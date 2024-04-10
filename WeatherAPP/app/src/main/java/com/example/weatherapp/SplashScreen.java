package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.example.weatherapp.api.APIGeoposition;
import com.example.weatherapp.api.CallAPI;
import com.example.weatherapp.model.FiveDays;
import com.example.weatherapp.model.GetCurrentWeather;
import com.example.weatherapp.model.LocationAPIByLL;
import com.example.weatherapp.sharedPreferences.DataLocalManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity implements LocationListener {
    private final String APIKEY = "snKblrjtccSQfEtGwrZDf2KUxl5zTPwP"; ;
    LocationManager locationManager;
    Location lastKnownLocation;
    double latitude;
    double longitude;
    LocationAPIByLL locationAPIByLL;
    List<GetCurrentWeather> getCurrentWeatherList ;
    CallAPI callAPI;

    FiveDays fiveDays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,1,this);
        lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(lastKnownLocation !=null){
            latitude =lastKnownLocation.getLatitude();
            longitude = lastKnownLocation.getLongitude();
        }
        callAPI= new CallAPI();
        callAPI.getLocation(latitude,longitude);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                 startActivity(intent);
            }
        },1000);


    }


    @Override
    public void onLocationChanged(@NonNull Location location) {
        latitude =location.getLatitude();
        longitude = location.getLongitude();
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
    }
}