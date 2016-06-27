package com.example.android.tourguide;

/**
 * Created by mdd23 on 6/27/2016.
 */
public class Location {
    private String mLocationName;
    private String mLocationDescription;
    private int mImageResourceId = NO_IMAGE;
    public static final int NO_IMAGE = -1;
    private String mCoordinates;

    public Location(String mLocationName, String mLocationDescription) {
        this.mLocationDescription = mLocationDescription;
        this.mLocationName = mLocationName;
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
