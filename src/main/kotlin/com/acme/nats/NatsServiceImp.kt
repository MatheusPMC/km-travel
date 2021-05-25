package com.acme.nats

import com.acme.model.Travel
import javax.inject.Singleton

@Singleton
class NatsServiceImp(private val natsClient: NatsClient): NatsService {
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