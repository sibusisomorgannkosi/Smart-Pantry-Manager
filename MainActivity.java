package com.example.smartpantry;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper db;
    private PantryAdapter adapter;
    private TextView tvSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        tvSummary = findViewById(R.id.tvSummary);
        RecyclerView recycler = findViewById(R.id.recyclerPantry);

        adapter = new PantryAdapter(db.getAllItems(),
                item -> startActivity(new Intent(this, EditItemActivity.class)
                        .putExtra("item_id", item.getId())));

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);

        Button add = findViewById(R.id.btnAdd);
        add.setOnClickListener(v -> startActivity(new Intent(this, AddItemActivity.class)));

        Button recipes = findViewById(R.id.btnRecipes);
        recipes.setOnClickListener(v -> startActivity(new Intent(this, RecipeActivity.class)));

        refresh();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (db != null) refresh();
    }

    private void refresh() {
        adapter.setItems(db.getAllItems());
        tvSummary.setText("Pantry items: " + db.getAllItems().size());
    }
}
