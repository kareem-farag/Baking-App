package com.example.backingapp.recyclers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.backingapp.R;
import com.example.backingapp.utils.Recipe;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    List<Recipe> recipeList;
    Context context;


    public RecipeAdapter(Context context, List<Recipe> recipesIds) {
        this.recipeList = recipesIds;
        this.context = context;

    }

    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recipe_holder, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder viewHolder, int i) {
        viewHolder.recipeTitle.setText(recipeList.get(i).getName());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView recipeTitle;

        //   final ImageView recipeImage ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeTitle = itemView.findViewById(R.id.recipe_title);

        }
    }
}
