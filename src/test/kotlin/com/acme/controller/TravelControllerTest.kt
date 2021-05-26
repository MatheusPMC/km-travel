package com.acme.controller

import com.acme.model.Travel
import com.acme.infrastructure.producer.service.TravelServiceImp
import com.acme.service.TravelService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*


@MicronautTest
class TravelControllerTest : AnnotationSpec() {

    private val natsServiceImp = mockk<TravelServiceImp>()
    private val travelService = mockk<TravelService>()
    private val travelController = TravelController(travelService, natsServiceImp)

    private lateinit var travel: Travel

    @BeforeEach
    fun setUp() {
        travel = Travel(UUID.randomUUID(), "cacun", "viagem de familia", 10, 11999.99)
    }

    @Test
    fun `request create travel with success`() {
        every { natsServiceImp.send(any()) } answers { travel }
        val result = natsServiceImp.send(travel)
        result shouldBe travel
    }

    @Test
    fun `request update travel with success`() {
        every { natsServiceImp.trade(any()) } answers { travel }
        val result = natsServiceImp.trade(travel)
        result shouldBe travel
    }


    @Test
    fun `request delete travel with success`() {
        every { travelService.getById(any()) } answers { travel }
        every { travelService.delete(any()) } answers { Unit }
        val result = travelController.delete(toString())
        result.status() shouldBe HttpStatus.OK
    }

    @Test
    fun `request getAll travel with success`() {
        every { travelService.getAll() } returns arrayListOf(travel)
        val result = travelController.getAll()
        result.body() shouldBe arrayListOf(travel)
    }

    @Test
    fun `request getByID travel with success`() {
        every { travelService.getById(any()) } answers { travel }
        val result = travelController.getGetId(toString())
        result.status() shouldBe HttpStatus.OK
    }

    @Test
    fun `request getByID2 travel with success`() {
        every { travelService.getById(any()) } answers { travel }
        val result = travelController.getGetId(toString())
        result.body() shouldBe travel
    }

}