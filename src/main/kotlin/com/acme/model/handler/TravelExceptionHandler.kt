package com.acme.model.handler

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Produces
@Singleton
@Requires(classes = [TravelException::class, ExceptionHandler::class])
class TravelExceptionHandler: ExceptionHandler<TravelException?, HttpResponse<*>> {

    val LOG : Logger = LoggerFactory.getLogger(TravelExceptionHandler::class.java)
    override fun handle(request: HttpRequest<*>?, exception: TravelException?): HttpResponse<*> {
        val travelError = TravelError(
            HttpStatus.BAD_REQUEST.toString(),400
            ,"invalid arguments")
        LOG.error("REQUEST: {}", )
        return HttpResponse.badRequest(travelError)

    }
}

/*


    }

}

*/