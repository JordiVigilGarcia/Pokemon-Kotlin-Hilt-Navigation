package com.example.pokeapp.ui.destinations.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokeapp.commons.BaseViewModel
import com.example.pokeapp.data.di.AppModule
import com.example.pokeapp.data.model.Pokemon
import com.example.pokeapp.data.remote.PokemonAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class ViewModelCharacters @Inject constructor(): BaseViewModel() {

    private val _rickMortyResults = MutableLiveData<ArrayList<Pokemon>>()
    val rickMortyResults: LiveData<ArrayList<Pokemon>>
        get() = _rickMortyResults

    val resultAPI = arrayListOf<Pokemon>()

    private var viewModel = Job()

    private val coroutine = CoroutineScope(viewModel + Dispatchers.Main)

    init {
        coroutine.launch {
            apiResults()
        }
    }

    //Retrieve API results

    private suspend fun apiResults() {
        _isLoading.value = true
        try {
            val response = AppModule.providePokemonApi().getPokemons()
            if (response.isSuccessful) {
                val dataRickAndMorty = response.body()
                if (dataRickAndMorty!!.results!!.isNotEmpty()) {
                    resultAPI.addAll(dataRickAndMorty.results)
                    _rickMortyResults.value = resultAPI
                }
                _isLoading.postValue(false)
            } else {
                _isLoading.postValue(true)
            }

        } catch (e: SocketTimeoutException) {
            _rickMortyResults.value = ArrayList()
        } catch (e: Exception) {
            _rickMortyResults.value = ArrayList()
        } catch (e: UnknownHostException) {
            _rickMortyResults.value = ArrayList()
        }
    }
}