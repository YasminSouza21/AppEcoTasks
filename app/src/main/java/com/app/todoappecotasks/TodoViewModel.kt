package com.app.todoappecotasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    private var _todolist = MutableLiveData<List<Todo>>()
    val todoList : LiveData<List<Todo>> = _todolist

    fun getAllTodo() {
        _todolist.value = TodoManager.getAllTodo()
    }

    fun addTodo(title : String){
        TodoManager.addTodo(title)
        getAllTodo()
    }

    fun deleteTodo(id: Int){
        TodoManager.deleteTodo(id)
        getAllTodo()
    }
}