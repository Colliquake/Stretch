package com.example.stretch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stretch.adapter.ExploreCategoriesAdapter
import com.example.stretch.databinding.FragmentExploreCategoriesBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ExploreCategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExploreCategoriesFragment : Fragment() {

    private var _binding: FragmentExploreCategoriesBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var recyclerView: RecyclerView
    
    private var categoryId: Int? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        arguments?.let{
            categoryId = it.getInt("id")
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExploreCategoriesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.exploreCategoriesRecyclerView
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = ExploreCategoriesAdapter(categoryId!!)
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
}