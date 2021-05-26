package com.acme.infrastructure.producer

import com.acme.model.Travel
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface TravelClient {

    @Subject("travel")
    fun send(travel: Travel)
}

