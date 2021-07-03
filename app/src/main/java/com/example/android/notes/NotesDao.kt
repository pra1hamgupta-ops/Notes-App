package com.example.android.notes

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (note:Notes)

    @Delete
    suspend fun delete(note:Notes)

    @Query("SELECT * FROM NotesTable ORDER BY notes ASC")
    fun getAllNotes():LiveData<List<Notes>>

}