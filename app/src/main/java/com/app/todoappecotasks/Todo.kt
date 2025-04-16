package com.app.todoappecotasks

import java.time.Instant
import java.util.Date

data class Todo(
    var id: Int,
    var title: String,
    var createdAt: Date
)

fun getFakeTodo() : List<Todo>{
    return listOf<Todo>(
        Todo(1, "Fist todo", Date.from(Instant.now())),
        Todo(2, "Second todo", Date.from(Instant.now()))
    );
}