package com.example.weatherapp;

import static androidx.core.location.LocationManagerCompat.requestLocationUpdates;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.health.connect.datatypes.ExerciseRoute;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapp.addNewCity.AddNewPlace;
import com.example.weatherapp.api.APIGeoposition;
import com.example.weatherapp.customtextview.SFProTextRegular;
import com.example.weatherapp.customtextview.Utils;
import com.example.weatherapp.model.FiveDays;
import com.example.weatherapp.model.GetCurrentWeather;
import com.example.weatherapp.model.LocationAPIByLL;
import com.example.weatherapp.sharedPreferences.DataLocalManager;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.text.ParseException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String[] dayOfWeeks={null,"SUN","MON","TUE","WED","THU","FRI","SAT"};

    RecyclerView rcvTemItem;
    TextView tvTemperature;
    TextView tvStatusWeather;
    TextView tvCityName;
    TextView tvHourlyForecast;
    TextView tvDailyForecast;
    ImageView imvAddNewPlace;
    View decorView;
    LocationAPIByLL locationAPIByLL;
    GetCurrentWeather getCurrentWeather;
    TemperatureItemAdapter temperatureItemAdapter;
    List<GetCurrentWeather> getCurrentWeatherList ;

    FiveDays fiveDays;



    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @SuppressLint({"ServiceCast", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        decorView = getWindow().getDecorView();
        Utils.setFullScreen(decorView);
        getCurrentWeatherList = new ArrayList<>();
        getCurrentWeatherList = DataLocalManager.getCurrentWeatherListFromShare();
        locationAPIByLL = DataLocalManager.getLocationFromShare();
        fiveDays = DataLocalManager.getWeatherFiveDaysFromShare();
        init();

        if(getCurrentWeatherList.get(0) !=null ) {
            float temValueF = getCurrentWeatherList.get(0).getTemperature().getValue();
            int temValue = (int) ((temValueF - 32) * 5.0 / 9.0);
            tvTemperature.setText((temValue + "℃"));
            tvStatusWeather.setText(getCurrentWeatherList.get(0).getIconPhrase());
        }else {
            tvTemperature.setText("℃");
            tvStatusWeather.setText("NONE");
        }

        if (locationAPIByLL!=null){
            tvCityName.setText(locationAPIByLL.getEnglishName());
        }


        //SetRecycleView
        temperatureItemAdapter = new TemperatureItemAdapter(this);
        LinearLayoutManager linearLayoutManagerFolderName = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rcvTemItem.setLayoutManager(linearLayoutManagerFolderName);
        temperatureItemAdapter.setData(getListDataWeatherItem());
        rcvTemItem.setAdapter(temperatureItemAdapter);


        tvHourlyForecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHourlyForecast.setTypeface(null, Typeface.BOLD);
                tvHourlyForecast.setTextColor(Color.WHITE);

                tvDailyForecast.setTypeface(null, Typeface.NORMAL);
                tvDailyForecast.setTextColor( );
                temperatureItemAdapter.setData(getListDataWeatherItem());
                rcvTemItem.setAdapter(temperatureItemAdapter);
            }
        });

        tvDailyForecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDailyForecast.setTypeface(null, Typeface.BOLD);
                tvDailyForecast.setTextColor(Color.WHITE);
                tvHourlyForecast.setTypeface(null, Typeface.NORMAL);
                tvHourlyForecast.setTextColor(Color.parseColor("#BABABA"));
                try {
                    temperatureItemAdapter.setData(getListFiveDayItem());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                rcvTemItem.setAdapter(temperatureItemAdapter);
            }
        });


        imvAddNewPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNewPlace.class);
                startActivity(intent);
            }
        });


    }

    private List<TemperatureItem> getListFiveDayItem() throws ParseException {
        List<TemperatureItem> mListTemperatureItems = new ArrayList<>();
        String dateTimeString ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        float temValueMinF ;
        float temValueMaxF ;
        int temValueMin ;
        int temValueMax ;

        int dayOfWeek;
        if(fiveDays!=null){
            for(int i = 0;i<fiveDays.getDailyForecasts().size();i++){
                dateTimeString = fiveDays.getDailyForecasts().get(i).getDate();
                Date date = dateFormat.parse(dateTimeString);
                calendar.setTime(date);
                dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                temValueMinF=fiveDays.getDailyForecasts().get(i).getTemperature().getMinimum().getValue();
                temValueMaxF=fiveDays.getDailyForecasts().get(i).getTemperature().getMaximum().getValue();
                temValueMin = (int)((temValueMinF-32)*5.0/9.0);
                temValueMax = (int)((temValueMaxF-32)*5.0/9.0);
                mListTemperatureItems.add(new TemperatureItem(dayOfWeeks[dayOfWeek],R.drawable.weather_icon,
                        temValueMin+"-"+temValueMax+"℃"));

            }
        }

        return mListTemperatureItems;
    }

    private List<TemperatureItem> getListDataWeatherItem() {
        List<TemperatureItem> mListTemperatureItems = new ArrayList<>();
        getCurrentWeatherList = DataLocalManager.getCurrentWeatherListFromShare();
        if(!getCurrentWeatherList.isEmpty()){
            for (int i=0; i<getCurrentWeatherList.size();i++){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    int hours = OffsetDateTime.parse(getCurrentWeatherList.get(i).getDateTime(), DateTimeFormatter.ISO_OFFSET_DATE_TIME).getHour();
                    float temValueF = getCurrentWeatherList.get(i).getTemperature().getValue();
                    int temValue = (int)((temValueF-32)*5.0/9.0);
                    mListTemperatureItems.add(new TemperatureItem(hours>12? hours+" PM": hours+" AM",R.drawable.weather_icon,temValue+"℃"));
                }

            }
        }
        return mListTemperatureItems;
    }

    public void init(){
        rcvTemItem = findViewById(R.id.rcvTemItem);
        tvCityName = findViewById(R.id.tvCityName);
        tvTemperature = findViewById((R.id.tvTemperature));
        tvStatusWeather = findViewById(R.id.tvStatusWeather);
        tvHourlyForecast = findViewById(R.id.tvHourlyForecast);
        tvDailyForecast = findViewById(R.id.tvDailyForecast);
        imvAddNewPlace = findViewById(R.id.imvAddNewPlace);
    }
}
