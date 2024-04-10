package com.example.weatherapp.model;

public class GeoPosition {
    private float Latitude;
    private float Longitude;
    Elevation ElevationObject;


    // Getter Methods

    public float getLatitude() {
        return Latitude;
    }

    public float getLongitude() {
        return Longitude;
    }

    public Elevation getElevation() {
        return ElevationObject;
    }

    // Setter Methods

    public void setLatitude(float Latitude) {
        this.Latitude = Latitude;
    }

    public void setLongitude(float Longitude) {
        this.Longitude = Longitude;
    }

    public void setElevation(Elevation ElevationObject) {
        this.ElevationObject = ElevationObject;
    }
}
