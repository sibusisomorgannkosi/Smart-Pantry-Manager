package com.example.smartpantry;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashSet;
import java.util.Set;

public class RecipeActivity extends AppCompatActivity {
    private DatabaseHelper db;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        db = new DatabaseHelper(this);
        result = findViewById(R.id.tvRecipeResult);
        showRecipes();
    }

    private void showRecipes() {
        Set<String> ingredients = new HashSet<>();
        for (PantryItem item : db.getAllItems()) {
            ingredients.add(item.getName().trim().toLowerCase());
        }

        StringBuilder text = new StringBuilder();
        text.append("Recipes are shown only when ALL required ingredients are in your pantry.\n\n");

        addRecipe(text, ingredients, "Egg Fried Rice",
                new String[]{"rice", "egg", "oil"});
        addRecipe(text, ingredients, "Tomato Sandwich",
                new String[]{"bread", "tomato"});
        addRecipe(text, ingredients, "Pasta with Tomato",
                new String[]{"pasta", "tomato", "onion"});
        addRecipe(text, ingredients, "Peanut Butter Toast",
                new String[]{"bread", "peanut butter"});

        if (text.toString().endsWith("available.\n")) {
            text.append("\nNo complete recipe matches your current pantry.");
        }
        result.setText(text.toString());
    }

    private void addRecipe(StringBuilder text, Set<String> pantry,
                           String name, String[] required) {
        for (String ingredient : required) {
            if (!pantry.contains(ingredient)) return;
        }
        text.append("✓ ").append(name).append("\n")
                .append("Ingredients: ")
                .append(String.join(", ", required))
                .append("\n\n");
    }
}
