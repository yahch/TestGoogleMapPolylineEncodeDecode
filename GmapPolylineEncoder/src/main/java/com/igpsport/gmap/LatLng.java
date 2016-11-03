package com.igpsport.gmap;

/**
 * Created by xuzhi on 2016/11/2.
 */
public class LatLng {

    private double lat;
    private double lon;

    public LatLng(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return this.lat + "," + this.lon;
    }
}