package com.example.android.tourguide;

/**
 * Created by mdd23 on 6/27/2016.
 */
public class Location {
    private String mLocationName;
    private String mLocationDescription;
    private int mImageResourceId = NO_IMAGE;
    // Constant to check for image resource
    public static final int NO_IMAGE = -1;
    // Coordinates in latitude and longitude
    private double latit;
    private double longit;

    /**
     * Constructor for just name and description
     * @param mLocationName
     * @param mLocationDescription
     */
    public Location(String mLocationName, String mLocationDescription) {
        this.mLocationDescription = mLocationDescription;
        this.mLocationName = mLocationName;
    }

    /**
     * Constructor all but no image
     * @param mLocationName
     * @param mLocationDescription
     * @param latit
     * @param longit
     */
    public Location(String mLocationName, String mLocationDescription, double latit, double longit) {
        this.mLocationName = mLocationName;
        this.mLocationDescription = mLocationDescription;
        this.latit = latit;
        this.longit = longit;
    }

    /**
     * Constructor for all details
     * @param mLocationName
     * @param mLocationDescription
     * @param latit
     * @param longit
     * @param mImageResourceId
     */
    public Location(String mLocationName, String mLocationDescription, double latit, double longit, int mImageResourceId) {
        this.mLocationName = mLocationName;
        this.mLocationDescription = mLocationDescription;
        this.mImageResourceId = mImageResourceId;
        this.latit = latit;
        this.longit = longit;
    }

    /**
     * Get location name
     * @return the location name
     */
    public String getmLocationName() {
        return mLocationName;
    }

    /**
     * Get location description
     * @return the location description
     */
    public String getmLocationDescription() {
        return mLocationDescription;
    }

    /**
     * Get image resource ID
     * @return image resource ID
     */
    public int getmImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Check if location instance has an image
     * @return "this instance has an image"
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE;
    }

    /**
     * Get a data URI formatted for the Google Maps Intent API
     * @return Google Maps URI
     */
    public String getGMapsURI(){
        return String.format("geo:%f,%f?q=%f,%f(%s)"
                , latit
                , longit
                , latit
                , longit
                , mLocationName);
    }

    /**
     * Print instance information
     * @return
     */
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
