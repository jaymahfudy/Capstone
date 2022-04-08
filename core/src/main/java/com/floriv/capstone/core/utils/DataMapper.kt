package com.floriv.capstone.core.utils

import com.floriv.capstone.core.data.source.local.entity.GameEntity
import com.floriv.capstone.core.data.source.remote.response.DetailGameResponse
import com.floriv.capstone.core.domain.model.Game

object DataMapper {
    fun mapResponsesToEntities(input: List<DetailGameResponse>): List<GameEntity> {
        val tourismList = ArrayList<GameEntity>()
        input.map {
            val tourism = GameEntity(
                id = it.id,
                nameOriginal = it.nameOriginal,
                rating = it.rating,
                ratingsCount = it.ratingsCount,
                released = it.released,
                descriptionRaw = it.descriptionRaw,
                backgroundImage = it.backgroundImage,
                name = it.name,
                description = it.description,
                website = it.website,
                backgroundImageAdditional = it.backgroundImageAdditional,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapResponseToEntity(input: DetailGameResponse): GameEntity {
        return GameEntity(
            id = input.id,
            nameOriginal = input.nameOriginal,
            rating = input.rating,
            ratingsCount = input.ratingsCount,
            released = input.released,
            descriptionRaw = input.descriptionRaw,
            backgroundImage = input.backgroundImage,
            name = input.name,
            description = input.description,
            website = input.website,
            backgroundImageAdditional = input.backgroundImageAdditional,
            isFavorite = false
        )
    }

    fun mapEntitiesToDomain(input: List<GameEntity>): List<Game> =
        input.map {
            Game(
                id = it.id,
                nameOriginal = it.nameOriginal,
                rating = it.rating,
                ratingsCount = it.ratingsCount,
                released = it.released,
                descriptionRaw = it.descriptionRaw,
                backgroundImage = it.backgroundImage,
                name = it.name,
                description = it.description,
                website = it.website,
                backgroundImageAdditional = it.backgroundImageAdditional,
                isFavorite = it.isFavorite
            )
        }

    fun mapEntityToDomain(input: GameEntity) = Game(
        id = input.id,
        nameOriginal = input.nameOriginal,
        rating = input.rating,
        ratingsCount = input.ratingsCount,
        released = input.released,
        descriptionRaw = input.descriptionRaw,
        backgroundImage = input.backgroundImage,
        name = input.name,
        description = input.description,
        website = input.website,
        backgroundImageAdditional = input.backgroundImageAdditional,
        isFavorite = input.isFavorite
    )

    fun mapDomainToEntity(input: Game) = GameEntity(
        id = input.id,
        nameOriginal = input.nameOriginal,
        rating = input.rating,
        ratingsCount = input.ratingsCount,
        released = input.released,
        descriptionRaw = input.descriptionRaw,
        backgroundImage = input.backgroundImage,
        name = input.name,
        description = input.description,
        website = input.website,
        backgroundImageAdditional = input.backgroundImageAdditional,
        isFavorite = input.isFavorite
    )
}