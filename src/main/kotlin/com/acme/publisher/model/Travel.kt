package com.acme.publisher.model

import java.util.*

data class Travel(
    val id: UUID? = null,
    val local: String = "",
    val description: String = "",
    val days: Int = 0,
    val price: Double = 0.0
)