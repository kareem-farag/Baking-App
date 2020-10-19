package com.example.backingapp.recyclers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.backingapp.R;
import com.example.backingapp.utils.Ingredient;
import com.example.backingapp.utils.Recipe;

import java.util.List;
import java.util.zip.Inflater;

public class RecipeAdapter extends BaseAdapter {
    List <Recipe> recipeList ;
    Context context;


    public RecipeAdapter (Context context , List<Recipe> recipesIds) {
        this.recipeList = recipesIds ;
        this.context = context;

    }
    @Override
    public int getCount() {
        return recipeList.size();
    }

    @Override
    public Object getItem(int position) {
        return recipeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Recipe recipe = recipeList.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recipe_holder, parent,false);
        TextView textView = view.findViewById(R.id.recipe_name);
        ImageView imageView = view.findViewById(R.id.recipe_image);

        textView.setText(recipe.getName());
        //imageView.setImageResource(recipe.getImage());

        return view;
    }

    /*
    public class viewHolder extends RecyclerView.ViewHolder {

        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    */
}
