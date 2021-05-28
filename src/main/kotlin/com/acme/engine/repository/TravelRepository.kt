package com.acme.engine.repository

import com.acme.engine.entity.TravelEntity
import javax.inject.Singleton

@Singleton
interface TravelRepository {
    fun getTravel(): List<TravelEntity>
    fun getByIdTravel(id: String): TravelEntity?
}