package com.example.rickandmorty.Datos.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class OriginDto(
    val name: String,
    val url: String
)