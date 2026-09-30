package com.example.smartpantry;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddItemActivity extends AppCompatActivity {
    private EditText name, quantity, unit;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        db = new DatabaseHelper(this);

        name = findViewById(R.id.etName);
        quantity = findViewById(R.id.etQuantity);
        unit = findViewById(R.id.etUnit);

        Button save = findViewById(R.id.btnSave);
        save.setOnClickListener(v -> saveItem());
    }

    private void saveItem() {
        String n = name.getText().toString().trim();
        String q = quantity.getText().toString().trim();
        String u = unit.getText().toString().trim();

        if (n.isEmpty() || q.isEmpty() || u.isEmpty()) {
            Toast.makeText(this, "Please complete all fields.", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double qty = Double.parseDouble(q);
            if (qty <= 0) throw new NumberFormatException();
            db.addItem(n, qty, u);
            Toast.makeText(this, "Item saved.", Toast.LENGTH_SHORT).show();
            finish();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Enter a valid positive quantity.", Toast.LENGTH_SHORT).show();
        }
    }
}
