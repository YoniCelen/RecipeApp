package com.example.recipeapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "recipeDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "recipes";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "recipe_name";
    private static final String COLUMN_INGREDIENTS = "recipe_ingredients";
    private static final String COLUMN_STEPS = "recipe_steps";
    private static final String COLUMN_AUTHOR = "recipe_author";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_INGREDIENTS + " TEXT, " +
                        COLUMN_STEPS + " TEXT, " +
                        COLUMN_AUTHOR + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    void addRecipe(String name, String ingredients, String steps, String author){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_INGREDIENTS, ingredients);
        cv.put(COLUMN_STEPS, steps);
        cv.put(COLUMN_AUTHOR, author);

        //CRASHES HERE

        long result = db.insert(TABLE_NAME, null, cv);

        if (result == -1) {
            Toast.makeText(this.context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this.context, "Successfully added", Toast.LENGTH_SHORT).show();
        }
    }
}
