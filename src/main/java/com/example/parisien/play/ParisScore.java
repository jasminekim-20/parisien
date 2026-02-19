package com.example.parisien.play;

public class ParisScore {
    private int culture;
    private int slow;
    private int food;
    private int landmark;
    private int free;

    public void addCulture(int v) { culture += v; }
    public void addSlow(int v) { slow += v; }
    public void addFood(int v) { food += v; }
    public void addLandmark(int v) { landmark += v; }
    public void addFree(int v) { free += v; }

    public int getCulture() { return culture; }
    public int getSlow() { return slow; }
    public int getFood() { return food; }
    public int getLandmark() { return landmark; }
    public int getFree() { return free; }
}
