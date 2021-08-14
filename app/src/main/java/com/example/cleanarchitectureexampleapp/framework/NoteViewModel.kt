package com.example.cleanarchitectureexampleapp.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.core.data.Note
import com.example.core.repository.NoteRepository
import com.example.core.usecase.AddNote
import com.example.core.usecase.GetAllNotes
import com.example.core.usecase.GetNote
import com.example.core.usecase.RemoveNote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class NoteViewModel(application: Application): AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val repository = NoteRepository(RoomNoteDataSource(application))

    val useCases = Usecases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
    )

    val saved = MutableLiveData<Boolean>()

    fun saveNote(note: Note) {

    }

}