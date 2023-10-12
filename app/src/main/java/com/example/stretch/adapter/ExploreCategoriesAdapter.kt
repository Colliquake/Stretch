package com.example.stretch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.stretch.R


class ExploreCategoriesAdapter(categoryId: Int): RecyclerView.Adapter<ExploreCategoriesAdapter.ExploreCategoriesViewHolder>() {
    
    val data: List<String>
    
    init{
        data = when(categoryId){
            0 -> listOf("Shoulders", "Lower Back", "Hamstrings", "Quads", "Inner Thighs", "Hips")
            1 -> listOf("Chest", "Shoulder", "Biceps", "Triceps", "Legs", "Back", "Glute", "Abs", "Calves", "Forearm Flexors", "Forearm Flexors", "Forearm Extensors", "Cardio Training")
            else -> listOf("this", "shouldn't", "be", "reachable")
        }
    }
    
    class ExploreCategoriesViewHolder(view: View): RecyclerView.ViewHolder(view){
        val category_button = view.findViewById<Button>(R.id.category_item)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreCategoriesViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.categories, parent, false)
        return ExploreCategoriesViewHolder(layout)
    }
    
    override fun getItemCount(): Int {
        return data.size
    }
    
    override fun onBindViewHolder(holder: ExploreCategoriesViewHolder, position: Int) {
        val item = data[position]
        holder.category_button.text = item
    }
    
}