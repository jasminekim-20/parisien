package com.example.parisien.itinerary;

public class ItineraryLeg {

    private double distanceKm;
    private int durationMin;
    private TravelMode mode;

    public ItineraryLeg(double distanceKm, int durationMin, TravelMode mode) {
        this.distanceKm = distanceKm;
        this.durationMin = durationMin;
        this.mode = mode;
    }

    public double getDistanceKm() { return distanceKm; }
    public int getDurationMin() { return durationMin; }
    public TravelMode getMode() { return mode; }
}
