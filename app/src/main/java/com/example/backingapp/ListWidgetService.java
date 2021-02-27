package com.example.backingapp;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.backingapp.utils.Ingredient;

import java.util.List;

public class ListWidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {

        return new ListRemoteViewsFactory(this.getApplicationContext());
    }

}

class ListRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {
    private Context context;
    private List<Ingredient> ingredientList;


    public ListRemoteViewsFactory(Context context) {
        this.context = context;
    }


    @Override
    public void onCreate() {
    }

    @Override
    public void onDataSetChanged() {
        ingredientList = MainActivity.recipe.getIngredientList();

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        if (ingredientList == null) {
            return 0;
        } else {
            return ingredientList.size();
        }

    }

    @Override
    public RemoteViews getViewAt(int position) {
        ingredientList = MainActivity.recipe.getIngredientList();

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_ingredient_item);
        Ingredient ingredient = ingredientList.get(position);
        remoteViews.setTextViewText(R.id.widget_ingredient_text, ingredient.getQuantity() + " " + ingredient.getMeasure() + " of " + ingredient.getIngredient());

        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        if (ingredientList == null) {
            return 0;
        } else {
            return ingredientList.size();
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }
}
