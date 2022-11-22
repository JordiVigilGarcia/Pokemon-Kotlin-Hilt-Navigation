package com.example.pokeapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import retrofit2.Response

@Parcelize
data class PokeModel(
    val results: ArrayList<Pokemon>
) : Parcelable