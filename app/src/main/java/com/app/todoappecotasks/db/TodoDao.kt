package com.app.todoappecotasks.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.todoappecotasks.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM TODO")
    fun getAllTodo() : LiveData<List<Todo>>

    @Insert
    fun addTodo(todo : Todo)

    @Query("DELETE FROM Todo WHERE id = :id")
    fun deleteTodo(id : Int)
}