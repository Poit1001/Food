package com.example.food.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.food.R;
import com.example.food.data.DishAdapter;
import com.example.food.model.Dish;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DishAdapter dishAdapter;
    private ArrayList<Dish> dishes;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dishes = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);


        getDishes();

    }

    private void getDishes() {
        String URL = "https://www.themealdb.com/api/json/v1/1/random.php";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("meals");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.optJSONObject(i);

                        String title = jsonObject.getString("strMeal");
                        String category = jsonObject.getString("strCategory");
                        String instruction = jsonObject.getString("strInstructions");
                        String pictureUrl = jsonObject.getString("strMealThumb");

                        String [] ingredients = new String[20];

                        String ingredient1 = jsonObject.getString("strIngredient1");
                        ingredients[0] = ingredient1;
                        String ingredient2 = jsonObject.getString("strIngredient2");
                        ingredients[1] = ingredient2;
                        String ingredient3 = jsonObject.getString("strIngredient3");
                        ingredients[2] = ingredient3;
                        String ingredient4 = jsonObject.getString("strIngredient4");
                        ingredients[3] = ingredient4;
                        String ingredient5 = jsonObject.getString("strIngredient5");
                        ingredients[4] = ingredient5;
                        String ingredient6 = jsonObject.getString("strIngredient6");
                        ingredients[5] = ingredient6;
                        String ingredient7 = jsonObject.getString("strIngredient7");
                        ingredients[6] = ingredient7;
                        String ingredient8 = jsonObject.getString("strIngredient8");
                        ingredients[7] = ingredient8;
                        String ingredient9 = jsonObject.getString("strIngredient9");
                        ingredients[8] = ingredient9;
                        String ingredient10 = jsonObject.getString("strIngredient10");
                        ingredients[9] = ingredient10;
                        String ingredient11 = jsonObject.getString("strIngredient11");
                        ingredients[10] = ingredient11;
                        String ingredient12 = jsonObject.getString("strIngredient12");
                        ingredients[11] = ingredient12;
                        String ingredient13 = jsonObject.getString("strIngredient13");
                        ingredients[12] = ingredient13;
                        String ingredient14 = jsonObject.getString("strIngredient14");
                        ingredients[13] = ingredient14;
                        String ingredient15 = jsonObject.getString("strIngredient15");
                        ingredients[14] = ingredient15;
                        String ingredient16 = jsonObject.getString("strIngredient16");
                        ingredients[15] = ingredient16;
                        String ingredient17 = jsonObject.getString("strIngredient17");
                        ingredients[16] = ingredient17;
                        String ingredient18 = jsonObject.getString("strIngredient18");
                        ingredients[17] = ingredient18;
                        String ingredient19 = jsonObject.getString("strIngredient19");
                        ingredients[18] = ingredient19;

                        String ingredientsStr = "Ingredients: " + ingredients[0];
                        for (int j = 1; j < ingredients.length; j++) {
                            if (ingredients[j] != "null") {
                                ingredientsStr = ingredientsStr + ", " + ingredients[j];
                            } else break;
                        }
                        ingredientsStr += ".";


                        Dish dish = new Dish();
                        dish.setTitle(title);
                        dish.setCategory(category);
                        dish.setInstruction(instruction);
                        dish.setPictureUrl(pictureUrl);
                        dish.setIngredients(ingredientsStr);

                        dishes.add(dish);

                    }

                    dishAdapter = new DishAdapter(MainActivity.this, dishes);
                    recyclerView.setAdapter(dishAdapter);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(request);

    }

    public void clickLetterButton(View view) {

        int viewId = view.getId();

        if (viewId == R.id.button_a) openFirstLetterActivity("a");
        else if (viewId == R.id.button_b) openFirstLetterActivity("b");
        else if (viewId == R.id.button_c) openFirstLetterActivity("c");
        else if (viewId == R.id.button_d) openFirstLetterActivity("d");
        else if (viewId == R.id.button_e) openFirstLetterActivity("e");
        else if (viewId == R.id.button_f) openFirstLetterActivity("f");
        else if (viewId == R.id.button_g) openFirstLetterActivity("g");
        else if (viewId == R.id.button_h) openFirstLetterActivity("h");
        else if (viewId == R.id.button_i) openFirstLetterActivity("i");
        else if (viewId == R.id.button_j) openFirstLetterActivity("j");
        else if (viewId == R.id.button_k) openFirstLetterActivity("k");
        else if (viewId == R.id.button_l) openFirstLetterActivity("l");
        else if (viewId == R.id.button_m) openFirstLetterActivity("m");
        else if (viewId == R.id.button_n) openFirstLetterActivity("n");
        else if (viewId == R.id.button_o) openFirstLetterActivity("o");
        else if (viewId == R.id.button_p) openFirstLetterActivity("p");
        else if (viewId == R.id.button_q) openFirstLetterActivity("q");
        else if (viewId == R.id.button_r) openFirstLetterActivity("r");
        else if (viewId == R.id.button_s) openFirstLetterActivity("s");
        else if (viewId == R.id.button_t) openFirstLetterActivity("t");
        else if (viewId == R.id.button_u) openFirstLetterActivity("u");
        else if (viewId == R.id.button_v) openFirstLetterActivity("v");
        else if (viewId == R.id.button_w) openFirstLetterActivity("w");
        else if (viewId == R.id.button_x) openFirstLetterActivity("x");
        else if (viewId == R.id.button_y) openFirstLetterActivity("y");
        else if (viewId == R.id.button_z) openFirstLetterActivity("z");



    }

    private void openFirstLetterActivity(String letter) {
        Intent intent = new Intent(MainActivity.this, FirstLetterActivity.class);
        intent.putExtra("letter", letter);
        startActivity(intent);
        finish();
    }
}