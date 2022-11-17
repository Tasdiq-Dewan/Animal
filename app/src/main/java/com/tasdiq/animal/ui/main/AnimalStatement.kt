package com.tasdiq.animal.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.tasdiq.animal.databinding.FragmentAnimalPromptBinding
import com.tasdiq.animal.databinding.FragmentAnimalStatementBinding
import com.tasdiq.animal.ui.main.MainViewModel

class AnimalStatement : Fragment() {

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentAnimalStatementBinding? = null
    private val binding get() = _binding!!
    private var animalName : String  = "Godzilla"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAnimalStatementBinding.inflate(inflater, container, false)
        val view = binding.root
        arguments?.let{
            val input = it.getString("animalName")
            if(input != null){
                animalName = input
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.animalStatementText.text = "You are a $animalName"
    }

    companion object {
        fun newInstance() = AnimalStatement()
    }
}