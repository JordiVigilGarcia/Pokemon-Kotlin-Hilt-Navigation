package com.example.pokeapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize data class PokemonType(val type: TypeName) : Parcelable

@Parcelize data class TypeName(val name: String) : Parcelable

