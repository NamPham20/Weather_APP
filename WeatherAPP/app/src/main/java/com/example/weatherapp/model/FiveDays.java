package com.example.weatherapp.model;

import java.util.ArrayList;

public class FiveDays {
    Headline Headline;
    ArrayList< DailyForecast > DailyForecasts = new ArrayList < DailyForecast > ();


    // Getter Methods

    public Headline getHeadline() {
        return Headline;
    }

    // Setter Methods

    public void setHeadline(Headline HeadlineObject) {
        this.Headline = HeadlineObject;
    }

    public ArrayList<DailyForecast> getDailyForecasts() {
        return DailyForecasts;
    }

    public void setDailyForecasts(ArrayList<DailyForecast> dailyForecasts) {
        DailyForecasts = dailyForecasts;
    }
}
