package com.example.stretch.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.stretch.R
import java.security.AccessController.getContext

class CategoryItemsAdapter(category: String, context: Context) :
    RecyclerView.Adapter<CategoryItemsAdapter.CategoryItemsViewHolder>() {
    
    val data: Array<String>
    
    init {
        val resString = when (category) {
            "chest" -> R.array.chest
            "shoulder" -> R.array.shoulder
            "biceps" -> R.array.biceps
            "triceps" -> R.array.triceps
            "legs" -> R.array.legs
            "back" -> R.array.back
            "glute" -> R.array.glute
            "abs" -> R.array.abs
            "calves" -> R.array.calves
            "forearmFlexors" -> R.array.forearmFlexors
            "forearmExtensors" -> R.array.forearmExtensors
            else -> R.array.cardio
        }
        data = context.resources.getStringArray(resString)
    }
    
    class CategoryItemsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val item = view.findViewById<Button>(R.id.category_item)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemsViewHolder {
        //reusing "categories" layout
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.categories, parent, false)
        return CategoryItemsViewHolder(layout)
    }
    
    override fun getItemCount(): Int {
        return data.size
    }
    
    override fun onBindViewHolder(holder: CategoryItemsViewHolder, position: Int) {
        val item = data[position]
        holder.item.text = item
    }
    
}