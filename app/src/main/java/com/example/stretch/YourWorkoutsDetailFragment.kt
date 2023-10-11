package com.example.stretch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stretch.adapter.YourWorkoutsDetailAdapter
import com.example.stretch.adapter.YourWorkoutsHomeAdapter
import com.example.stretch.databinding.FragmentYourWorkoutsHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [YourWorkoutsDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class YourWorkoutsDetailFragment : Fragment() {
    private var _binding: FragmentYourWorkoutsHomeBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var recyclerView: RecyclerView
    
    private var workoutId: Int? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        arguments?.let{
            workoutId = it.getInt("workout_id")
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentYourWorkoutsHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = YourWorkoutsDetailAdapter(workoutId!!, requireContext())
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}