package com.example.smartpantry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "smart_pantry.db";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE pantry_items (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "quantity REAL NOT NULL," +
                "unit TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS pantry_items");
        onCreate(db);
    }

    public long addItem(String name, double quantity, String unit) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("quantity", quantity);
        values.put("unit", unit);
        return getWritableDatabase().insert("pantry_items", null, values);
    }

    public ArrayList<PantryItem> getAllItems() {
        ArrayList<PantryItem> items = new ArrayList<>();
        Cursor cursor = getReadableDatabase().query("pantry_items",
                null, null, null, null, null, "name ASC");
        while (cursor.moveToNext()) {
            items.add(new PantryItem(
                    cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                    cursor.getString(cursor.getColumnIndexOrThrow("name")),
                    cursor.getDouble(cursor.getColumnIndexOrThrow("quantity")),
                    cursor.getString(cursor.getColumnIndexOrThrow("unit"))
            ));
        }
        cursor.close();
        return items;
    }

    public PantryItem getItem(int id) {
        Cursor c = getReadableDatabase().query("pantry_items", null, "id=?",
                new String[]{String.valueOf(id)}, null, null, null);
        PantryItem item = null;
        if (c.moveToFirst()) {
            item = new PantryItem(
                    c.getInt(c.getColumnIndexOrThrow("id")),
                    c.getString(c.getColumnIndexOrThrow("name")),
                    c.getDouble(c.getColumnIndexOrThrow("quantity")),
                    c.getString(c.getColumnIndexOrThrow("unit"))
            );
        }
        c.close();
        return item;
    }

    public int updateItem(int id, String name, double quantity, String unit) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("quantity", quantity);
        values.put("unit", unit);
        return getWritableDatabase().update("pantry_items", values, "id=?",
                new String[]{String.valueOf(id)});
    }

    public int deleteItem(int id) {
        return getWritableDatabase().delete("pantry_items", "id=?",
                new String[]{String.valueOf(id)});
    }
}
