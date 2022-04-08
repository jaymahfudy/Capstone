package com.floriv.capstone.core.domain.usecase

import com.floriv.capstone.core.data.Resource
import com.floriv.capstone.core.domain.model.Game
import com.floriv.capstone.core.domain.repository.IGameRepository
import kotlinx.coroutines.flow.Flow

class GameInteractor(private val gameRepository: IGameRepository) : GameUseCase {
    override fun getAllGames(): Flow<Resource<List<Game>>> = gameRepository.getAllGames()

    override fun getFavoriteGames(): Flow<List<Game>> = gameRepository.getFavoriteGames()

    override suspend fun insertGame(game: Game) = gameRepository.insertGame(game)

    override suspend fun getGame(id: String): Resource<Game> = gameRepository.getGame(id)

    override fun updateGame(game: Game) = gameRepository.updateGame(game)

}