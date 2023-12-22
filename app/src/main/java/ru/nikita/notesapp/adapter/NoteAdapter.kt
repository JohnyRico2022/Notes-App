package ru.nikita.notesapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.nikita.notesapp.R
import ru.nikita.notesapp.databinding.ItemCardBinding
import ru.nikita.notesapp.model.Note

class NoteAdapter() : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var listNote = listOf<Note>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val list = listNote[position]
        val title_ = holder.itemView.findViewById<TextView>(R.id.rc_title)
        val desc_ = holder.itemView.findViewById<TextView>(R.id.note_title)
        title_.text = list.title
        desc_.text = list.description
    }

    class NoteViewHolder(
        binding: ItemCardBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Note>) {
        listNote = list
        notifyDataSetChanged()
    }
}

