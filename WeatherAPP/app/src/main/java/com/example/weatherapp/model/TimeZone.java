package com.example.weatherapp.model;

public class TimeZone {
    private String Code;
    private String Name;
    private float GmtOffset;
    private boolean IsDaylightSaving;
    private String NextOffsetChange = null;


    // Getter Methods

    public String getCode() {
        return Code;
    }

    public String getName() {
        return Name;
    }

    public float getGmtOffset() {
        return GmtOffset;
    }

    public boolean getIsDaylightSaving() {
        return IsDaylightSaving;
    }

    public String getNextOffsetChange() {
        return NextOffsetChange;
    }

    // Setter Methods

    public void setCode(String Code) {
        this.Code = Code;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setGmtOffset(float GmtOffset) {
        this.GmtOffset = GmtOffset;
    }

    public void setIsDaylightSaving(boolean IsDaylightSaving) {
        this.IsDaylightSaving = IsDaylightSaving;
    }

    public void setNextOffsetChange(String NextOffsetChange) {
        this.NextOffsetChange = NextOffsetChange;
    }
}
