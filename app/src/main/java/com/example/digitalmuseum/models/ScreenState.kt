package com.example.digitalmuseum.models

import java.io.Serializable

sealed class ScreenState<out T> : Serializable {
    class Loading : ScreenState<Nothing>()
    class DataLoaded<T>(var data: T) : ScreenState<T>()
    class Error(var error: Int) : ScreenState<Nothing>()
}