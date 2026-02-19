package com.example.parisien.day;

import jakarta.validation.constraints.NotBlank;

public class DayChoiceRequest {

    @NotBlank
    private String morningOptionId;

    @NotBlank
    private String lunchOptionId;

    @NotBlank
    private String dinnerOptionId;

    public String getMorningOptionId() { return morningOptionId; }
    public String getLunchOptionId() { return lunchOptionId; }
    public String getDinnerOptionId() { return dinnerOptionId; }

    public void setMorningOptionId(String morningOptionId) { this.morningOptionId = morningOptionId; }
    public void setLunchOptionId(String lunchOptionId) { this.lunchOptionId = lunchOptionId; }
    public void setDinnerOptionId(String dinnerOptionId) { this.dinnerOptionId = dinnerOptionId; }
}
