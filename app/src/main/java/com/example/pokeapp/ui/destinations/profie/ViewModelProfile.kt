package com.example.pokeapp.ui.destinations.profie

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pokeapp.commons.BaseViewModel
import com.example.pokeapp.data.repository.PokeRepository
import com.example.pokeapp.data.room.Database
import com.example.pokeapp.data.room.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelProfile @Inject constructor(application: Application): BaseViewModel() {

    private val repository: PokeRepository
    val readAllData: User

    init{
        val userDao = Database.getDatabase(application).userDao()
        repository = PokeRepository(userDao)
        readAllData = repository.readAllData
    }

    fun createUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteUser(user)
        }
    }
}