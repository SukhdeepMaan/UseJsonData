package com.example.usejsondata.countries.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val name: String,
    val dialCode: String,
    val code: String
)
