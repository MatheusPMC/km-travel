package com.acme.repository

import com.acme.model.Travel
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface TravelRepository: CrudRepository<Travel, Long> {

}