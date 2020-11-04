package com.example.backingapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.backingapp.fragment.StepViewerFragment;

public class StepDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_details);

        StepViewerFragment stepViewerFragment = new StepViewerFragment();
        if (getIntent().getExtras() != null) {
            stepViewerFragment.setStep(getIntent().getExtras().getParcelable("step"));
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.step_detail_video, stepViewerFragment).commit();
    }
}