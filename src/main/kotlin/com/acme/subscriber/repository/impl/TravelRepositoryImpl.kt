package com.acme.subscriber.repository.impl

import com.acme.subscriber.entity.TravelEntity
import com.acme.subscriber.repository.TravelRepository
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton

@Singleton
class TravelRepositoryImpl(private val session: CqlSession) : TravelRepository {
    override fun saveTravelRepo(travelEntity: TravelEntity) {
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
    }

    override fun updateTravelRepo(travelEntity: TravelEntity): TravelEntity {
        session.execute(
            SimpleStatement
                .newInstance(
                    "UPDATE travel.Travel SET local = ? ,description = ? ,days = ?, price = ? WHERE id = ?",
                    travelEntity.local,
                    travelEntity.description,
                    travelEntity.days,
                    travelEntity.price,
                    travelEntity.id
                )
        )
        return travelEntity
    }

    override fun deleteTravelRepo(id: String) {
        val temporaryId = UUID.fromString(id)
        session.execute(
            SimpleStatement.newInstance(
                "DELETE FROM travel.Travel WHERE id = ?", temporaryId
            )
        )
    }


}