package com.example.android.notes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = [Notes::class], version =1, exportSchema = false)
public abstract class NotesRoomDatabase: RoomDatabase() {

    abstract fun getNotesDao(): NotesDao



    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: NotesRoomDatabase? = null

        fun getDatabase(context: Context): NotesRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this){

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesRoomDatabase::class.java,
                    "notes_database").build()

                INSTANCE = instance
                instance
            }
        }
    }

}