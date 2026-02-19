package com.example.parisien.day;

import com.example.parisien.itinerary.ItineraryStop;

import java.util.List;

public class DayItineraryResponse {

    private int day;
    private List<ItineraryStop> stops;

    public DayItineraryResponse(int day, List<ItineraryStop> stops) {
        this.day = day;
        this.stops = stops;
    }

    public int getDay() { return day; }
    public List<ItineraryStop> getStops() { return stops; }
}
