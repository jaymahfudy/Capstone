package com.floriv.capstone.core.data.source.local.room

import androidx.room.*
import com.floriv.capstone.core.data.source.local.entity.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM game")
    fun getAllGames(): Flow<List<GameEntity>>

    @Query("SELECT * FROM game WHERE isFavorite = 1")
    fun getFavoriteGames(): Flow<List<GameEntity>>

    @Query("SELECT * from game WHERE id = :id")
    fun getGame(id: String): GameEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(listEntity: List<GameEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(gameEntity: GameEntity)

    @Update
    fun updateGame(gameEntity: GameEntity): Int

}