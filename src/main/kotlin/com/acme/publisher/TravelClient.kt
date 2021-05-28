package com.acme.publisher

import com.acme.publisher.model.Travel
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface TravelClient {

    @Subject("createTravel")
    fun send(travel: Travel)
    @Subject("updateTravel")
    fun trade(travel: Travel)
    @Subject("deleteTravel")
    fun delete(id: String)
}

