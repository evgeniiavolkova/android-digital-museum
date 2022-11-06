package com.example.digitalmuseum.ui.screens

import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.digitalmuseum.models.ScreenState
import com.example.digitalmuseum.navigations.INavigationRouter
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ArtHubScreen(navigation: INavigationRouter,
                 viewModel: ArtHubViewModel = getViewModel()
){
    val screenState: MutableState<ScreenState<List<com.example.digitalmuseum.models.Object>>> = rememberSaveable {
        mutableStateOf(ScreenState.Loading())
    }

    viewModel.artHubUiState.value.let {
        when(it){
            is ArtHubUiState.Error -> {
                screenState.value = ScreenState.Error(it.error)
            }
            is ArtHubUiState.Start -> {
                LaunchedEffect(it){
                    viewModel.loadObjects()
                }

            }
            is ArtHubUiState.Success -> {
                screenState.value = ScreenState.DataLoaded(it.data)
            }
        }
    }

    Text("Hello this is Art Hub")

}