package com.example.jenong.cafeapp.Model;

import java.util.List;

public class Location
{
    public List<String> getLatitude() {
        return latitude;
    }

    public void setLatitude(List<String> latitude) {
        this.latitude = latitude;
    }

    public List<String> getLongitude() {
        return longitude;
    }

    public void setLongitude(List<String> longitude) {
        this.longitude = longitude;
    }

    public List<String> latitude;
    public List<String> longitude;
}