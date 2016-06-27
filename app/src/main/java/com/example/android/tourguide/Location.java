package com.example.android.tourguide;

/**
 * Created by mdd23 on 6/27/2016.
 */
public class Location {
    private String mLocationName;
    private String mLocationDescription;
    private int mImageResourceId = NO_IMAGE;
    public static final int NO_IMAGE = -1;
    private double[] mCoordinates = new double[2];

    public Location(String mLocationName, String mLocationDescription) {
        this.mLocationDescription = mLocationDescription;
        this.mLocationName = mLocationName;
    }

    public Location(String mLocationName, String mLocationDescription, double[] mCoordinates) {
        this.mLocationName = mLocationName;
        this.mLocationDescription = mLocationDescription;
        this.mCoordinates = mCoordinates;
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
        return String.format("geo:%d,%d?q=%d,%d(%s)"
                , mCoordinates[0]
                , mCoordinates[1]
                , mCoordinates[0]
                , mCoordinates[1]
                , getmLocationName());
    }

    @Override
    public String toString() {
        return "Location{" +
                "mLocationName='" + mLocationName + '\'' +
                ", mLocationDescription='" + mLocationDescription + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mCoordinates='" + mCoordinates + '\'' +
                '}';
    }
}
