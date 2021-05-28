package com.acme.subscriber.service.impl

import com.acme.subscriber.entity.TravelEntity
import com.acme.subscriber.repository.TravelRepository
import com.acme.subscriber.service.TravelService
import javax.inject.Singleton

@Singleton
class TravelServiceImpl(private val travelRepository: TravelRepository) : TravelService {

    override fun create(travelEntity: TravelEntity): TravelEntity {
        travelRepository.saveTravelRepo(TravelEntity(travelEntity.id,travelEntity.local,travelEntity.description,travelEntity.days,travelEntity.price))
        return travelEntity
    }

    override fun update(travelEntity: TravelEntity): TravelEntity {
        travelRepository.updateTravelRepo(travelEntity)
        return travelEntity
    }

    override fun delete(id: String) {
        travelRepository.deleteTravelRepo(id)
    }


}
