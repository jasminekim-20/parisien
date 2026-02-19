package com.example.parisien.play;
import jakarta.validation.constraints.NotBlank;
public class PlayAnswer {

    @NotBlank
    private String morningChoice;

    @NotBlank
    private String lunchChoice;

    @NotBlank
    private String dinnerChoice;

    public PlayAnswer() {

    }

    public String getMorningChoice() {
        return morningChoice;
    }
    public String getLunchChoice() {
        return lunchChoice;
    }
    public String getDinnerChoice() {
        return dinnerChoice;
    }

    public void setMorningChoice(String morningChoice){
        this.morningChoice = morningChoice;
    }
    public void setLunchChoice(String lunchChoice) {
        this.lunchChoice = lunchChoice;
    }
    public void setDinnerChoice(String dinnerChoice) {
        this.dinnerChoice = dinnerChoice;
    }

}
