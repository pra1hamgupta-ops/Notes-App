package com.example.android.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "NotesTable")
data class Notes(@ColumnInfo(name = "notes") val note:String) {
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}