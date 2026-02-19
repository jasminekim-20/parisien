package com.example.parisien.day;

import java.util.List;

public class DayPlan {

    private int day; // 1~5
    private String title; // "Day 1"
    private List<DaySlot> slots;

    public DayPlan() {}

    public DayPlan(int day, String title, List<DaySlot> slots) {
        this.day = day;
        this.title = title;
        this.slots = slots;
    }

    public int getDay() { return day; }
    public String getTitle() { return title; }
    public List<DaySlot> getSlots() { return slots; }

    public void setDay(int day) { this.day = day; }
    public void setTitle(String title) { this.title = title; }
    public void setSlots(List<DaySlot> slots) { this.slots = slots; }
}
