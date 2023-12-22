package ru.nikita.notesapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.nikita.notesapp.REPOSITORY
import ru.nikita.notesapp.model.Note

class AddNoteViewModel : ViewModel() {

    fun insert(noteModel: Note, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertNote(noteModel) {
                onSuccess()
            }
        }

}