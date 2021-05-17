
package com.acme.service

import com.acme.model.Travel
import com.datastax.oss.driver.api.core.cql.ResultSet
import java.math.BigInteger
import javax.inject.Singleton

@Singleton
interface TravelService {
  fun create(travel: Travel): Travel
}