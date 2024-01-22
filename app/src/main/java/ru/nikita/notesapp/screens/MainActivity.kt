package ru.nikita.notesapp.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.nikita.notesapp.APP
import ru.nikita.notesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}