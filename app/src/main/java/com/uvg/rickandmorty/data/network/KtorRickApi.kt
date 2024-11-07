package com.example.rickandmorty.Datos.network

import com.example.rickandmorty.Datos.network.dto.CharacterDto
import com.example.rickandmorty.Datos.network.dto.CharacterListDto
import com.example.rickandmorty.Datos.network.dto.LocationDto
import com.example.rickandmorty.Datos.network.dto.LocationListDto
import com.example.rickandmorty.domain.network.RickApi
import io.ktor.client.call.body
import io.ktor.client.request.get

class KtorRickApi : RickApi {
    private val client = HttpClientFactory.create()

    override suspend fun getAllCharacters(): List<CharacterDto> {
        val response = client.get("https://rickandmortyapi.com/api/character")
        val charactersDTO = response.body<CharacterListDto>()
        return charactersDTO.results
    }


    override suspend fun getAllLocations(): List<LocationDto> {
        val response = client.get("https://rickandmortyapi.com/api/location")
        val locationsDTO = response.body<LocationListDto>()
        return locationsDTO.results
    }


}
