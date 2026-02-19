package com.example.parisien.itinerary;

import com.example.parisien.place.Place;

public class ItineraryStop {

    private String slot; // "MORNING" / "LUNCH" / "DINNER"
    private Place place;
    private ItineraryLeg nextLeg; // 다음 이동 구간(마지막은 null)

    public ItineraryStop(String slot, Place place, ItineraryLeg nextLeg) {
        this.slot = slot;
        this.place = place;
        this.nextLeg = nextLeg;
    }

    public String getSlot() { return slot; }
    public Place getPlace() { return place; }
    public ItineraryLeg getNextLeg() { return nextLeg; }
}
