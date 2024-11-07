package com.uvg.rickandmorty.presentation.mainFlow.location.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.toRoute
import com.uvg.rickandmorty.data.repository.LocalLocationRepository
import com.uvg.rickandmorty.di.AppDependencies
import com.uvg.rickandmorty.domain.repository.LocationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
class LocationProfileViewModel(
    private val locationRepository: LocationRepository,
    savedStateHandle: SavedStateHandle,
): ViewModel() {
    private val locationProfile = savedStateHandle.toRoute<LocationProfileDestination>()
    private val _uiState: MutableStateFlow<LocationProfileState> = MutableStateFlow(LocationProfileState())
    val uiState = _uiState.asStateFlow()

    init {
        getLocationData()
    }

    private fun getLocationData() {
        viewModelScope.launch {
            _uiState.update { state ->
                state.copy(isLoading = true)
            }

            val location = locationRepository.getLocationById(locationProfile.locationId)

            _uiState.update { state ->
                state.copy(
                    data = location,
                    isLoading = false
                )
            }

        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val savedStateHandle = createSavedStateHandle()
                val context = checkNotNull(this[APPLICATION_KEY])
                val appDatabase = AppDependencies.provideDatabase(context)
                LocationProfileViewModel(
                    locationRepository = LocalLocationRepository(
                        locationDao = appDatabase.locationDao()
                    ),
                    savedStateHandle = savedStateHandle
                )
            }
        }
    }
}

