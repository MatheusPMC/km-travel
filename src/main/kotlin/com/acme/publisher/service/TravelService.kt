package com.acme.publisher.service

import com.acme.publisher.model.Travel
import javax.inject.Singleton

@Singleton
interface TravelService {
    fun send(travel: Travel): Travel
    fun trade(id: String, travel: Travel): Travel
    fun delete(id: String)
}