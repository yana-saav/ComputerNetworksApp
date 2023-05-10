package com.example.networks7

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @Headers("Content-Type: application/json")
    @GET("/api/characters/{characters}")
    suspend fun getData(@Path("characters") characters: Int): Response<Data.DataCharacters>
}