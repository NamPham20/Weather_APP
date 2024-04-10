package com.example.weatherapp.addNewCity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.weatherapp.MainActivity;
import com.example.weatherapp.R;
import com.example.weatherapp.SplashScreen;
import com.example.weatherapp.api.CallAPI;
import com.example.weatherapp.model.CityInformation;
import com.example.weatherapp.sharedPreferences.DataLocalManager;

import java.util.ArrayList;
import java.util.List;

public class AddNewPlace extends AppCompatActivity {
    ImageView imvBack;
     EditText edtSearch;
     ImageView imvSearch;
     RecyclerView rcvListCity;

     CityItemAdapter cityItemAdapter;
     CallAPI callAPI;
     CityInformation cityInformation;
     List<CityInformation> cityInformationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_place);
        init();
        cityItemAdapter = new CityItemAdapter(this);
        LinearLayoutManager linearLayoutManagerFolderName = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvListCity.setLayoutManager(linearLayoutManagerFolderName);

        imvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strSearch =  edtSearch.getText().toString().trim();
                callAPI = new CallAPI();
                callAPI.getListCity(strSearch);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cityItemAdapter.setData(getListCityItem());
                        rcvListCity.setAdapter(cityItemAdapter);
                    }
                },1000);
            }
        });

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNewPlace.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private List<CityItem> getListCityItem() {
        List<CityItem> cityItemList = new ArrayList<>();
        cityInformationList = new ArrayList<>();
        cityInformationList = DataLocalManager.getCityListFromShare();
        if(cityInformationList != null){
            for(int i=0;i<cityInformationList.size();i++){
                cityItemList.add(new CityItem(
                        cityInformationList.get(i).getLocalizedName()
                        ,cityInformationList.get(i).getAdministrativeArea().getLocalizedName()+","+
                        cityInformationList.get(i).getCountry().getLocalizedName()));
            }
        }


        return  cityItemList;
    }


    public void init(){
         imvBack =findViewById(R.id.imvBack);
         edtSearch=findViewById(R.id.edtSearch);
        imvSearch=findViewById(R.id.imvSearch);
         rcvListCity=findViewById(R.id.rcvListCity);
    }


}