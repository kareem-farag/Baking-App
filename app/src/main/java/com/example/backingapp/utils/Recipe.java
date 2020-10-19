package com.example.backingapp.utils;

import java.util.List;

public class Recipe {
    private String id ;
    private String name ;

    private String servings ;
    private String image ;

    public Recipe(String id, String name,  String servings, String image) {
        this.id = id;
        this.name = name;

        this.servings = servings;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
