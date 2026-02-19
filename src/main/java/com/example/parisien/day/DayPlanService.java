package com.example.parisien.day;

import com.example.parisien.geo.DistanceService;
import com.example.parisien.itinerary.ItineraryLeg;
import com.example.parisien.itinerary.ItineraryStop;
import com.example.parisien.itinerary.TravelEstimator;
import com.example.parisien.place.Place;
import com.example.parisien.place.PlaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayPlanService {

    private final List<DayPlan> plans;
    private final PlaceService placeService;
    private final DistanceService distanceService;
    private final TravelEstimator travelEstimator;

    public DayPlanService(
            List<DayPlan> plans,
            PlaceService placeService,
            DistanceService distanceService,
            TravelEstimator travelEstimator
    ) {
        this.plans = plans;
        this.placeService = placeService;
        this.distanceService = distanceService;
        this.travelEstimator = travelEstimator;
    }

    public List<DayPlan> getPlans() {
        return plans;
    }

    public DayItineraryResponse submit(int day, DayChoiceRequest req) {
        DayPlan plan = findPlanOrThrow(day);

        // 1) req가 보내는 optionId 3개를 plan에서 찾아서 placeId로 바꾼다
        String morningPlaceId = findPlaceIdByOptionId(plan, req.getMorningOptionId());
        String lunchPlaceId   = findPlaceIdByOptionId(plan, req.getLunchOptionId());
        String dinnerPlaceId  = findPlaceIdByOptionId(plan, req.getDinnerOptionId());

        // 2) placeId -> Place
        Place morning = placeService.findByIdOrThrow(morningPlaceId);
        Place lunch   = placeService.findByIdOrThrow(lunchPlaceId);
        Place dinner  = placeService.findByIdOrThrow(dinnerPlaceId);

        // 3) 이동 구간 2개 계산
        ItineraryLeg leg1 = estimateLeg(morning, lunch);
        ItineraryLeg leg2 = estimateLeg(lunch, dinner);

        // 4) stop 3개 생성 (마지막 nextLeg = null)
        List<ItineraryStop> stops = List.of(
                new ItineraryStop("MORNING", morning, leg1),
                new ItineraryStop("LUNCH", lunch, leg2),
                new ItineraryStop("DINNER", dinner, null)
        );

        return new DayItineraryResponse(day, stops);
    }

    private DayPlan findPlanOrThrow(int day) {
        for (DayPlan p : plans) {
            if (p.getDay() == day) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid day: " + day);
    }

    private ItineraryLeg estimateLeg(Place from, Place to) {
        double km = distanceService.km(from.getLat(), from.getLng(), to.getLat(), to.getLng());
        return travelEstimator.estimate(km);
    }

    /**
     * optionId로 DayOption을 찾아서 그 option이 연결된 placeId를 반환한다.
     *
     * 전제(네가 설명한 구조):
     * - DayPlan -> slots(아침/점심/저녁)
     * - DaySlot -> options(2개)
     * - DayOption -> (id, placeId 또는 place 연결 정보)
     *
     * 아래 getter명은 "가장 흔한" 형태로 작성했다:
     * - DayPlan.getSlots()
     * - DaySlot.getOptions()
     * - DayOption.getId()
     * - DayOption.getPlaceId()
     */
    private String findPlaceIdByOptionId(DayPlan plan, String optionId) {
        for (DaySlot slot : plan.getSlots()) {
            for (DayOption opt : slot.getOptions()) {
                if (opt.getId().equals(optionId)) {
                    return opt.getPlaceId();
                }
            }
        }
        throw new IllegalArgumentException("Option not found in day plan. optionId=" + optionId);
    }
}
