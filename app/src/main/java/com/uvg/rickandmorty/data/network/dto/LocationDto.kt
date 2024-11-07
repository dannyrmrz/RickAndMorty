package com.example.rickandmorty.Datos.network.dto

import com.uvg.rickandmorty.data.local.entity.LocationEntity
import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
)

fun LocationDto.mapToLocationModel(): LocationEntity {
    return LocationEntity(
        id = id,
        name = name,
        type = type,
        dimension = dimension
    )

}