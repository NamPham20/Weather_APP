package com.example.weatherapp.model;

public class Night {
    private float Icon;
    private String IconPhrase;
    private boolean HasPrecipitation;


    // Getter Methods

    public float getIcon() {
        return Icon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public boolean getHasPrecipitation() {
        return HasPrecipitation;
    }

    // Setter Methods

    public void setIcon(float Icon) {
        this.Icon = Icon;
    }

    public void setIconPhrase(String IconPhrase) {
        this.IconPhrase = IconPhrase;
    }

    public void setHasPrecipitation(boolean HasPrecipitation) {
        this.HasPrecipitation = HasPrecipitation;
    }
}
