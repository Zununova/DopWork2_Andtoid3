package com.example.homework2_andtoid3.data.remote.apiservices

import com.example.homework2_andtoid3.models.CharacterModel
import com.example.homework2_andtoid3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface CharacterAPI {

    @GET("api/character")
    fun fetchCharacters(): Call<RickAndMortyResponse<CharacterModel>>
}