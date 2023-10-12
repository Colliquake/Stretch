package com.example.stretch

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.stretch.databinding.FragmentExploreHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ExploreHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExploreHomeFragment : Fragment(R.layout.fragment_explore_home) {
    
    private var _binding: FragmentExploreHomeBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExploreHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
        val stretches_button = view.findViewById<Button>(R.id.stretches_button)
        stretches_button.setOnClickListener {
            Log.v("ExploreHomeFragment", "stretches button clicked!")
            val action = ExploreHomeFragmentDirections.actionExploreHomeFragmentToExploreCategoriesFragment(0)
            view.findNavController().navigate(action)
        }
        
        val exercises_button = view.findViewById<Button>(R.id.exercises_button)
        exercises_button.setOnClickListener {
            Log.v("ExploreHomeFragment", "exercises button clicked!")
            val action = ExploreHomeFragmentDirections.actionExploreHomeFragmentToExploreCategoriesFragment(1)
            view.findNavController().navigate(action)
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}