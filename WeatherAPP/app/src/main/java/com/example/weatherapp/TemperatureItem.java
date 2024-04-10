package com.example.weatherapp;

public class TemperatureItem {
    private String dayName;
    private int resourceWeatherIcon;
    private String temValue;

    public TemperatureItem(String dayName, int resourceWeatherIcon, String temValue) {
        this.dayName = dayName;
        this.resourceWeatherIcon = resourceWeatherIcon;
        this.temValue = temValue;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public int getResourceWeatherIcon() {
        return resourceWeatherIcon;
    }

    public void setResourceWeatherIcon(int resourceWeatherIcon) {
        this.resourceWeatherIcon = resourceWeatherIcon;
    }

    public String getTemValue() {
        return temValue;
    }

    public void setTemValue(String temValue) {
        this.temValue = temValue;
    }
}
