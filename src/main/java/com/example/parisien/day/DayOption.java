package com.example.parisien.day;

import com.example.parisien.place.Place;

public class DayOption {

    private String optionId; // 예: "d1-m-a"
    private String label;    // 카드에 보일 문구
    private Place place;     // 연결된 장소

    public DayOption() {}

    public DayOption(String optionId, String label, Place place) {
        this.optionId = optionId;
        this.label = label;
        this.place = place;
    }

    public String getOptionId() { return optionId; }
    public String getLabel() { return label; }
    public Place getPlace() { return place; }

    /**
     * DayPlanService가 optionId를 표준 이름(getId)으로 접근할 수 있도록 만든 별칭 getter.
     * 기존 getOptionId()는 그대로 둔다.
     */
    public String getId() {
        return optionId;
    }

    /**
     * DayPlanService가 Place의 id만 필요할 때 편하게 쓰도록 만든 getter.
     * place가 null이면 NPE가 날 수 있으니, 현재 구조상 place는 항상 채워진다는 전제에서 사용.
     */
    public String getPlaceId() {
        return place.getId();
    }

    public void setOptionId(String optionId) { this.optionId = optionId; }
    public void setLabel(String label) { this.label = label; }
    public void setPlace(Place place) { this.place = place; }
}
