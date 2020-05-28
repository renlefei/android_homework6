package com.example.dihomework.model

data class Advice(
    var slip: Slip
)

data class Slip(
    val id: Int,
    val advice: String
)
