package com.example.comidas

import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var lvFoods: ListView
    private lateinit var tvSelectionStatus: TextView
    private lateinit var adapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvFoods = findViewById(R.id.lvFoods)
        tvSelectionStatus = findViewById(R.id.tvSelectionStatus)

        // Lista de comidas de la práctica
        val foodList = listOf(
            Food("PIZZA", "Cheesy, savory, customizable delight.", android.R.drawable.ic_menu_gallery),
            Food("HAMBURGER", "Juicy beef, fresh toppings classic.", android.R.drawable.ic_menu_gallery),
            Food("HOT DOG", "Grilled sausage, bun, toppings.", android.R.drawable.ic_menu_gallery),
            Food("TACOS", "Spicy, stuffed, Mexican favorite.", android.R.drawable.ic_menu_gallery),
            Food("FRENCH FRIES", "Crispy, golden, salty perfection.", android.R.drawable.ic_menu_gallery),
            Food("SANDWICH", "Bread, fillings, portable meal.", android.R.drawable.ic_menu_gallery),
            Food("CHICKEN NUGGETS", "Crispy, bite-sized chicken.", android.R.drawable.ic_menu_gallery)
        )

        adapter = FoodAdapter(this, foodList)
        lvFoods.adapter = adapter

        // Evento al pulsar un elemento de la lista
        lvFoods.setOnItemClickListener { _, _, position, _ ->
            adapter.selectedPosition = position
            adapter.notifyDataSetChanged() // Refresca para marcar el RadioButton

            val selectedFood = foodList[position]
            tvSelectionStatus.text = "Selected: ${selectedFood.name}"
        }
    }
}