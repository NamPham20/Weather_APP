package com.example.weatherapp.model;

import java.util.ArrayList;

public class LocationAPIByLL {
    private float Version;
    private String Key;
    private String Type;
    private float Rank;
    private String LocalizedName;
    private String EnglishName;
    private String PrimaryPostalCode;
    Region RegionObject;
    Country CountryObject;
    AdministrativeArea AdministrativeAreaObject;
    TimeZone TimeZoneObject;
    GeoPosition GeoPositionObject;
    private boolean IsAlias;
    ParentCity ParentCityObject;
    ArrayList< Object > SupplementalAdminAreas = new ArrayList < Object > ();
    ArrayList < String > DataSets = new ArrayList < String > ();


    // Getter Methods


    public float getVersion() {
        return Version;
    }

    public void setVersion(float version) {
        Version = version;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public float getRank() {
        return Rank;
    }

    public void setRank(float rank) {
        Rank = rank;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public void setLocalizedName(String localizedName) {
        LocalizedName = localizedName;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public void setEnglishName(String englishName) {
        EnglishName = englishName;
    }

    public String getPrimaryPostalCode() {
        return PrimaryPostalCode;
    }

    public void setPrimaryPostalCode(String primaryPostalCode) {
        PrimaryPostalCode = primaryPostalCode;
    }

    public Region getRegionObject() {
        return RegionObject;
    }

    public void setRegionObject(Region regionObject) {
        RegionObject = regionObject;
    }

    public Country getCountryObject() {
        return CountryObject;
    }

    public void setCountryObject(Country countryObject) {
        CountryObject = countryObject;
    }

    public AdministrativeArea getAdministrativeAreaObject() {
        return AdministrativeAreaObject;
    }

    public void setAdministrativeAreaObject(AdministrativeArea administrativeAreaObject) {
        AdministrativeAreaObject = administrativeAreaObject;
    }

    public TimeZone getTimeZoneObject() {
        return TimeZoneObject;
    }

    public void setTimeZoneObject(TimeZone timeZoneObject) {
        TimeZoneObject = timeZoneObject;
    }

    public GeoPosition getGeoPositionObject() {
        return GeoPositionObject;
    }

    public void setGeoPositionObject(GeoPosition geoPositionObject) {
        GeoPositionObject = geoPositionObject;
    }

    public boolean isAlias() {
        return IsAlias;
    }

    public void setAlias(boolean alias) {
        IsAlias = alias;
    }

    public ParentCity getParentCityObject() {
        return ParentCityObject;
    }

    public void setParentCityObject(ParentCity parentCityObject) {
        ParentCityObject = parentCityObject;
    }

    public ArrayList<Object> getSupplementalAdminAreas() {
        return SupplementalAdminAreas;
    }

    public void setSupplementalAdminAreas(ArrayList<Object> supplementalAdminAreas) {
        SupplementalAdminAreas = supplementalAdminAreas;
    }

    public ArrayList<String> getDataSets() {
        return DataSets;
    }

    public void setDataSets(ArrayList<String> dataSets) {
        DataSets = dataSets;
    }
}

