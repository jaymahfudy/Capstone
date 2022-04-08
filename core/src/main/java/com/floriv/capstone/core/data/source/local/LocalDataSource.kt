package com.floriv.capstone.core.data.source.local

import com.floriv.capstone.core.data.source.local.entity.GameEntity
import com.floriv.capstone.core.data.source.local.room.GameDao

class LocalDataSource(private val gameDao: GameDao) {
    fun getGames() = gameDao.getAllGames()
    fun getGame(id: String) = gameDao.getGame(id)
    fun getFavoriteGames() = gameDao.getFavoriteGames()
    suspend fun insertGames(games: List<GameEntity>) = gameDao.insertGames(games)
    suspend fun insertGame(gameEntity: GameEntity) = gameDao.insertGame(gameEntity)
    fun updateGame(gameEntity: GameEntity) = gameDao.updateGame(gameEntity)
}