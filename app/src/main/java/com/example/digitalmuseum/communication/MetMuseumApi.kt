package com.example.digitalmuseum.communication

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface MetMuseumApi {
    @Headers("Content-Type: application/json")
    @GET("objects")
    suspend fun getObjects(): Response<List<com.example.digitalmuseum.models.Object>>

    @Headers("Content-Type: application/json")
    @GET("object/{objectID}")
    suspend fun getObject(@Path("objectID") objectID: Int): Response<com.example.digitalmuseum.models.Object>
}