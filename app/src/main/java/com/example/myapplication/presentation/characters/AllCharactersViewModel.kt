package com.example.myapplication.presentation.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.Character
import com.example.myapplication.domain.usecase.GetAllCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllCharactersViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {
    private val _state = MutableLiveData<CharactersViewModelState>()
    val state: LiveData<CharactersViewModelState> get() = _state

    fun getAllCharacters() {
        viewModelScope.launch {
            getAllCharactersUseCase()
                .collect {
                    if (it.isSuccess) {
                        val data = it.getOrNull()
                        data?.let { response ->
                            _state.value = CharactersViewModelState.Characters(response.characters)
                        }
                    } else {
                        _state.value = CharactersViewModelState.Error("Unknown Error, try later")
                    }
                }
        }
    }


}

sealed class CharactersViewModelState {
    data class Characters(val data: List<Character>) : CharactersViewModelState()
    data class Error(val error: String) : CharactersViewModelState()
}