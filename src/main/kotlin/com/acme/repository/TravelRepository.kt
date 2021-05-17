package com.acme.repository

import com.acme.model.Travel
import javax.inject.Singleton

@Singleton
interface TravelRepository{
    fun create(travel: Travel): Travel
}
