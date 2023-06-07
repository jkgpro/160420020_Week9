package com.example.todoappkpc.model

import android.icu.text.CaseMap.Title
import androidx.room.*

@Dao
interface TodoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg todo:Todo)

    @Query("SELECT * FROM todo ORDER BY priority DESC")
    fun selectAllTodo(): List<Todo>

    @Query("SELECT * FROM todo WHERE uuid= :id")
    fun selectTodo(id:Int): Todo

    @Query("UPDATE todo SET title=:title, notes=:notes, priority=:priority WHERE uuid=:id")
    fun update(title:String, notes:String, priority:Int, id:Int)

    @Query("UPDATE todo SET is_done=:is_done WHERE uuid=:id")
    fun updateChecked(is_done:Int, id:Int)

    @Query("select * from todo where is_done = 0")
    fun checkedNull(): List<Todo>

    @Delete
    fun deleteTodo(todo:Todo)



}