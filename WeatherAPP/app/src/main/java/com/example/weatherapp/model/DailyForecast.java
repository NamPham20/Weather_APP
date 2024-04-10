package com.example.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DailyForecast {
    private String Date;
    private float EpochDate;
    Temperatures Temperature;
    Day Day;
    Night Night;
    List< String > Sources = new ArrayList < > ();
    private String MobileLink;
    private String Link;


    // Getter Methods

    public String getDate() {
        return Date;
    }

    public float getEpochDate() {
        return EpochDate;
    }

    public Temperatures getTemperature() {
        return Temperature;
    }

    public Day getDay() {
        return Day;
    }

    public Night getNight() {
        return Night;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public String getLink() {
        return Link;
    }

    // Setter Methods

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setEpochDate(float EpochDate) {
        this.EpochDate = EpochDate;
    }

    public void setTemperature (Temperatures Temperature) {
        this.Temperature = Temperature;
    }

    public void setDay(Day DayObject) {
        this.Day = DayObject;
    }

    public void setNight(Night NightObject) {
        this.Night = NightObject;
    }

    public void setMobileLink(String MobileLink) {
        this.MobileLink = MobileLink;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }
}

