package com.acme.service.impl

import com.acme.model.Travel
import com.acme.service.TravelService
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton

@Singleton
class TravelServiceImpl (private val session: CqlSession): TravelService {

    override fun create(travel: Travel): Travel {
        val travelEntity = Travel(Random().nextLong(),travel.local,travel.description,
            travel.days,travel.price)
        session.execute(
            SimpleStatement
                .newInstance(
                    "INSERT INTO travel.Travel(id,local,description,days,price) VALUES (?,?,?,?,?)",
                    travelEntity.id,
                    travelEntity.local,
                    travelEntity.description,
                    travelEntity.days,
                    travelEntity.price
                )
        )
        return travelEntity
    }
}