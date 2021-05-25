package com.acme.nats

import com.acme.model.Travel
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface NatsClient {

    @Subject("travel")
    fun send(travel: Travel)
    fun trade(travel: Travel)
}

