package com.acme.engine.service

import com.acme.engine.entity.TravelEntity
import javax.inject.Singleton

@Singleton
interface TravelService {
    fun getAll(): List<TravelEntity>
    fun getById(id: String): TravelEntity?
}