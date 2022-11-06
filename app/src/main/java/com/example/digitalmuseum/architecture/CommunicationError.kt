package com.example.digitalmuseum.architecture

data class CommunicationError(
    val code: Int,
    var message: String?,
    var secondaryMessage: String? = null)