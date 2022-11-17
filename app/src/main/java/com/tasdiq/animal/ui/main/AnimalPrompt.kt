package com.tasdiq.animal.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.tasdiq.animal.databinding.FragmentAnimalPromptBinding

class AnimalPrompt : Fragment() {

    companion object {
        fun newInstance() = AnimalPrompt()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentAnimalPromptBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimalPromptBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val animalPromptText = binding.animalPromptText
        animalPromptText.text = "What animal are you?"
        val animalTextInput = binding.animalTextInput
        val animalButton = binding.animalButton
        animalButton.setOnClickListener{
            val action = AnimalPromptDirections.actionAnimalPromptToAnimalStatement(animalTextInput.text.toString())
            this.findNavController().navigate(action)
        }
    }


}