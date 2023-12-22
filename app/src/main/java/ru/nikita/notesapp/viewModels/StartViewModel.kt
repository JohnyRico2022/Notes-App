package ru.nikita.notesapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import ru.nikita.notesapp.REPOSITORY
import ru.nikita.notesapp.dao.NoteDataBase
import ru.nikita.notesapp.model.Note
import ru.nikita.notesapp.repository.RepositoryImpl

class StartViewModel(application: Application) : AndroidViewModel(application) {

    val context = application

    fun initDatabase() {
        val daoNote = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = RepositoryImpl(daoNote)
    }

    fun getAllNotes(): LiveData<List<Note>> {
       return REPOSITORY.allNotes
    }

}