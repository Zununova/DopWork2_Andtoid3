package com.example.homework2_andtoid3

import android.app.Application
import com.example.homework2_andtoid3.data.remote.RetrofitClient
import com.example.homework2_andtoid3.data.remote.apiservices.CharacterAPI

class App : Application() {

    companion object {
        var characterAPI: CharacterAPI? = null
    }

    override fun onCreate() {
        super.onCreate()

        val retrofitClient = RetrofitClient()
        characterAPI = retrofitClient.provideCharacterAPIService()
    }
}