package com.acme.infrastructure.producer.service

import com.acme.model.Travel
import javax.inject.Singleton

@Singleton
interface TravelService {
    fun send(travel: Travel): Travel
    fun trade(travel: Travel): Travel
}