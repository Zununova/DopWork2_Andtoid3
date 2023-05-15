package com.example.homework2_andtoid3.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework2_andtoid3.App
import com.example.homework2_andtoid3.data.remote.apiservices.CharacterAPI
import com.example.homework2_andtoid3.models.CharacterModel
import com.example.homework2_andtoid3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class CharacterAPIViewModel : ViewModel() {

    fun fetchCharacters(): MutableLiveData<RickAndMortyResponse<CharacterModel>?> {

        val data = MutableLiveData<RickAndMortyResponse<CharacterModel>?>()

        App.characterAPI?.fetchCharacters()
            ?.enqueue(object : retrofit2.Callback<RickAndMortyResponse<CharacterModel>> {

                override fun onFailure(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    t: Throwable
                ) {
                    data.postValue(null)
                }

                override fun onResponse(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    response: Response<RickAndMortyResponse<CharacterModel>>
                ) {
                    data.value = response.body()
                }
            })
        return data
    }
}