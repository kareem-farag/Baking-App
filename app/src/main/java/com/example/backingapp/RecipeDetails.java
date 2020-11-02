package com.example.backingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.backingapp.fragment.StepsSelectFragement;
import com.example.backingapp.utils.Ingredient;
import com.example.backingapp.utils.Recipe;
import com.example.backingapp.utils.Step;

import java.util.List;

public class RecipeDetails extends AppCompatActivity {
    private Recipe recipe;
    private List<Ingredient> ingredientList;
    private List<Step> stepList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            recipe = intent.getParcelableExtra("recipe");
            ingredientList = recipe.getIngredientList();
            stepList = recipe.getStepList();

            StepsSelectFragement stepsSelectFragement = new StepsSelectFragement();
            stepsSelectFragement.setIngredientList(ingredientList);
            stepsSelectFragement.setStepList(stepList);
            if (findViewById(R.id.recipe_details_step_viewer) != null) {
                stepsSelectFragement.setTablet(true);
            }


            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.recipe_details_holder, stepsSelectFragement).commit();
        }
    }
}
