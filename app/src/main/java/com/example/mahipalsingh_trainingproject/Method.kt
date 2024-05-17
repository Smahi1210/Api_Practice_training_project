package com.example.mahipalsingh_trainingproject

import retrofit2.Call
import retrofit2.http.GET

interface Methods {
    @GET("api/users?page=1")
    fun getAllData(): Call<Model>
}
