package ru.nikita.notesapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.nikita.notesapp.R
import ru.nikita.notesapp.databinding.FragmentAddNoteBinding
import ru.nikita.notesapp.model.Note
import ru.nikita.notesapp.viewModels.AddNoteViewModel


class AddNoteFragment : Fragment() {
    lateinit var binding: FragmentAddNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)

        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)

        binding.saveButton.setOnClickListener {
            val title = binding.noteTitle.text.toString()
            val descr = binding.noteText.text.toString()
            viewModel.insert(Note(title = title, description = descr)) {}
            findNavController().navigate(R.id.startFragment)
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.startFragment)
        }

        return binding.root

    }
}
