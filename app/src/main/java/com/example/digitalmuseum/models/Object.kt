package com.example.digitalmuseum.models

data class Object(
    val objectID: Int,
    val isHighlight: Boolean,
    val accessionYear: String?,
    val primaryImage: String?,
    val primaryImageSmall: String?,
    val department: String,
    val objectName: String?,
    val title: String,
    val culture: String?,
    val period: String?,
    val portfolio: String?,
    val artistDisplayName: String?,
    val artistDisplayBio: String?,
    val artistBeginDate: String?,
    val artistEndDate: String?,
    val medium: String?,
    val dimensions: String?,
    val country: String?,
    val linkResource: String?
)
