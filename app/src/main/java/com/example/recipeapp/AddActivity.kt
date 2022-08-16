package com.example.recipeapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.recipeapp.ui.login.LoginActivity

class AddActivity : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var ingredientsInput: EditText
    private lateinit var stepsInput: EditText
    private lateinit var authorInput: EditText
    private lateinit var submitRecipeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.action_favorites -> {
            true
        }

        R.id.action_account -> {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}