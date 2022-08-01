package com.example.recipeapp;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "";
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
                        COLUMN_NAME + "TEXT, " +
                        COLUMN_INGREDIENTS + "TEXT, " +
                        COLUMN_STEPS + "TEXT, " +
                        COLUMN_AUTHOR + "TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
    }
}
