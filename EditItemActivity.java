package com.example.smartpantry;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EditItemActivity extends AppCompatActivity {
    private EditText name, quantity, unit;
    private DatabaseHelper db;
    private int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        db = new DatabaseHelper(this);
        itemId = getIntent().getIntExtra("item_id", -1);

        name = findViewById(R.id.etName);
        quantity = findViewById(R.id.etQuantity);
        unit = findViewById(R.id.etUnit);

        PantryItem item = db.getItem(itemId);
        if (item != null) {
            name.setText(item.getName());
            quantity.setText(String.valueOf(item.getQuantity()));
            unit.setText(item.getUnit());
        }

        findViewById(Button.class, R.id.btnUpdate).setOnClickListener(v -> update());
        findViewById(Button.class, R.id.btnDelete).setOnClickListener(v -> delete());
    }

    private <T extends android.view.View> T findViewById(Class<T> type, int id) {
        return type.cast(super.findViewById(id));
    }

    private void update() {
        try {
            String n = name.getText().toString().trim();
            String u = unit.getText().toString().trim();
            double q = Double.parseDouble(quantity.getText().toString().trim());
            if (n.isEmpty() || u.isEmpty() || q <= 0) throw new Exception();
            db.updateItem(itemId, n, q, u);
            Toast.makeText(this, "Item updated.", Toast.LENGTH_SHORT).show();
            finish();
        } catch (Exception e) {
            Toast.makeText(this, "Please enter valid values.", Toast.LENGTH_SHORT).show();
        }
    }

    private void delete() {
        db.deleteItem(itemId);
        Toast.makeText(this, "Item deleted.", Toast.LENGTH_SHORT).show();
        finish();
    }
}
