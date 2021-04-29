package com.acme.service

import com.acme.model.Travel

interface TravelService {
    fun create(travel: Travel): Travel
    fun getById(id: Long): Travel?
    fun delete(id: Long)
    fun update(id: Long, travel: Travel): Travel
    fun getAll(): List<Travel>
}