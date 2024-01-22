package ru.nikita.notesapp.viewModels

import androidx.lifecycle.ViewModel
import ru.nikita.notesapp.repository.Repository
import ru.nikita.notesapp.repository.RepositoryImpl

class NoteViewModel : ViewModel() {

    private val repository: Repository = RepositoryImpl()

    val data = repository.allNotes()

}