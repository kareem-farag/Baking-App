package com.example.backingapp.data;

public class Ingredient {
    private String quentity;
    private String measure;
    private String imagle;

    public Ingredient(String quentity, String measure, String imagle) {
        this.quentity = quentity;
        this.measure = measure;
        this.imagle = imagle;
    }

    public String getQuentity() {
        return quentity;
    }

    public void setQuentity(String quentity) {
        this.quentity = quentity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getImagle() {
        return imagle;
    }

    public void setImagle(String imagle) {
        this.imagle = imagle;
    }
}
