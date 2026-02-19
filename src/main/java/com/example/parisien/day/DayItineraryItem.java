package com.example.parisien.day;

import com.example.parisien.place.Place;

public class DayItineraryItem {

    private String time;   // "09:30"
    private String title;  // "Morning: ..."
    private String detail; // 짧은 설명
    private Place place;

    public DayItineraryItem() {}

    public DayItineraryItem(String time, String title, String detail, Place place) {
        this.time = time;
        this.title = title;
        this.detail = detail;
        this.place = place;
    }

    public String getTime() { return time; }
    public String getTitle() { return title; }
    public String getDetail() { return detail; }
    public Place getPlace() { return place; }

    public void setTime(String time) { this.time = time; }
    public void setTitle(String title) { this.title = title; }
    public void setDetail(String detail) { this.detail = detail; }
    public void setPlace(Place place) { this.place = place; }
}
