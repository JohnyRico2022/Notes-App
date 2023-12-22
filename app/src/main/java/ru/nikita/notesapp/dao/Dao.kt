package ru.nikita.notesapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.nikita.notesapp.model.Note

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)
    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * from note_table")
     fun getAllNotes(): LiveData<List<Note>>
}