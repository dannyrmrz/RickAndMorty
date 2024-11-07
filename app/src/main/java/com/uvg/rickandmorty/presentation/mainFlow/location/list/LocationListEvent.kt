package com.uvg.rickandmorty.presentation.mainFlow.location.list

sealed interface LocationListEvent {
    data object ForceError: LocationListEvent
    data object RetryClick: LocationListEvent
}