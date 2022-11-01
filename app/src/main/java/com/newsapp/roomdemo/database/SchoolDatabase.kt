package com.newsapp.roomdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.newsapp.roomdemo.dao.SchoolDao
import com.newsapp.roomdemo.entities.*

@Database( entities = [
        School :: class,
        Student :: class,
        Subject :: class,
        Director :: class,
        StudentSubjectCroRef :: class
    ],
    version = 1,
    exportSchema = false
)

abstract class SchoolDatabase : RoomDatabase(){
    abstract val schoolDao : SchoolDao
    companion object{
        @Volatile
        private var instance : SchoolDatabase? =null

        fun getDatabaseInstance(context : Context) : SchoolDatabase{
            synchronized(this){
                    return instance ?: Room.databaseBuilder(
                        context.applicationContext,
                        SchoolDatabase::class.java,
                        "school_db.db"
                    ).build().also {
                        instance = it
                    }
            }

        }
    }
}