package com.example.parisien.place;

public class Place {

    private String id;
    private String name;
    private String type; // "ATTRACTION" | "CAFE" | "OTHER"
    private double lat;
    private double lng;
    private String imageUrl;

    public Place() {}

    public Place(String id, String name, String type, double lat, double lng, String imageUrl) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.lat = lat;
        this.lng = lng;
        this.imageUrl = imageUrl;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public double getLat() { return lat; }
    public double getLng() { return lng; }
    public String getImageUrl() { return imageUrl;}

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setLat(double lat) { this.lat = lat; }
    public void setLng(double lng) { this.lng = lng; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
