package com.acme.service.impl

import com.acme.model.Travel
import com.acme.repository.TravelRepository
import com.acme.service.TravelService
import java.net.http.HttpResponse
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TravelServiceImpl @Inject constructor(private var travelRepository: TravelRepository): TravelService {

    override fun create(travel: Travel): Travel {
        return  travelRepository.save(travel)
    }

        override fun getById(id: Long): Travel? {
            return this.travelRepository.findById(id).orElse( null)
        }

        override fun delete(id: Long,) {
            this.travelRepository.deleteById(id).orElse(null)
        }

        override fun update(id: Long, travel: Travel): Travel {
            travel.id == id
            return travelRepository.update(travel)
        }

    override fun getAll(): List<Travel> {
        return travelRepository.findAll().toList()
    }

}

private fun Any.orElse(nothing: Nothing?) {

}

