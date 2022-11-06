package com.example.digitalmuseum.di

import com.example.digitalmuseum.communication.MetMuseumApi
import org.koin.dsl.module
import retrofit2.Retrofit

val  apiModule = module {
    single { provideMetMuseumApi(get()) }
}

fun provideMetMuseumApi(retrofit: Retrofit): MetMuseumApi
        = retrofit.create(MetMuseumApi::class.java)