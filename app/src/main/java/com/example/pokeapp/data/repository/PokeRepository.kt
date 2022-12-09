package com.example.pokeapp.data.repository

import androidx.lifecycle.LiveData
import com.example.pokeapp.commons.BaseRepository
import com.example.pokeapp.data.remote.PokemonAPI
import com.example.pokeapp.data.room.User
import com.example.pokeapp.data.room.UserDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokeRepository @Inject constructor(private val userDao: UserDao) : BaseRepository() {

    val readAllData: User = userDao.getUserById(0)

    suspend fun addUser(user: User){
        userDao.createUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

}