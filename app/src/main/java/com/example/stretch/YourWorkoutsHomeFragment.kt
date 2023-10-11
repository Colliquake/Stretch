package com.example.stretch

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stretch.adapter.YourWorkoutsHomeAdapter
import com.example.stretch.databinding.FragmentYourWorkoutsHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [YourWorkoutsHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class YourWorkoutsHomeFragment : Fragment() {
    private var _binding: FragmentYourWorkoutsHomeBinding? = null
    
    private val binding get() = _binding!!
    
    private lateinit var recyclerView: RecyclerView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = YourWorkoutsHomeAdapter()
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}