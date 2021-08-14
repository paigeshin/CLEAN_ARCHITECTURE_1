package com.example.cleanarchitectureexampleapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.cleanarchitectureexampleapp.R
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addNote.setOnClickListener {
            goToNoteDetails()
        }
    }

    // setup navigation with our defined argument
    private fun goToNoteDetails(id: Long = 0L) {
        val action = ListFragmentDirections.actionGoToNote()
        Navigation.findNavController(notesListView).navigate(action)
    }

}