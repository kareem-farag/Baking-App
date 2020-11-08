package com.example.backingapp;

import android.content.Context;
import android.util.DisplayMetrics;

public class ResponsiveLayout {

    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int noOfColumns = 1;
        if (displayMetrics.widthPixels / displayMetrics.density > 600) {
            noOfColumns = 3;
        }

        return noOfColumns;
    }

}
