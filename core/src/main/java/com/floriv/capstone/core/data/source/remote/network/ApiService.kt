package com.floriv.capstone.core.data.source.remote.network

import com.floriv.capstone.core.data.source.remote.response.DetailGameResponse
import com.floriv.capstone.core.data.source.remote.response.ListGameResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    suspend fun getList(@Query("key") key: String): ListGameResponse

    @GET("games/{id}")
    suspend fun getDetail(@Path("id") id: String, @Query("key") key: String): DetailGameResponse
}
