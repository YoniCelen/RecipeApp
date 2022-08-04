package com.example.recipeapp;

import com.example.recipeapp.R.layout.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<String> recipe_id, recipe_name, recipe_ingredients, recipe_steps, recipe_author;

    CustomAdapter(Context context, ArrayList recipe_id, ArrayList recipe_name, ArrayList recipe_ingredients, ArrayList recipe_steps, ArrayList recipe_author) {
        this.context = context;
        this.recipe_id = recipe_id;
        this.recipe_name = recipe_name;
        this.recipe_ingredients = recipe_ingredients;
        this.recipe_steps = recipe_steps;
        this.recipe_author = recipe_author;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.recipe_id_txt.setText(String.valueOf(recipe_id.get(position)));
        holder.recipe_name_txt.setText(String.valueOf(recipe_name.get(position)));
        holder.recipe_author_txt.setText(String.valueOf(recipe_author.get(position)));
    }

    @Override
    public int getItemCount() {
        return recipe_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView recipe_id_txt, recipe_name_txt, recipe_author_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recipe_id_txt = itemView.findViewById(R.id.recipe_id_txt);
            recipe_name_txt = itemView.findViewById(R.id.recipe_name_txt);
            recipe_author_txt = itemView.findViewById(R.id.recipe_author_txt);
        }
    }
}
