package com.example.homework2_andtoid3.models

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse<T>(
    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val result: List<T>
)
