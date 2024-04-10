package com.example.weatherapp.model;

public class CityInformation {
    private float Version;
    private String Key;
    private String Type;
    private float Rank;
    private String LocalizedName;
    Country Country;
    AdministrativeArea AdministrativeArea;


    // Getter Methods

    public float getVersion() {
        return Version;
    }

    public String getKey() {
        return Key;
    }

    public String getType() {
        return Type;
    }

    public float getRank() {
        return Rank;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public Country getCountry() {
        return Country;
    }

    public AdministrativeArea getAdministrativeArea() {
        return AdministrativeArea;
    }

    // Setter Methods

    public void setVersion(float Version) {
        this.Version = Version;
    }

    public void setKey(String Key) {
        this.Key = Key;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setRank(float Rank) {
        this.Rank = Rank;
    }

    public void setLocalizedName(String LocalizedName) {
        this.LocalizedName = LocalizedName;
    }

    public void setCountry(Country Country) {
        this.Country = Country;
    }

    public void setAdministrativeArea(AdministrativeArea AdministrativeArea) {
        this.AdministrativeArea = AdministrativeArea;
    }
}

