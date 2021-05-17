package com.acme.service.impl

import com.acme.model.Travel
import com.acme.repository.TravelRepository
import com.acme.service.TravelService
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.ResultSet
import com.datastax.oss.driver.api.core.cql.Row
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TravelServiceImpl (private val session: CqlSession, var travelRepository: TravelRepository): TravelService {

    override fun create(travel: Travel): Travel {
        session.execute(
                SimpleStatement
                        .newInstance(
                                "INSERT INTO travel.Travel(id,local,description,days,price) VALUES (?,?,?,?,?)",
                                travel.id,
                                travel.local,
                                travel.description,
                                travel.days,
                                travel.price
                        )
        )
        return travel
    }
/*
    override fun getById(id: Long): Travel? {
        val travel = session.execute(session.prepare("SELECT * from travel.Travel WHERE id = '?'").bind(id))
        return Travel()
    }
*/
    override fun getById(id: Long): Travel? {
        val travel = session.execute(session.prepare("SELECT * from travel.Travel WHERE id = '?'").bind(id))
        val row = travel.first()
        return Travel(row.getLong("id"), row.getString("local").orEmpty(), row.getString("description").orEmpty(),
            row.getInt("days"), row.getDouble("price"))
    }


    override fun getAll(): List<Travel> {
        val results = session.execute("SELECT * from travel.Travel")
        val res = results.map {
            Travel(it.getLong("id"), it.getString("local").orEmpty())
        }
        return travelRepository.findAll().toList()
    }
}

private fun Any.toList(): List<Travel> {
    TODO("Not yet implemented")
}

private fun TravelRepository.findAll(): Any {
    TODO("Not yet implemented")
}
/*
    override fun delete(id: Long,) {
        this.travelRepository.deleteById(id).orElse(null)
    }

    override fun update(id: Long, travel: Travel): Travel {
        travel.id == id
        return travelRepository.update(travel)
    }



}

fun Any.orElse(nothing: Nothing?) {

}
*/
