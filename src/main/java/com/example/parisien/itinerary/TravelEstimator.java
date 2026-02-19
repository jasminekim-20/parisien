package com.example.parisien.itinerary;

import org.springframework.stereotype.Service;

@Service
public class TravelEstimator {

    public ItineraryLeg estimate(double distanceKm) {
        // 규칙 1) 1.5km 이하면 도보
        if (distanceKm <= 1.5) {
            int minutes = (int) Math.round(distanceKm * 12); // 도보: 12분/km
            return new ItineraryLeg(round1(distanceKm), minutes, TravelMode.WALK);
        }

        // 규칙 2) 6km 이하면 메트로
        if (distanceKm <= 6.0) {
            int minutes = (int) Math.round(distanceKm * 4 + 5); // 메트로: 4분/km + 대기/환승 5분
            return new ItineraryLeg(round1(distanceKm), minutes, TravelMode.METRO);
        }

        // 규칙 3) 그 이상은 택시
        int minutes = (int) Math.round(distanceKm * 3 + 2); // 택시: 3분/km + 호출/승하차 2분
        return new ItineraryLeg(round1(distanceKm), minutes, TravelMode.TAXI);
    }

    private double round1(double v) {
        return Math.round(v * 10.0) / 10.0;
    }
}

