package com.example.food.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.R;
import com.example.food.model.Dish;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {

    private Context context;
    private ArrayList<Dish> dishes;

    public DishAdapter (Context context, ArrayList<Dish> dishes) {
        this.context = context;
        this.dishes = dishes;
    }

    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.dish_item, parent, false);

        return new DishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DishViewHolder holder, int position) {

        Dish currentDish = dishes.get(position);

        String title = currentDish.getTitle();
        String category = currentDish.getCategory();
        String ingredients = currentDish.getIngredients();
        String instruction = currentDish.getInstruction();
        String pictureUrl = currentDish.getPictureUrl();

        holder.title_dish.setText(title);
        holder.CategoryTextView.setText(category);
        holder.ingredientsTextView.setText(ingredients);
        holder.instructionTextView.setText(instruction);

        Picasso.get().load(pictureUrl).fit().centerInside().into(holder.imageView_poster);
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }


    public class DishViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView_poster;
        TextView title_dish, CategoryTextView, instructionTextView, ingredientsTextView;



        public DishViewHolder(@NonNull View itemView) {
            super(itemView);

            title_dish = itemView.findViewById(R.id.title_dish);
            imageView_poster = itemView.findViewById(R.id.imageView_poster);
            CategoryTextView = itemView.findViewById(R.id.CategoryTextView);
            ingredientsTextView = itemView.findViewById(R.id.ingredientsTextView);
            instructionTextView = itemView.findViewById(R.id.instructionTextView);

        }
    }

}
