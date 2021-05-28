package com.acme.engine.service.impl

import com.acme.engine.entity.TravelEntity
import com.acme.engine.repository.TravelRepository
import com.acme.engine.service.TravelService
import javax.inject.Singleton

@Singleton
class TravelServiceImpl(private val travelRepository: TravelRepository) : TravelService {
    override fun getAll(): List<TravelEntity> {
        return travelRepository.getTravel()
    }

    override fun getById(id: String): TravelEntity? {
        return travelRepository.getByIdTravel(id)
    }
}