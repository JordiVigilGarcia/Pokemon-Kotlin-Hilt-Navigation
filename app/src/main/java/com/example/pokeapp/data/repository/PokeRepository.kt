package com.example.pokeapp.data.repository

import com.example.pokeapp.commons.BaseRepository
import com.example.pokeapp.data.remote.PokemonAPI
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokeRepository @Inject constructor(private val apiPokemon: PokemonAPI) : BaseRepository() {




}