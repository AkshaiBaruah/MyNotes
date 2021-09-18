package com.example.mynotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val context : Context, private val listener : DelClicked) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    val items = ArrayList<Note>()

    inner class NoteViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val textView = view.findViewById<TextView>(R.id.noteText)
        val deleteBtn = view.findViewById<ImageView>(R.id.deleteBtn)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.note_item , parent , false)
        val holder = NoteViewHolder(view)
        holder.deleteBtn.setOnClickListener {
            listener.onDelClicked(items[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = items[position]
        holder.textView.text = currentNote.text
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun update( updatedItems : List<Note>){

        items.clear()
        items.addAll(updatedItems)

        notifyDataSetChanged()
    }
}

interface DelClicked {
    fun onDelClicked(note : Note)
}