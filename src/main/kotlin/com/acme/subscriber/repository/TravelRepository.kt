package com.acme.subscriber.repository

import com.acme.subscriber.entity.TravelEntity
import javax.inject.Singleton

@Singleton
interface TravelRepository {
    fun saveTravelRepo(travelEntity: TravelEntity)
    fun updateTravelRepo(travelEntity: TravelEntity): TravelEntity
    fun deleteTravelRepo(id: String)
}