package com.example.smartpantry.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.smartpantry.R;

/**
 * RecipeDetailActivity displays detailed information about a specific recipe.
 *
 * This Activity receives the recipe ID via Intent and displays:
 * - Recipe name
 * - Description
 * - Required ingredients with quantities
 * - Preparation instructions
 *
 * This Activity will be fully implemented in Stage 10.
 */
public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        
        // Stage 1: Basic structure only
        // Full implementation in subsequent stages
    }
}
