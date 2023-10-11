package com.example.stretch.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.stretch.R

class YourWorkoutsDetailAdapter(val id: Int, context: Context): RecyclerView.Adapter<YourWorkoutsDetailAdapter.YourWorkoutsDetailViewHolder>() {
    
    private val data: List<String>
    
    init{
        data = when(id){
            1 -> listOf("Shoulders stretch 4", "Lower back stretch 2", "Chest exercise 6", "Quads stretch 1", "Forearm flexors 11")
            2 -> listOf("Hamstrings stretch 2", "Shoulder exercise 5", "Back exercise 12", "Inner thighs stretch 7")
            else -> listOf("Hips stretch 4", "Back exercise 2")
            //TODO: I THINK "ELSE" OPTION SHOULD REFER TO CREATING A NEW SET
        }
    }

    class YourWorkoutsDetailViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.item_your_workouts)
    }
    
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): YourWorkoutsDetailViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.your_workouts_item_view, parent, false)
        return YourWorkoutsDetailViewHolder(layout)
    }
    
    override fun getItemCount(): Int {
        return data.size
    }
    
    override fun onBindViewHolder(holder: YourWorkoutsDetailViewHolder, position: Int) {
        val item = data[position]
        holder.button.text = item.toString()
    }
    
}