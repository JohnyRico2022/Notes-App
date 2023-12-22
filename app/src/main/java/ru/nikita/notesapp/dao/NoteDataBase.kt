package ru.nikita.notesapp.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.nikita.notesapp.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun getNoteDao(): Dao

    companion object {

        private var database: NoteDataBase? = null
        fun getInstance(context: Context): NoteDataBase {
            return if (database == null) {
                database = Room.databaseBuilder(context, NoteDataBase::class.java, "db").build()
                database as NoteDataBase

            } else {
                database as NoteDataBase
            }
        }
    }
}