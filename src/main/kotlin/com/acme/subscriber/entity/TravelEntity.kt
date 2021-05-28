package com.acme.subscriber.entity

import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
data class TravelEntity (
    val id: UUID? = null,
    val local: String = "",
    val description: String = "",
    val days: Int = 0,
    val price: Double = 0.0
)