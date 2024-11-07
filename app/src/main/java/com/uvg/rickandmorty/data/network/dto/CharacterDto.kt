package com.example.rickandmorty.Datos.network.dto

import com.uvg.rickandmorty.data.local.entity.CharacterEntity
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginDto,
    val location: CharacterListDto,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)

fun CharacterDto.mapToCharacterModel(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        image = image
    )
}