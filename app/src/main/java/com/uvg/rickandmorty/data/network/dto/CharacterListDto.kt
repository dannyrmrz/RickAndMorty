package com.example.rickandmorty.Datos.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharacterListDto (
    val results: List<CharacterDto>
)