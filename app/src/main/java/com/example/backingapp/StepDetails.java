package com.example.backingapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.backingapp.fragment.StepViewerFragment;
import com.example.backingapp.utils.Step;

import java.util.List;

public class StepDetails extends AppCompatActivity {
    private Button nextButton;
    private Button previousButton;
    private Step step;
    private List<Step> stepList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_details);


        final StepViewerFragment stepViewerFragment = new StepViewerFragment();

        if (getIntent().getExtras() != null) {
            step = getIntent().getExtras().getParcelable("step");
            stepList = getIntent().getExtras().getParcelableArrayList("stepList");

        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        stepViewerFragment.setStep(step);

        fragmentManager.beginTransaction().add(R.id.step_detail_video, stepViewerFragment).commit();

        if (findViewById(R.id.next_step_button) != null) {
            nextButton = findViewById(R.id.next_step_button);
            previousButton = findViewById(R.id.previous_step_button);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StepViewerFragment newStepViewerFragment = new StepViewerFragment();
                    step = step.getNextStep(step, stepList);
                    if (step != null) {
                        newStepViewerFragment.setStep(step);
                        fragmentManager.beginTransaction().replace(R.id.step_detail_video, newStepViewerFragment).commit();
                    } else {
                        Toast.makeText(getBaseContext(), "Sorry, It's the last step", Toast.LENGTH_LONG);
                    }
                    newStepViewerFragment = null;
                }
            });

            previousButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StepViewerFragment newStepViewerFragment = new StepViewerFragment();
                    step = step.getPreviousStep(step, stepList);
                    if (step != null) {
                        newStepViewerFragment.setStep(step);
                        fragmentManager.beginTransaction().replace(R.id.step_detail_video, newStepViewerFragment).commit();
                    } else {
                        Toast.makeText(getBaseContext(), "Sorry, It's the first step", Toast.LENGTH_LONG);
                    }
                    newStepViewerFragment = null;


                }
            });
        }

    }
}