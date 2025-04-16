package com.app.todoappecotasks.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.todoappecotasks.User

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(user : User)

    @Query("SELECT * FROM User WHERE email = :email AND senha = :senha LIMIT 1")
    suspend fun authenticate(email: String, senha: String): User?
}