package com.uvg.rickandmorty.domain.repository

import com.uvg.rickandmorty.data.model.Character

interface CharacterRepository {
    suspend fun initialSync(): Boolean
    suspend fun getCharacters(): List<Character>
    suspend fun getCharacterById(id: Int): Character
}