package com.acme.model


import io.micronaut.core.annotation.Introspected

@Introspected
data class Travel(
    val id: Long? = null,
    val local: String = "",
    val description: String = "",
    val days: Int = 0,
    val price: Double = 0.0
)