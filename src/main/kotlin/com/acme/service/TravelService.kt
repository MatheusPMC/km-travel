
package com.acme.service

import com.acme.model.Travel
import com.datastax.oss.driver.api.core.cql.ResultSet
import java.math.BigInteger
import java.util.*
import javax.inject.Singleton

@Singleton
interface TravelService {

  fun create(travel: Travel): Travel
  fun getAll(): List<Travel>
  fun getById(id: String): Travel?
  fun delete(id: String)
  fun update(id: String, travel: Travel): Travel
}