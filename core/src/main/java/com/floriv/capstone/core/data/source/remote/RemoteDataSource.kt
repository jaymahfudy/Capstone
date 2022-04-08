package com.floriv.capstone.core.data.source.remote

import android.util.Log
import com.floriv.capstone.core.data.source.remote.network.ApiResponse
import com.floriv.capstone.core.data.source.remote.network.ApiService
import com.floriv.capstone.core.data.source.remote.response.DetailGameResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {
    private val apiKey = "6b7c7f63e87c40bf95928f560435e000"
    suspend fun getAllGames(): Flow<ApiResponse<List<DetailGameResponse>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getList(apiKey)
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getGame(id: String): ApiResponse<DetailGameResponse> {
        return try {
            val data = apiService.getDetail(id, apiKey)
            ApiResponse.Success(data)
        } catch (e: Exception) {
            Log.d("RemoteDataSource", e.toString())
            ApiResponse.Empty
        }
    }
}

