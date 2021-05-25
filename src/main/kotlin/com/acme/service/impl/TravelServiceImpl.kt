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
        val travelEntity = Travel(
            UUID.randomUUID(), travel.local, travel.description,
            travel.days, travel.price
        )
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

    override fun getAll(): List<Travel> {
        var results = session.execute("SELECT * from travel.Travel")
        val res = results.map {
            Travel(
                it.getUuid("id"), it.getString("local").orEmpty(), it.getString("description").orEmpty(),
                it.getInt("days"), it.getDouble("price")
            )
        }
        return res.toList()
    }

    override fun getById(id: String): Travel? {
        val temporaryId = UUID.fromString(id)
        val result = session.execute(
            SimpleStatement.newInstance(
                "SELECT * FROM travel.Travel WHERE id = ? LIMIT 10000", temporaryId
            )
        )
        return result.map { Travel ->
            Travel(
                Travel.getUuid("id")!!, Travel.getString("local")!!,
                Travel.getString("description")!!, Travel.getInt("days")!!, Travel.getDouble("price")!!
            )
        }.first()
    }

    override fun delete(id: String) {
        val temporaryId = UUID.fromString(id)
        val result = session.execute(
            SimpleStatement.newInstance(
                "DELETE FROM travel.Travel WHERE id = ?", temporaryId
            )
        )
    }

    override fun update(id: String, travel: Travel): Travel {
        session.execute(
            SimpleStatement
                .newInstance(
                    "UPDATE travel.Travel SET local = ? ,description = ? ,days = ?, price = ? WHERE id = ?",
                    travel.local,
                    travel.description,
                    travel.days,
                    travel.price,
                    travel.id
                    )
        )
        return travel

    }
}
