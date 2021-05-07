package com.acme.model


import javax.persistence.*

@Entity
data class Travel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long?,


    @Column(name = "local")
    val local: String,

    @Column(name = "description")
    val description: String,

    @Column(name = "days")
    val days: Int,

    @Column(name = "price")
    val price: Double
){
    constructor(): this(null,"","",0,0.0)

}