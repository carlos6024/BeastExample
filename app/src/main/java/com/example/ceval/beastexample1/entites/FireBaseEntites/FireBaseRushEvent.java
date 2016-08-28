package com.example.ceval.beastexample1.entites.FireBaseEntites;


public class FireBaseRushEvent {
    private String name;
    private String date;
    private String time;
    private String location;
    private double latitiude;
    private double longitude;
    private boolean campus;
    private String description;


    public FireBaseRushEvent(){
    }


    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public double getLatitiude() {
        return latitiude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean isCampus() {
        return campus;
    }

    public String getDescription() {
        return description;
    }
}
