package com.acme.controller

import com.acme.model.Travel
import com.acme.infrastructure.producer.service.TravelServiceImp
import com.acme.service.TravelService
import com.acme.utils.TravelUtils
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*

@Controller("/travel")
class TravelController(private val travelService: TravelService, private val natsServiceImp: TravelServiceImp) {

    @Get
    fun getAll(): HttpResponse<List<Travel>> {
        val listTravel = this.travelService.getAll()
        return HttpResponse.ok(listTravel).body(this.travelService.getAll())
    }

    @Get("/{id}")
    fun getGetId(@PathVariable id: String): HttpResponse<Any> {
        val travel = this.travelService.getById(id)
        return HttpResponse.ok(travel)
    }


    @Post
    fun create(@Body travel: Travel): HttpResponse<Travel?> {
        TravelUtils.localValid(travel)
        natsServiceImp.send(travel)
        return HttpResponse.created(HttpStatus.CREATED).body(this.travelService.create(travel))
    }

    @Delete("/{id}")
    fun delete(@PathVariable id: String): HttpResponse<Any> {
        return if (this.travelService.getById(id) != null) {
            this.travelService.delete(id)
            HttpResponse.ok(Unit)
        } else {
            HttpResponse.notFound()
        }
    }


    @Put("/{id}")
    fun update(@PathVariable id: String, @Body travel: Travel): HttpResponse<Travel> {
        natsServiceImp.trade(travel)
        return HttpResponse.ok(HttpStatus.OK).body(this.travelService.update(id, travel))
    }
}
