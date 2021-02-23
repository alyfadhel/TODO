package com.example.todog34.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todog34.database.model.Tasks

@Dao
interface TasksDao {
    @Insert
    fun addTasks(tasks: Tasks)

    @Update
    fun updateTasks(tasks: Tasks)


    @Query("select * from Tasks")
    fun getAllTasks():List<Tasks>

    @Query("select * from Tasks where title like :word or description like :word")
    fun searchForTasks(word: String):List<Tasks>
}