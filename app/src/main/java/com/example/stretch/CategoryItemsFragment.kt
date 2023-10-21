package com.example.stretch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stretch.adapter.CategoryItemsAdapter
import com.example.stretch.databinding.FragmentCategoryItemsBinding


/**
 * A simple [Fragment] subclass.
 * Use the [CategoryItemsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryItemsFragment : Fragment() {
    private var _binding: FragmentCategoryItemsBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var recyclerView: RecyclerView
    
    private var category: String? = null
    
    companion object {
        const val SEARCH_PREFIX = "http://www.strengthlog.com/"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        arguments?.let {
            category = it.getString("category")
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryItemsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.categoryItemsRecyclerView
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = CategoryItemsAdapter(category!!, requireContext())
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
}