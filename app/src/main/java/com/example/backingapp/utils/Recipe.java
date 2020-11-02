package com.example.backingapp.utils;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Recipe implements Parcelable {
    private String id;
    private String name;
    private String servings;
    private String image;
    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
    private List<Ingredient> ingredientList;
    private List<Step> stepList;


    public Recipe(String id, String name, String servings, String image, List<Ingredient> ingredientList, List<Step> stepList) {
        this.id = id;
        this.name = name;
        this.servings = servings;
        this.image = image;
        this.ingredientList = ingredientList;
        this.stepList = stepList;
    }

    protected Recipe(Parcel in) {
        id = in.readString();
        name = in.readString();
        servings = in.readString();
        image = in.readString();
        ingredientList = new ArrayList<Ingredient>();
        in.readList(ingredientList, getClass().getClassLoader());
        stepList = new ArrayList<Step>();
        in.readList(stepList, getClass().getClassLoader());

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

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(servings);
        dest.writeString(image);
        dest.writeList(ingredientList);
        //dest.writeTypedList(ingredientList);

        //dest.writeTypedList(stepList);
        dest.writeList(stepList);
    }
}
