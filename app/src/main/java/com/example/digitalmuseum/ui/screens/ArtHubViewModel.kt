package com.example.digitalmuseum.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.digitalmuseum.R
import com.example.digitalmuseum.architecture.BaseViewModel
import com.example.digitalmuseum.architecture.CommunicationResult
import com.example.digitalmuseum.communication.MetMuseumRemoteRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArtHubViewModel(private val metMuseumReporitory: MetMuseumRemoteRepositoryImpl) : BaseViewModel() {

    val artHubUiState: MutableState<ArtHubUiState<List<com.example.digitalmuseum.models.Object>>> =
        mutableStateOf(ArtHubUiState.Start())

    fun loadObjects(){
        launch {
            val result = withContext(Dispatchers.IO) {
                metMuseumReporitory.getObjects()
            }

            when(result){
                is CommunicationResult.Error -> {
                    artHubUiState.value = ArtHubUiState.Error(R.string.failed)
                }
                is CommunicationResult.Exception -> {
                    artHubUiState.value = ArtHubUiState.Error(R.string.no_internet_connection)
                }
                is CommunicationResult.Success -> {
                    artHubUiState.value = ArtHubUiState.Success(result.data)
                }
            }
        }

    }

}