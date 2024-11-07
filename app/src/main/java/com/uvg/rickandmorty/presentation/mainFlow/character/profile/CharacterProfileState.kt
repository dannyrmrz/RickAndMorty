package com.uvg.rickandmorty.presentation.mainFlow.character.profile

import com.uvg.rickandmorty.data.model.Character

data class CharacterProfileState(
    val data: Character? = null,
    val isLoading: Boolean = true
)
