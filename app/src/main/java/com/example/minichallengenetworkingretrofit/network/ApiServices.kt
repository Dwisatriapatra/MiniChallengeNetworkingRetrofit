package com.example.minichallengenetworkingretrofit.network

import com.example.minichallengenetworkingretrofit.model.GetAllCountryResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("all")
    fun getAllCountry() : Call<List<GetAllCountryResponseItem>>
}