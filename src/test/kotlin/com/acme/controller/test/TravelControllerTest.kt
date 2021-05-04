package com.acme.controller.test

import com.acme.controller.TravelController
import com.acme.model.Travel
import com.acme.model.handler.ErrorMessage
import com.acme.repository.TravelRepository
import com.acme.service.TravelService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.*


@MicronautTest
class TravelControllerTest {

    @InjectMockKs
    lateinit var travelController: TravelController
    lateinit var travelRepository: TravelRepository

    @MockK
    lateinit var travelService: TravelService
    lateinit var travel: Travel

    @BeforeEach
    fun setUp() {
        clearAllMocks()
        MockKAnnotations.init(this)
        travel = Travel(1L, "local","description",1,1.99)
    }

    @Test
    fun `request travel with success`() {
        every { travelService.create(any()) } returns travel
        val result = travelController.create(travel)
        Assertions.assertEquals(travel, result.body())
    }

    @Test
    fun testConsultarSucesso() {
        every { travelService.getById(20) } returns travel
    }


    @Test
    fun `must getAll travel with success`() {
        fun getAll(): List<Travel> {
            return travelRepository.findAll().toList()
        }
    }

    @Test
    fun `must delete travel with success`() {
        fun delete(id: Long, ) {
            this.travelRepository.deleteById(id)

        }
    }

    @Test
    fun `must update travel with success`() {
        fun update(@PathVariable id: Long, @Body travel: Travel): HttpResponse<Travel> {
            return HttpResponse.ok(HttpStatus.OK).body(this.travelService.update(id, travel))
        }
    }
}