package com.example.rickandmorty.Datos.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class LocationListDto (
    val results: List<LocationDto>
)