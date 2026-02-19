package com.example.parisien.play;
import java.util.List;

public class ResultResponse {

    private String title;
    private String subtitle;
    private List<String> tips;

    public ResultResponse() {}

    public ResultResponse(String title, String subtitle, List<String> tips) {
        this.title = title;
        this.subtitle = subtitle;
        this.tips = tips;
    }

    public String getTitle() { return title; }
    public String getSubtitle() { return subtitle; }
    public List<String> getTips() { return tips; }

    public void setTitle(String title) { this.title = title; }
    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }
    public void setTips(List<String> tips) { this.tips = tips; }

}
