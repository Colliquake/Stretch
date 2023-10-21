package com.example.stretch

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.stretch.databinding.FragmentExerciseItemBinding
import kotlinx.coroutines.NonDisposableHandle.parent
import java.io.InputStream

/**
 * A simple [Fragment] subclass.
 * Use the [ExerciseItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExerciseItemFragment : Fragment(R.layout.fragment_exercise_item) {
    
    private var _binding: FragmentExerciseItemBinding? = null
    private val binding get() = _binding!!
    
    private var exerciseName: String? = null
    private var categoryName: String? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        arguments?.let{
            val str = it.getString("exerciseItem")!!.replace(" ", "-").lowercase()
            exerciseName = str
            
            categoryName = it.getString("categoryName")
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExerciseItemBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val imageId = view.findViewById<ImageView>(R.id.exercise_image)
        val imageFileName = exerciseName!!.replace("-", "_")
        val inputStream = requireContext().assets.open("exercise/$categoryName/$imageFileName.webp")
        val drawable = Drawable.createFromStream(inputStream, null)
        imageId.setImageDrawable(drawable)
        inputStream.close()
        
        val viewDetailsButton = view.findViewById<Button>(R.id.view_exercise_details_button)
        viewDetailsButton.setOnClickListener {
//            val str = "${CategoryItemsFragment.SEARCH_PREFIX}$exerciseName/"
//            Log.v("Url", str)
            val queryUrl: Uri = Uri.parse("${CategoryItemsFragment.SEARCH_PREFIX}$exerciseName/")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context?.startActivity(intent)
        }
    }
    
}