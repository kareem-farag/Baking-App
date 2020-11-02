package com.example.backingapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.backingapp.R;
import com.example.backingapp.StepDetails;
import com.example.backingapp.recyclers.StepsAdapter;
import com.example.backingapp.utils.Ingredient;
import com.example.backingapp.utils.Step;

import java.util.List;

public class StepsSelectFragement extends Fragment {

    private Context context;
    private List<Step> stepList;
    private List<Ingredient> ingredientList;
    private Boolean isTablet;

    public StepsSelectFragement() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipe_steps_list, container, false);
        TextView ingredients = rootView.findViewById(R.id.recipe_ingredients);
        RecyclerView stepsRecycler = rootView.findViewById(R.id.recipe_steps_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        StepsAdapter stepsAdapter = new StepsAdapter(stepList, context, new StepsAdapter.OnStepClickListener() {
            @Override
            public void onItemClickListener(Step step) {

                Intent intent = new Intent(context, StepDetails.class);

                startActivity(intent);


            }
        });

        stepsRecycler.setAdapter(stepsAdapter);
        stepsRecycler.setLayoutManager(linearLayoutManager);

        // deal with the rootView elements

        return rootView;


    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public Boolean getTablet() {
        return isTablet;
    }

    public void setTablet(Boolean tablet) {
        isTablet = tablet;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}

