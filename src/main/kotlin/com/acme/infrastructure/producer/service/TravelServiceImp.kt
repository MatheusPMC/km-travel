package com.acme.infrastructure.producer.service

import com.acme.infrastructure.producer.TravelClient
import com.acme.model.Travel
import javax.inject.Singleton

@Singleton
class TravelServiceImp(private val natsClient: TravelClient) : TravelService {
    override fun send(travel: Travel): Travel {
        natsClient.send(travel)
        print(travel)
        return travel
    }

    override fun trade(travel: Travel): Travel {
        natsClient.send(travel)
        print(travel)
        return travel
    }
}