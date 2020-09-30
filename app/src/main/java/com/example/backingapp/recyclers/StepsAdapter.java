package com.example.backingapp.recyclers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class StepsAdapter extends RecyclerView.Adapter <StepsAdapter.viewHolder> {
    @NonNull
    @Override
    public StepsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StepsAdapter.viewHolder viewHolder, int i) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
