package com.example.android.tourguide;

/**
 * Created by mdd23 on 6/27/2016.
 */
public class Location {
    private String mLocationName;
    private String mLocationDescription;
    private int mImageResourceId = NO_IMAGE;
    public static final int NO_IMAGE = -1;
    private double latit;
    private double longit;

    public Location(String mLocationName, String mLocationDescription) {
        this.mLocationDescription = mLocationDescription;
        this.mLocationName = mLocationName;
    }

    public Location(String mLocationName, String mLocationDescription, double latit, double longit) {
        this.mLocationName = mLocationName;
        this.mLocationDescription = mLocationDescription;
        this.latit = latit;
        this.longit = longit;
    }

    public Location(String mLocationName, String mLocationDescription, double latit, double longit, int mImageResourceId) {
        this.mLocationName = mLocationName;
        this.mLocationDescription = mLocationDescription;
        this.mImageResourceId = mImageResourceId;
        this.latit = latit;
        this.longit = longit;
    }

    public String getmLocationName() {
        return mLocationName;
    }

    public String getmLocationDescription() {
        return mLocationDescription;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE;
    }

    public String getGMapsURI(){
        return String.format("geo:%f,%f?q=%f,%f(%s)"
                , latit
                , longit
                , latit
                , longit
                , mLocationName);
    }

    @Override
    public String toString() {
        return "Location{" +
                "mLocationName='" + mLocationName + '\'' +
                ", mLocationDescription='" + mLocationDescription + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", latit=" + latit +
                ", longit=" + longit +
                '}';
    }
}
