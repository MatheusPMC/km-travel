package com.acme.publisher.service

import com.acme.publisher.TravelClient
import com.acme.publisher.model.Travel
import java.util.*
import javax.inject.Singleton

@Singleton
class TravelServiceImp(private val natsClient: TravelClient) : TravelService {
    override fun send(travel: Travel): Travel {
        var createTravel= Travel(
            UUID.randomUUID(), travel.local, travel.description,
            travel.days, travel.price)
        natsClient.send(createTravel)
        return createTravel
    }

    override fun trade(id: String, travel: Travel): Travel {
        var updateTravel = Travel(
            UUID.fromString(id), travel.local, travel.description,
            travel.days, travel.price)
        natsClient.trade(updateTravel)
        return updateTravel
    }

    override fun delete(id: String) {
        natsClient.delete(id)
    }
}