package com.example.mynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), DelClicked {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addBtn : Button = findViewById(R.id.addBtn)
        val textBox : TextView = findViewById(R.id.editText)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NotesAdapter(this, this)
        recyclerView.adapter = adapter


        val viewModel = ViewModelProvider(this ,
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this , Observer { list->
            list?.let{
                adapter.update(list)
            }
        })

        addBtn.setOnClickListener {
            val text = textBox.text.toString()
            if (text.isNotEmpty()) {
                viewModel.insertNote(Note(text))
            }
            textBox.text = null
        }

    }

    override fun onDelClicked(note : Note){
        //viewModel.deleteNote(note)
    }
}