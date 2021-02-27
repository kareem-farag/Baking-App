package com.example.backingapp.recyclers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.backingapp.R;
import com.example.backingapp.utils.Recipe;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    OnRecipeClickListener clickListener;
    List<Recipe> recipeList;
    Context context;

    public RecipeAdapter(Context context, List<Recipe> recipesIds, OnRecipeClickListener onRecipeClickListener) {
        this.recipeList = recipesIds;
        this.context = context;
        this.clickListener = onRecipeClickListener;

    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder viewHolder, int i) {
        final int position = i;
        viewHolder.recipeTitle.setText(recipeList.get(i).getName());
        viewHolder.recipeTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onRecipeClickListener(recipeList.get(position));
            }
        });
    }

    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recipe_holder, viewGroup, false);
        return new ViewHolder(view);
    }

    public Recipe getRecipeById(int id) {
        return recipeList.get(id);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public interface OnRecipeClickListener {
        void onRecipeClickListener(Recipe recipe);
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
