package ru.nikita.notesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.nikita.notesapp.databinding.ItemCardBinding
import ru.nikita.notesapp.model.Note

class NoteAdapter() : ListAdapter<Note, NoteViewHolder>(NoteDiffCallBack()) {

    /*var list = emptyList<Note>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = getItem(position)
        holder.bind(note)
    }
}


class NoteViewHolder(
    private val binding: ItemCardBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(note: Note) {
        binding.rcTitle.text = note.title
        binding.rcDescription.text = note.description
    }
}


class NoteDiffCallBack : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }
}

/*

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
*/

