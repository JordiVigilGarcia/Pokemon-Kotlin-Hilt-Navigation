package com.example.pokeapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    val name: String,
    val url: String,
    val types: List<PokemonType>
) : Parcelable