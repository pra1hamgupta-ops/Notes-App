package com.example.android.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NotesViewModel
    lateinit var adapter: NotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NotesViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {
            adapter.update(it)
        })
        adapter = NotesAdapter(this, viewModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }


    fun submit(view: View) {
        val note = Notes(edit.text.toString())
        viewModel.insert(note)
        edit.setText("")
        Toast.makeText(this,"${note.note} is added",Toast.LENGTH_SHORT).show()
    }
}
