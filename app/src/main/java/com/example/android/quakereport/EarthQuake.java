package com.example.android.quakereport;

public class EarthQuake {
    //Magnitude of the quake
    private double mMagnitude;
    //Location of its occurence
    private String mLocation;
    //Date of the event
    private  long mTimeInMilliseconds;

    private String mUrl;


    /**Create a new array Adapter Object
     * @param magnitude is the Magnitude of the EarthQuake.
     * @param location is the location of its occurence
     * @param timeInMilliseconds is the time at which the EarthQuake happened.    */
    public EarthQuake(double magnitude, String location, long timeInMilliseconds, String url){
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mTimeInMilliseconds = timeInMilliseconds;
        this.mUrl = url;
    }

    //Get  the magnitude of the quake

    public double getmMagnitude() {
        return mMagnitude;
    }


    //Get the location of the quake

    public String getmLocation() {
        return mLocation;
    }

    //Get the date of the event

    public Long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getmUrl() {
        return mUrl;
    }
}
