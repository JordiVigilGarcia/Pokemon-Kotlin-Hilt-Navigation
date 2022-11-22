package com.example.pokeapp.data.remote

import com.example.pokeapp.data.model.PokeModel
import retrofit2.Response
import retrofit2.http.GET

interface PokemonAPI {
    @GET("pokemon/")
    suspend fun getPokemons(): Response<PokeModel>
}