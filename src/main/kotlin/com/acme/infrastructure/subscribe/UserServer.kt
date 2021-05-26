package com.acme.infrastructure.subscribe

import com.acme.model.Travel
import com.acme.service.impl.TravelServiceImpl
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject

@NatsListener
class UserServer(private val travelServiceImpl: TravelServiceImpl) {

    @Subject("travel")
    fun receive(travel: Travel) {
        travelServiceImpl.create(travel)
        println("OK!")
    }
}