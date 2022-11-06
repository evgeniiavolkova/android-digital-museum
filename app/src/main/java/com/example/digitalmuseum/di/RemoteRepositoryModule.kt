package com.example.digitalmuseum.di

import com.example.digitalmuseum.communication.MetMuseumApi
import com.example.digitalmuseum.communication.MetMuseumRemoteRepositoryImpl
import org.koin.dsl.module

val remoteRepositoryModule = module {
    single { provideMetMuseumRemoteRepository(get()) }
}

fun provideMetMuseumRemoteRepository(countriesApi: MetMuseumApi): MetMuseumRemoteRepositoryImpl
        = MetMuseumRemoteRepositoryImpl(countriesApi)