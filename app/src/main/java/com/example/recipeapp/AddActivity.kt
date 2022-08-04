package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AddActivity : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var ingredientsInput: EditText
    private lateinit var stepsInput: EditText
    private lateinit var authorInput: EditText
    private lateinit var submitRecipeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        nameInput = findViewById(R.id.nameInput);
        ingredientsInput = findViewById(R.id.ingredientsInput);
        stepsInput = findViewById(R.id.stepsInput);
        authorInput = findViewById(R.id.authorInput);
        submitRecipeButton = findViewById(R.id.submitRecipeButton);
        submitRecipeButton.setOnClickListener(View.OnClickListener {
            val myDB = MyDatabaseHelper(this);

            myDB.addRecipe(
                nameInput.text.toString(),
                ingredientsInput.text.toString(),
                stepsInput.text.toString(),
                authorInput.text.toString())
        })
    }
}