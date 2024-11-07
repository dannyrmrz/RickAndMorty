package com.uvg.rickandmorty.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.uvg.rickandmorty.data.local.entity.LocationEntity

@Dao
interface LocationDao {
    @Insert
    suspend fun insertAll(locations: List<LocationEntity>)

    @Query("SELECT * FROM LocationEntity")
    suspend fun getAllLocations(): List<LocationEntity>

    @Query("SELECT * FROM LocationEntity WHERE id = :id")
    suspend fun getLocationById(id: Int): LocationEntity
}