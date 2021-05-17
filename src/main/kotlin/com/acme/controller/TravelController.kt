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


@Controller("/travel")
class TravelController(private val travelService: TravelService) {

    @Post("/")
    @Produces(APPLICATION_JSON)
    fun create(@Body travel: Travel): HttpResponse<Travel?> {
        TravelUtils.localValid(travel)
        return HttpResponse.created(HttpStatus.CREATED).body(this.travelService.create(travel))
    }
}
