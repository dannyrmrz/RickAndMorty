package com.example.rickandmorty.domain.network

import com.example.rickandmorty.Datos.network.dto.CharacterDto
import com.example.rickandmorty.Datos.network.dto.LocationDto

interface RickApi {
    suspend fun getAllCharacters(): List<CharacterDto>
    suspend fun getAllLocations(): List<LocationDto>
}