package com.acme.subscriber.nats

import com.acme.subscriber.entity.TravelEntity
import com.acme.subscriber.repository.TravelRepository
import com.acme.subscriber.service.TravelService
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject

@NatsListener
class UserServer(private val travelService: TravelService, private val travelRepository: TravelRepository) {

    @Subject("createTravel")
    fun receive(travelEntity: TravelEntity) {
        travelService.create(travelEntity)
    }

    @Subject("updateTravel")
    fun receiveUpdate(travelEntity: TravelEntity) {
        travelService.update(travelEntity)
    }

    @Subject("deleteTravel")
    fun receiveDelete(id: String) {
        travelService.delete(id)
    }
}