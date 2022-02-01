package com.example.json_soccer_arnau;

public class Country {
    private String nameCountry;
    private int imgCountry;

    public Country(String nameCountry, int imgCountry) {
        this.nameCountry = nameCountry;
        this.imgCountry = imgCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public int getImgCountry() {
        return imgCountry;
    }

    public void setImgCountry(int imgCountry) {
        this.imgCountry = imgCountry;
    }
}
