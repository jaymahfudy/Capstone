package com.floriv.capstone.core.domain.repository

import com.floriv.capstone.core.data.Resource
import com.floriv.capstone.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface IGameRepository {
    fun getAllGames(): Flow<Resource<List<Game>>>
    fun getFavoriteGames(): Flow<List<Game>>
    suspend fun insertGame(game: Game)
    suspend fun getGame(id: String): Resource<Game>
    fun updateGame(game: Game)
}