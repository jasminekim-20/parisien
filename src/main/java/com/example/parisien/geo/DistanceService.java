package com.example.parisien.geo;

import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    // 지구 반지름(km) - 거리 계산에 쓰는 상수
    private static final double EARTH_RADIUS_KM = 6371.0;

    /**
     * 위도/경도 두 점 사이의 대략적인 거리(km)를 계산한다.
     * - haversine 공식(지구를 구로 보고 계산)
     */
    public double km(double lat1, double lng1, double lat2, double lng2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLng / 2) * Math.sin(dLng / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS_KM * c;
    }
}
