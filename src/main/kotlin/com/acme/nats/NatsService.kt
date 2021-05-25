package com.acme.nats

import com.acme.model.Travel
import javax.inject.Singleton

@Singleton
interface NatsService {
    fun send(travel: Travel): Travel
    fun trade(travel: Travel): Travel
}