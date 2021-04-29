package com.acme.controller

import com.acme.model.ErrorMessage
import com.acme.model.Travel
import com.acme.service.TravelService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType.APPLICATION_JSON
import io.micronaut.http.annotation.*
import javax.inject.Inject


@Controller(value = "/travel")

class TravelController {

    @Inject
    lateinit var travelService: TravelService

    @Get()
    fun getAll() :HttpResponse<List<Travel>> {
        val listTravel = this.travelService.getAll()
        return HttpResponse.ok(listTravel).body(this.travelService.getAll())
    }

    @Get("/{id}")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    fun getGetId(@PathVariable id:Long): HttpResponse<Any> {
        var travel = this.travelService.getById(id)
        return if (travel != null) {
            return HttpResponse.ok(travel)
        }else{
            return HttpResponse.notFound(ErrorMessage("Viagem nao localizada", "A viagem do ID: ${id} nao foi localizado"))
    }
    }

    @Post("/")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    fun create(@Body travel: Travel): HttpResponse<Travel?> {
        this.travelService.create(travel)
        return HttpResponse.created(travel)
    }

    @Put("/{id}")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    fun update(@PathVariable id: Long, @Body travel: Travel): HttpResponse<Travel> {
        return HttpResponse.ok(HttpStatus.OK).body(this.travelService.update(id, travel))
    }

    @Delete("/{id}")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    fun delete(@PathVariable id:Long): HttpResponse<Unit> {
        if (this.travelService.getById(id) != null) {
            this.travelService.delete(id)
        }
        return HttpResponse.notFound(Unit)
    }
}