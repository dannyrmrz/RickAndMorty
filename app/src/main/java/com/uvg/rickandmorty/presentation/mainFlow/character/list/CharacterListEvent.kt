package com.uvg.rickandmorty.presentation.mainFlow.character.list

sealed interface CharacterListEvent {
    data object ForceError: CharacterListEvent
    data object RetryClick: CharacterListEvent
}