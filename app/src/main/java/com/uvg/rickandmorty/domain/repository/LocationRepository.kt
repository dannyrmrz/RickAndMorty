package com.uvg.rickandmorty.domain.repository

import com.uvg.rickandmorty.data.model.Location

interface LocationRepository {
    suspend fun initialSync(): Boolean
    suspend fun getLocations(): List<Location>
    suspend fun getLocationById(id: Int): Location
}