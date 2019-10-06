package com.example.ucm;

public class AppModel {
    private String name;
    private String URL;
    private int ID;
    private int image;

    public AppModel(String name, String URL, int ID, int image) {
        this.URL = URL;
        this.name = name;
        this.ID = ID;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getURLs() {
        return URL;
    }

    public int getID() {
        return ID;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        name = name;
    }
}
