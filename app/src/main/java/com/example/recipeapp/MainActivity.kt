package com.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var addButton: FloatingActionButton
    private lateinit var myDB: MyDatabaseHelper
    private lateinit var recipe_ids: ArrayList<String>
    private lateinit var recipe_names: ArrayList<String>
    private lateinit var recipe_ingredients: ArrayList<String>
    private lateinit var recipe_steps: ArrayList<String>
    private lateinit var recipe_authors: ArrayList<String>
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        addButton = findViewById<FloatingActionButton>(R.id.addButton)
        addButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        })

        myDB = MyDatabaseHelper(this)
        recipe_ids = ArrayList()
        recipe_names = ArrayList()
        recipe_ingredients = ArrayList()
        recipe_steps = ArrayList()
        recipe_authors = ArrayList()

        storeDataInArrays()

        customAdapter = CustomAdapter(this, this, recipe_ids, recipe_names, recipe_ingredients, recipe_steps, recipe_authors)
        recyclerView.adapter = customAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            recreate()
        }
    }

    fun storeDataInArrays() {
        var cursor = myDB.readAllData()
        if (cursor.count == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show()
        } else {
            while (cursor.moveToNext()) {
                recipe_ids.add(cursor.getString(0))
                recipe_names.add(cursor.getString(1))
                recipe_ingredients.add(cursor.getString(2))
                recipe_steps.add(cursor.getString(3))
                recipe_authors.add(cursor.getString(4))
            }
        }
    }
}