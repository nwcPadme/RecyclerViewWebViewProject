package com.example.ucm;

public class AppModel {
    private String name;
    private int ID;
    private int image;

    public AppModel(String name, int ID, int image) {
        this.name = name;
        this.ID = ID;
        this.image = image;
    }

    public String getName() {
        return name;
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
