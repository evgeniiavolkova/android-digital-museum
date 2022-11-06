package com.example.digitalmuseum.ui.screens

sealed class ArtHubUiState<out T> {
    class Start() : ArtHubUiState<Nothing>()
    class Success<T>(var data: T) : ArtHubUiState<T>()
    class Error(var error: Int) : ArtHubUiState<Nothing>()
}
