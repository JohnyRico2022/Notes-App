package ru.nikita.notesapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.nikita.notesapp.R
import ru.nikita.notesapp.adapter.NoteAdapter
import ru.nikita.notesapp.databinding.FragmentStartBinding
import ru.nikita.notesapp.viewModels.NoteViewModel



class StartFragment : Fragment() {
    lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)

        val viewModel: NoteViewModel by viewModels()
         val adapter = NoteAdapter()
        binding.recyclerViewNotes.adapter = adapter



        viewModel.data.observe(viewLifecycleOwner) {notes -> // все что пришло из обсервера попадает в notes
            adapter.submitList(notes) //asReversed отвечает за добавление заметок в начале или конце списка
        }


        binding.addNoteButton.setOnClickListener {

            findNavController().navigate(R.id.action_startFragment_to_addNoteFragment)
        }




        return binding.root
    }

}