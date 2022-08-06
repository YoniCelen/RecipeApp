package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UpdateActivity : AppCompatActivity() {

    private lateinit var nameUpdate: EditText
    private lateinit var ingredientsUpdate: EditText
    private lateinit var stepsUpdate: EditText
    private lateinit var authorUpdate: EditText
    private lateinit var updateRecipeButton: Button

    private lateinit var id: String
    private lateinit var name: String
    private lateinit var ingredients: String
    private lateinit var steps: String
    private lateinit var author: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        nameUpdate = findViewById(R.id.nameUpdate)
        ingredientsUpdate = findViewById(R.id.ingredientsUpdate)
        stepsUpdate = findViewById(R.id.stepsUpdate)
        authorUpdate = findViewById(R.id.authorUpdate)
        updateRecipeButton = findViewById(R.id.UpdateRecipeButton)
        //getAndSetIntentData() needs to be called before updateData()
        getAndSetIntentData()
        updateRecipeButton.setOnClickListener(View.OnClickListener {
            var myDB = MyDatabaseHelper(this)
            myDB.updateData(id,
                nameUpdate.text.toString(),
                ingredientsUpdate.text.toString(),
                stepsUpdate.text.toString(),
                authorUpdate.text.toString())
        })
    }

    fun getAndSetIntentData() {
        if (intent.hasExtra("id") && intent.hasExtra("name") && intent.hasExtra("ingredients") && intent.hasExtra("steps") && intent.hasExtra("author")) {
            id = intent.getStringExtra("id")!!
            name = intent.getStringExtra("name")!!
            ingredients = intent.getStringExtra("ingredients")!!
            steps = intent.getStringExtra("steps")!!
            author = intent.getStringExtra("author")!!

            nameUpdate.text = Editable.Factory.getInstance().newEditable(name)
            ingredientsUpdate.text = Editable.Factory.getInstance().newEditable(ingredients)
            stepsUpdate.text = Editable.Factory.getInstance().newEditable(steps)
            authorUpdate.text = Editable.Factory.getInstance().newEditable(author)
        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show()
        }
    }
}
