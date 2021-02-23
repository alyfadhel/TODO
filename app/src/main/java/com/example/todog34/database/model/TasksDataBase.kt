package com.example.todog34.database.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todog34.database.dao.TasksDao

@Database(entities = [Tasks::class],version = 1, exportSchema = false)
abstract class TasksDataBase:RoomDatabase() {
    abstract fun taskDao():TasksDao

    companion object{
        private var database:TasksDataBase?=null
        private val DATABASE_NAME = "tasks-db"
        fun getInstance(context: Context):TasksDataBase{
            if (database==null){
                database = Room.databaseBuilder(context,TasksDataBase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
            return database!!
        }
    }
}