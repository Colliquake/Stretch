package com.example.stretch.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.stretch.R

class YourWorkoutsHomeAdapter: RecyclerView.Adapter<YourWorkoutsHomeAdapter.YourWorkoutsHomeViewHolder>() {
    
    val list: List<String>
    
    init{
        list = listOf("Back stretches", "Intense workout", "Intense KILLER workout!!!")
    }

    class YourWorkoutsHomeViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.item_your_workouts)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourWorkoutsHomeViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.your_workouts_item_view, parent, false)
        return YourWorkoutsHomeViewHolder(layout)
    }
    
    override fun getItemCount(): Int {
        return list.size
    }
    
    override fun onBindViewHolder(holder: YourWorkoutsHomeViewHolder, position: Int) {
        val item = list[position]
        holder.button.text = item.toString()
        
        //set on click listener, do the navigation bullshit
    }
    
}