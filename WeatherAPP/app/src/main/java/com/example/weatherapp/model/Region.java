package com.example.weatherapp.model;

public class Region {
    private String ID;
    private String LocalizedName;
    private String EnglishName;


    // Getter Methods

    public String getID() {
        return ID;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    // Setter Methods

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setLocalizedName(String LocalizedName) {
        this.LocalizedName = LocalizedName;
    }

    public void setEnglishName(String EnglishName) {
        this.EnglishName = EnglishName;
    }
}
