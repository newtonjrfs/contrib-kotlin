package com.example.contribmontano.network

import com.example.contribmontano.model.Repository
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface GithubService {
    @GET("users/diego3g/repos")
    suspend fun getRepos(): Response<List<Repository>>
}