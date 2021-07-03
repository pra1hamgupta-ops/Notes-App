package com.example.android.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val context: Context, private val viewModel: NotesViewModel): RecyclerView.Adapter<NotesViewHolder>(){
    var dataset: List<Notes> = arrayListOf(Notes(""))

    fun update(data:List<Notes>){
        dataset = data
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.specific_notes, parent,false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.note.text = dataset[position].note
        holder.delete.setOnClickListener {
            viewModel.delete(dataset[position])
            Toast.makeText(context,"${dataset[position].note} is deleted",Toast.LENGTH_SHORT).show()
            }
        }

    override fun getItemCount(): Int {
        return dataset.size
    }


}

class NotesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val note:TextView = itemView.findViewById(R.id.noteText)
    val delete:ImageView = itemView.findViewById(R.id.delete)
}