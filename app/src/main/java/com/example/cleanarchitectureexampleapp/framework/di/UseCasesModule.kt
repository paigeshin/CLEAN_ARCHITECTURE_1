package com.example.cleanarchitectureexampleapp.framework.di

import com.example.cleanarchitectureexampleapp.framework.Usecases
import com.example.core.repository.NoteRepository
import com.example.core.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun getUsecases(repository: NoteRepository) = Usecases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
        GetWordCount(repository)
    )

}