package com.example.homework2_andtoid3.data.remote

import com.example.homework2_andtoid3.data.remote.apiservices.CharacterAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideCharacterAPIService(): CharacterAPI {
        return retrofitClient.create(CharacterAPI::class.java)
    }
}