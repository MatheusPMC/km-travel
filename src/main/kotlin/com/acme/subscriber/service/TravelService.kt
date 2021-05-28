package com.acme.subscriber.service

import com.acme.subscriber.entity.TravelEntity
import javax.inject.Singleton

@Singleton
interface TravelService {

    fun create(travelEntity: TravelEntity): TravelEntity
    fun update(travelEntity: TravelEntity): TravelEntity
    fun delete(id: String)
}