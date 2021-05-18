package com.acme.controller

import com.acme.model.handler.ErrorMessage
import com.acme.model.Travel
import com.acme.service.TravelService
import com.acme.utils.TravelUtils
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType.APPLICATION_JSON
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import java.math.BigInteger
import java.util.*


@Controller("/travel")
class TravelController(private val travelService: TravelService) {

    @Get
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    fun getAll() :HttpResponse<List<Travel>> {
        val listTravel = this.travelService.getAll()
        return HttpResponse.ok(listTravel).body(this.travelService.getAll())
    }

    @Get("/{id}")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    fun getGetId(@PathVariable id: String): HttpResponse<Any> {
        var travel = this.travelService.getById(id)
        return if (travel != null) {
            HttpResponse.ok(travel)
        }else{
            HttpResponse.notFound(ErrorMessage("Viagem nao localizada","A viagem do ID: $id nao foi localizado"))
        }
    }

    @Post("/")
    @Produces(APPLICATION_JSON)
    fun create(@Body travel: Travel): HttpResponse<Travel?> {
        TravelUtils.localValid(travel)
        return HttpResponse.created(HttpStatus.CREATED).body(this.travelService.create(travel))
    }

    @Delete("/{id}")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    fun delete(@PathVariable id:String): HttpResponse<Any> {
        return if (this.travelService.getById(id) != null) {
            this.travelService.delete(id)
            HttpResponse.ok(Unit)
        } else {
            HttpResponse.notFound(ErrorMessage("Viagem nao pode ser apagada","A viagem do ID: $id nao foi localizado"))
        }
    }

    @Put("/{id}")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    fun update(@PathVariable id: String, @Body travel: Travel): HttpResponse<Travel> {
        return HttpResponse.ok(HttpStatus.OK).body(this.travelService.update(id, travel))
    }
}
