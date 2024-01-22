package ru.nikita.notesapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.nikita.notesapp.model.Note

class RepositoryImpl : Repository {


    private var notes = listOf<Note>(
        Note( 1,"title 1", "text1"),
        Note( 2,"title 2", "text2"),
        Note( 3,"title 3", "text3"),
    )

    private val data = MutableLiveData(notes)
    override fun allNotes(): LiveData<List<Note>> = data
    /*override suspend fun insertNote(note: Note, onSuccess: () -> Unit) {
        dao.insert(note)
        onSuccess
    }

    override suspend fun deleteNote(note: Note, onSuccess: () -> Unit) {
        dao.delete(note)
        onSuccess
    }*/

}