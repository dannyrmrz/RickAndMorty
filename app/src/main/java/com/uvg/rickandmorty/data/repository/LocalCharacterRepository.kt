package com.uvg.rickandmorty.data.repository

import com.uvg.rickandmorty.data.local.dao.CharacterDao
import com.uvg.rickandmorty.data.local.entity.mapToEntity
import com.uvg.rickandmorty.data.local.entity.mapToModel
import com.uvg.rickandmorty.data.model.Character
import com.uvg.rickandmorty.data.source.CharacterDb
import com.uvg.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.yield
import kotlin.coroutines.coroutineContext

class LocalCharacterRepository(
    private val characterDao: CharacterDao
): CharacterRepository {

    override suspend fun initialSync(): Boolean {
        return try {
            if (characterDao.getAllCharacters().isEmpty()) {
                val characterDb = CharacterDb()
                val charactersToInsert = characterDb.getAllCharacters().map { it.mapToEntity() }
                characterDao.insertAll(charactersToInsert)
            }
            return true
        } catch (e: Exception) {
            coroutineContext.ensureActive()
            println(e)
            false
        }
    }

    override suspend fun getCharacters(): List<Character> {
        delay(2000L)
        return characterDao.getAllCharacters().map { it.mapToModel() }
    }

    override suspend fun getCharacterById(id: Int): Character {
        delay(2000L)
        return characterDao.getCharacterById(id).mapToModel()
    }
}