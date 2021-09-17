package com.example.mynotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes : LiveData<List<Note>>

    init{
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        val repository = NoteRepository(noteDao)
        allNotes = repository.allNotes
    }
}