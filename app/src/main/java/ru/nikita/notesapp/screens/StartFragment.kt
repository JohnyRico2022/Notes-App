package ru.nikita.notesapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.nikita.notesapp.APP
import ru.nikita.notesapp.R
import ru.nikita.notesapp.adapter.NoteAdapter
import ru.nikita.notesapp.databinding.FragmentStartBinding
import ru.nikita.notesapp.viewModels.StartViewModel


class StartFragment : Fragment() {
    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NoteAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)

        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDatabase()

        recyclerView = binding.recyclerViewNotes
        adapter = NoteAdapter()
        recyclerView.adapter = adapter

        viewModel.getAllNotes().observe(viewLifecycleOwner) {list -> // все что пришло из обсервера попадает в list
            adapter.setList(list.asReversed()) //asReversed отвечает за добавление заметок в начале или конце списка
        }


        binding.addNoteButton.setOnClickListener {

            findNavController().navigate(R.id.action_startFragment_to_addNoteFragment)
        }




        return binding.root
    }

}