package com.example.android.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NotesViewModel(application: Application ): AndroidViewModel(application) {
     val allNotes:LiveData<List<Notes>>
     lateinit var repository:NotesRepository
     init {
         val dao = NotesRoomDatabase.getDatabase(application).getNotesDao()
         repository = NotesRepository(dao)
         allNotes = repository.allNotes
     }

    fun insert(note:Notes)= viewModelScope.launch {
        repository.insert(note)
    }

    fun delete(note: Notes)= viewModelScope.launch {
        repository.delete(note)
    }


}