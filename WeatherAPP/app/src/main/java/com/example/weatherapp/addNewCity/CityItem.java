package com.example.weatherapp.addNewCity;

public class CityItem {
    private String nameCity;
    private String nameCountry;

    public CityItem(String nameCity, String nameCountry) {
        this.nameCity = nameCity;
        this.nameCountry = nameCountry;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }
}
