package ru.nikita.notesapp.repository

import androidx.lifecycle.LiveData
import ru.nikita.notesapp.dao.Dao
import ru.nikita.notesapp.model.Note

class RepositoryImpl(
    private val dao: Dao
) : Repository {

    override val allNotes: LiveData<List<Note>>
        get() = dao.getAllNotes()

    override suspend fun insertNote(note: Note, onSuccess: () -> Unit) {
        dao.insert(note)
        onSuccess
    }

    override suspend fun deleteNote(note: Note, onSuccess: () -> Unit) {
        dao.delete(note)
        onSuccess
    }
}