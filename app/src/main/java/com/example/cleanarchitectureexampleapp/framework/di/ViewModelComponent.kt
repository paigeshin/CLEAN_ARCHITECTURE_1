package com.example.cleanarchitectureexampleapp.framework.di

import com.example.cleanarchitectureexampleapp.presentation.ListFragment.ListViewModel
import com.example.cleanarchitectureexampleapp.presentation.NoteFragment.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}