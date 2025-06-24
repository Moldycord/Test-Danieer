package com.example.myapplication.presentation.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.R
import com.example.myapplication.domain.model.Character
import com.example.myapplication.presentation.views.ErrorDialog

@Composable
fun AllCharacters(
    viewModel: AllCharactersViewModel = hiltViewModel()
) {

    val state by viewModel.state.observeAsState()
    val spacing16Dp = dimensionResource(R.dimen.spacing_large)
    val spacing8dp = dimensionResource(R.dimen.spacing_medium)

    viewModel.getAllCharacters()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing16Dp)
    ) {
        Spacer(modifier = Modifier.height(spacing8dp))

        when (state) {
            is CharactersViewModelState.Characters -> {
                LazyColumn {
                    itemsIndexed((state as CharactersViewModelState.Characters).data) { _, character ->
                        CharacterItem(character)
                    }
                }
            }

            is CharactersViewModelState.Error -> {
                ErrorDialog(
                    message = (state as CharactersViewModelState.Error).error,
                    onRetry = {
                        viewModel.getAllCharacters()
                    },
                    onDismiss = {
                        viewModel.getAllCharacters()
                    }
                )
            }

            null -> {
                CircularProgressIndicator()
            }
        }

    }

}

@Composable
fun CharacterItem(character: Character) {
    val spacing8dp = dimensionResource(R.dimen.spacing_medium)
    val spacing16Dp = dimensionResource(R.dimen.spacing_large)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = spacing8dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(spacing16Dp))
        Column {
            Text(text = character.name, fontWeight = FontWeight.Bold)
            Text(text = stringResource(R.string.character_gender_label, character.gender))
        }
    }
}
