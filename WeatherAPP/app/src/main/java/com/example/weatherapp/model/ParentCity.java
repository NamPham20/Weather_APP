package com.example.weatherapp.model;

public class ParentCity {
    private String Key;
    private String LocalizedName;
    private String EnglishName;


    // Getter Methods

    public String getKey() {
        return Key;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    // Setter Methods

    public void setKey(String Key) {
        this.Key = Key;
    }

    public void setLocalizedName(String LocalizedName) {
        this.LocalizedName = LocalizedName;
    }

    public void setEnglishName(String EnglishName) {
        this.EnglishName = EnglishName;
    }
}
