package ru.nikita.notesapp.repository

import androidx.lifecycle.LiveData
import ru.nikita.notesapp.model.Note

interface Repository {

    fun allNotes(): LiveData<List<Note>>
  //  suspend fun insertNote(note: Note, onSuccess: () -> Unit)
  //  suspend fun deleteNote(note: Note, onSuccess: () -> Unit)


}