package com.example.weatherapp.model;

public class AdministrativeArea {
    private String ID;
    private String LocalizedName;
    private String EnglishName;
    private float Level;
    private String LocalizedType;
    private String EnglishType;
    private String CountryID;


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

    public float getLevel() {
        return Level;
    }

    public String getLocalizedType() {
        return LocalizedType;
    }

    public String getEnglishType() {
        return EnglishType;
    }

    public String getCountryID() {
        return CountryID;
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

    public void setLevel(float Level) {
        this.Level = Level;
    }

    public void setLocalizedType(String LocalizedType) {
        this.LocalizedType = LocalizedType;
    }

    public void setEnglishType(String EnglishType) {
        this.EnglishType = EnglishType;
    }

    public void setCountryID(String CountryID) {
        this.CountryID = CountryID;
    }
}
