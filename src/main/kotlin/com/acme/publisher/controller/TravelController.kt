package com.acme.publisher.controller

import com.acme.publisher.model.Travel
import com.acme.publisher.service.TravelService
import com.acme.publisher.service.TravelServiceImp

import com.acme.publisher.utils.TravelUtils
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*

@Controller("/travel")
class TravelController(private val travelService: TravelService, private val natsServiceImp: TravelServiceImp) {


    @Post
    fun create(@Body travel: Travel): HttpResponse<Travel?> {
        TravelUtils.localValid(travel)
        return HttpResponse.created(HttpStatus.CREATED).body(travelService.send(travel))
    }

    @Put("/{id}")
    fun update(@PathVariable id: String, @Body travel: Travel): HttpResponse<Travel> {
        return HttpResponse.ok(HttpStatus.OK).body(this.travelService.trade(id, travel))
    }

    @Delete("/{id}")
    fun delete(@PathVariable id: String): HttpResponse<Any> {
        return HttpResponse.ok(Unit).body(this.travelService.delete(id))
    }
}
