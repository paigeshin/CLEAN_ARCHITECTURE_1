package com.example.core.usecase

import com.example.core.data.Note
import com.example.core.repository.NoteRepository

class GetWordCount(private val noteRepository: NoteRepository) {
    operator fun invoke(note: Note): Int = getCount(note.title) + getCount(note.content)

    private fun getCount(str: String) =
        str.split(" ", "\n")
            .filter {
                it.contains(Regex(".*[a-zA-Z].*"))
            }
            .count()

}