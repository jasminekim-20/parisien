package com.example.parisien.day;

import java.util.List;

public class DaySlot {

    private Slot slot;
    private DayOption optionA;
    private DayOption optionB;

    public DaySlot() {}

    public DaySlot(Slot slot, DayOption optionA, DayOption optionB) {
        this.slot = slot;
        this.optionA = optionA;
        this.optionB = optionB;
    }

    public Slot getSlot() { return slot; }
    public DayOption getOptionA() { return optionA; }
    public DayOption getOptionB() { return optionB; }

    /**
     * DayPlanService가 "옵션들을 순회"할 수 있도록 만든 표준 getter.
     * 기존 구조(optionA/optionB)는 그대로 유지하면서, List 형태로도 제공한다.
     */
    public List<DayOption> getOptions() {
        return List.of(optionA, optionB);
    }

    public void setSlot(Slot slot) { this.slot = slot; }
    public void setOptionA(DayOption optionA) { this.optionA = optionA; }
    public void setOptionB(DayOption optionB) { this.optionB = optionB; }
}
