package com.example.digitalmuseum.di

import com.example.digitalmuseum.ui.screens.ArtHubViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel{
        ArtHubViewModel(get())
    }
}