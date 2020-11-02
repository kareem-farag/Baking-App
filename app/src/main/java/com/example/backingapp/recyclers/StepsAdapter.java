package com.example.backingapp.recyclers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.backingapp.R;
import com.example.backingapp.utils.Step;

import java.util.List;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.viewHolder> {
    private List<Step> stepList;
    private Context context;

    public StepsAdapter(List<Step> steps, Context context) {
        this.stepList = steps;
        this.context = context;
    }

    @NonNull
    @Override

    public StepsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.step_holder, viewGroup, false);
        return new StepsAdapter.viewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull StepsAdapter.viewHolder viewHolder, int i) {
        viewHolder.stepTextView.setText(stepList.get(i).getDescription());
    }


    @Override
    public int getItemCount() {
        return stepList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        final TextView stepTextView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            stepTextView = itemView.findViewById(R.id.step_holder_description);
        }

    }
}
