package com.example.backingapp.recyclers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.backingapp.R;
import com.example.backingapp.utils.Step;

import java.util.List;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.viewHolder> {
    private OnStepClickListener onStepClickListener;
    private List<Step> stepList;
    private Context context;

    public StepsAdapter(List<Step> steps, Context context, OnStepClickListener onStepClickListener) {
        this.stepList = steps;
        this.context = context;
        this.onStepClickListener = onStepClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull StepsAdapter.viewHolder viewHolder, int i) {
        final int itemIndex = i;
        viewHolder.stepTextView.setText(stepList.get(i).getDescription());
        viewHolder.stepTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStepClickListener.onItemClickListener(stepList.get(itemIndex));
            }
        });
    }

    @NonNull
    @Override

    public StepsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.step_holder, viewGroup, false);
        return new StepsAdapter.viewHolder(view);
    }


    public interface OnStepClickListener {
        public void onItemClickListener(Step step);
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
