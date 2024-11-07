package com.uvg.rickandmorty.presentation.mainFlow.character.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.uvg.rickandmorty.data.repository.LocalCharacterRepository
import com.uvg.rickandmorty.di.AppDependencies
import com.uvg.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    private var getDataJob: Job? = null
    private val _state = MutableStateFlow(CharacterListState())
    val state = _state.asStateFlow()

    init {
        getCharacters()
    }

    fun onEvent(event: CharacterListEvent) {
        when (event) {
            CharacterListEvent.ForceError -> {
                getDataJob?.cancel()
                _state.update { state ->
                    state.copy(
                        isLoading = false,
                        isError = true
                    )
                }
            }
            CharacterListEvent.RetryClick -> {
                getCharacters()
            }
        }
    }

    private fun getCharacters() {
        getDataJob = viewModelScope.launch {
            _state.update { state ->
                state.copy(
                    isLoading = true,
                    isError = false
                )
            }

            val characters = characterRepository.getCharacters()

            _state.update { state ->
                state.copy(
                    isLoading = false,
                    characters = characters
                )
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val context = checkNotNull(this[APPLICATION_KEY])
                val appDatabase = AppDependencies.provideDatabase(context)
                CharacterListViewModel(
                    characterRepository = LocalCharacterRepository(
                        characterDao = appDatabase.characterDao()
                    )
                )
            }
        }
    }
}