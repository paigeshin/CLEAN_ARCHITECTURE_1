package com.example.cleanarchitectureexampleapp.framework

import com.example.core.usecase.*

data class Usecases(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote,
    val getWordCount: GetWordCount
)