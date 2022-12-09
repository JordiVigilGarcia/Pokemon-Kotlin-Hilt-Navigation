package com.example.pokeapp.data.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Query("select * from user_table where id= :id")
    fun getUserById(id: Int) : User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)
}