package com.example.dispmoveis02;

public class Fruta {
    private String name;
    private int imageResourceId;

    public Fruta(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}