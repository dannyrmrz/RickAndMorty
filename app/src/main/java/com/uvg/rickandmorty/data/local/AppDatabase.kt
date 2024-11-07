package com.uvg.rickandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uvg.rickandmorty.data.local.dao.CharacterDao
import com.uvg.rickandmorty.data.local.dao.LocationDao
import com.uvg.rickandmorty.data.local.entity.CharacterEntity
import com.uvg.rickandmorty.data.local.entity.LocationEntity

@Database(
    entities = [
        CharacterEntity::class,
        LocationEntity::class
    ],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun locationDao(): LocationDao
}