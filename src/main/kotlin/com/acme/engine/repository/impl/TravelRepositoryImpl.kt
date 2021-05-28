package com.acme.engine.repository.impl

import com.acme.engine.repository.TravelRepository
import com.acme.engine.entity.TravelEntity
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton

@Singleton
class TravelRepositoryImpl(private val session: CqlSession) : TravelRepository {
    override fun getTravel(): List<TravelEntity> {
        val results = session.execute("SELECT * from travel.Travel")
        val res = results.map {
            TravelEntity(
                it.getUuid("id"), it.getString("local").orEmpty(), it.getString("description").orEmpty(),
                it.getInt("days"), it.getDouble("price")
            )
        }
        return res.toList()
    }

    override fun getByIdTravel(id: String): TravelEntity? {
        val temporaryId = UUID.fromString(id)
        val result = session.execute(
            SimpleStatement.newInstance(
                "SELECT * FROM travel.Travel WHERE id = ? LIMIT 10000", temporaryId
            )
        )
        return result.map { Travel ->
            TravelEntity(
                Travel.getUuid("id")!!, Travel.getString("local")!!,
                Travel.getString("description")!!, Travel.getInt("days"), Travel.getDouble("price")
            )
        }.first()
    }
}