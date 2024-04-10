package com.example.weatherapp.listCityWeather;

public class CityWeatherItem {
    private String temValue;
    private String lowHeightTem;
    private String address;
    private int imageResource;
    private String statusWeather;

    public CityWeatherItem(String temValue, String lowHeightTem, String address, int imageResource, String statusWeather) {
        this.temValue = temValue;
        this.lowHeightTem = lowHeightTem;
        this.address = address;
        this.imageResource = imageResource;
        this.statusWeather = statusWeather;
    }

    public String getTemValue() {
        return temValue;
    }

    public void setTemValue(String temValue) {
        this.temValue = temValue;
    }

    public String getLowHeightTem() {
        return lowHeightTem;
    }

    public void setLowHeightTem(String lowHeightTem) {
        this.lowHeightTem = lowHeightTem;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getStatusWeather() {
        return statusWeather;
    }

    public void setStatusWeather(String statusWeather) {
        this.statusWeather = statusWeather;
    }
}
