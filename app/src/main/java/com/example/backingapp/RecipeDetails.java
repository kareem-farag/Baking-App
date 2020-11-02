package com.example.backingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.backingapp.utils.Recipe;

public class RecipeDetails extends AppCompatActivity {
    private Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            recipe = intent.getParcelableExtra("recipe");

        }
    }
}
