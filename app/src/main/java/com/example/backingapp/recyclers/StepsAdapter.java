package com.example.backingapp.recyclers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.backingapp.R;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.viewHolder> {
    List<String>

    @NonNull
    @Override

    public StepsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.step_holder, viewGroup, false);
        return new StepsAdapter.viewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull StepsAdapter.viewHolder viewHolder, int i) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        final TextView stepTextView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            stepTextView = itemView.findViewById(R.id.step_holder_description);
        }

    }
}
