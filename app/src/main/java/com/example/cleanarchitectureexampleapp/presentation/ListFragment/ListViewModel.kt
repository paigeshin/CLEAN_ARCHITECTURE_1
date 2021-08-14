package com.example.cleanarchitectureexampleapp.presentation.ListFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitectureexampleapp.framework.RoomNoteDataSource
import com.example.cleanarchitectureexampleapp.framework.Usecases
import com.example.cleanarchitectureexampleapp.framework.di.ApplicationModule
import com.example.cleanarchitectureexampleapp.framework.di.DaggerViewModelComponent
import com.example.core.data.Note
import com.example.core.repository.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel(application: Application): AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val repository = NoteRepository(RoomNoteDataSource(application))

    @Inject
    lateinit var useCases: Usecases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(application))
            .build()
            .inject(this)
    }

    val notes = MutableLiveData<List<Note>>()

    fun getNotes() {
        coroutineScope.launch {
            val noteList = useCases.getAllNotes()
            noteList.forEach{it.wordCount = useCases.getWordCount.invoke(it)}
            notes.postValue(noteList)
        }
    }

}