package com.app.todoappecotasks.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.todoappecotasks.Todo
import com.app.todoappecotasks.User

@Database(entities = [Todo::class, User::class], version = 2)
@TypeConverters(Converters::class)
abstract class TodoDatabase : RoomDatabase() {
    companion object{
        const val NAME = "Todo_DB"
    }

    abstract fun getTodoDao() : TodoDao
    abstract fun userDao() : UserDao
}