package com.uvg.rickandmorty.presentation.mainFlow.location.list

import com.uvg.rickandmorty.data.model.Location

data class LocationListState(
    val isLoading: Boolean = true,
    val locations: List<Location> = emptyList(),
    val isError: Boolean = false
)
