package com.acme.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
data class Travel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    val id: Long?,
    @Column(name = "local")
    val local: String,
    @Column(name = "description")
    val description: String,
    @Column(name = "days")
    val days: Int,
    @Column(name = "price")
    val price: Double
)