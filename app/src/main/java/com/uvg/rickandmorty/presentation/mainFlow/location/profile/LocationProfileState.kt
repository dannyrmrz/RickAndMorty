package com.uvg.rickandmorty.presentation.mainFlow.location.profile

import com.uvg.rickandmorty.data.model.Location

data class LocationProfileState(
    val data: Location? = null,
    val isLoading: Boolean = true
)
