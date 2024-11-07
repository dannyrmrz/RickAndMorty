package com.uvg.rickandmorty.presentation.mainFlow.character.list

import com.uvg.rickandmorty.data.model.Character

data class CharacterListState(
    val isLoading: Boolean = true,
    val characters: List<Character> = emptyList(),
    val isError: Boolean = false
)
