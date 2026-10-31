package com.example.comidas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView

class FoodAdapter(
    context: Context,
    private val dataSource: List<Food>
) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    var selectedPosition: Int = -1

    override fun getCount(): Int = dataSource.size

    override fun getItem(position: Int): Any = dataSource[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.item_food, parent, false)
            holder = ViewHolder(
                view.findViewById(R.id.ivFood),
                view.findViewById(R.id.tvTitle),
                view.findViewById(R.id.tvDescription),
                view.findViewById(R.id.rbSelect)
            )
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val food = dataSource[position]
        holder.tvTitle.text = food.name
        holder.tvDescription.text = food.description
        holder.ivFood.setImageResource(food.imageResId)

        // Marca el RadioButton únicamente si es la posición seleccionada
        holder.rbSelect.isChecked = (position == selectedPosition)

        return view
    }

    private class ViewHolder(
        val ivFood: ImageView,
        val tvTitle: TextView,
        val tvDescription: TextView,
        val rbSelect: RadioButton
    )
}