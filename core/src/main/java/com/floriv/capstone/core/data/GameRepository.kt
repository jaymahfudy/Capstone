package com.floriv.capstone.core.data

import com.floriv.capstone.core.data.source.local.LocalDataSource
import com.floriv.capstone.core.data.source.remote.RemoteDataSource
import com.floriv.capstone.core.data.source.remote.network.ApiResponse
import com.floriv.capstone.core.data.source.remote.response.DetailGameResponse
import com.floriv.capstone.core.domain.model.Game
import com.floriv.capstone.core.domain.repository.IGameRepository
import com.floriv.capstone.core.utils.AppExecutors
import com.floriv.capstone.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IGameRepository {
    override fun getAllGames(): Flow<Resource<List<Game>>> =
        object : NetworkBoundResourceList<List<Game>, List<DetailGameResponse>>() {
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getGames().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Game>?): Boolean = data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<DetailGameResponse>>> =
                remoteDataSource.getAllGames()

            override suspend fun saveCallResult(data: List<DetailGameResponse>) {
                val gameList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertGames(gameList)
            }

        }.asFlow()

    override suspend fun getGame(id: String): Resource<Game> {
        val localData = localDataSource.getGame(id)
        localData?.description
        if (localData?.descriptionRaw != null) {
            return Resource.Success(DataMapper.mapEntityToDomain(localData))
        } else {
            return when (val apiResponse = remoteDataSource.getGame(id)) {
                is ApiResponse.Success -> {
                    val entity = DataMapper.mapResponseToEntity(apiResponse.data)
                    localDataSource.insertGame(entity)
                    Resource.Success(DataMapper.mapEntityToDomain(entity))
                }
                is ApiResponse.Error -> {
                    Resource.Error(apiResponse.errorMessage)
                }
                is ApiResponse.Empty -> {
                    Resource.Empty()
                }
            }
        }
    }

    override fun getFavoriteGames(): Flow<List<Game>> {
        return localDataSource.getFavoriteGames().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override suspend fun insertGame(game: Game) {
        val gameEntity = DataMapper.mapDomainToEntity(game)
        localDataSource.insertGame(gameEntity)
    }

    override fun updateGame(game: Game) {
        val gameEntity = DataMapper.mapDomainToEntity(game)
        appExecutors.diskIO().execute { localDataSource.updateGame(gameEntity) }
    }
}