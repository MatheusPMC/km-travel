package com.acme.engine.controller

import com.acme.engine.entity.TravelEntity
import com.acme.engine.service.TravelService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/travel")
class TravelController(private val travelService: TravelService) {


    @Get
    fun getAll(): HttpResponse<List<TravelEntity>> {
        val listTravel = this.travelService.getAll()
        return HttpResponse.ok(listTravel).body(this.travelService.getAll())
    }

    @Get("/{id}")
    fun getGetId(@PathVariable id: String): HttpResponse<Any> {
        val travel = this.travelService.getById(id)
        return HttpResponse.ok(travel)
    }
}
