package com.acme.controller

import com.acme.model.Travel
import com.acme.nats.NatsServiceImp
import com.acme.service.TravelService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.test.AssertionMode
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.comparables.shouldBeGreaterThanOrEqualTo
import io.kotest.matchers.comparables.shouldBeLessThanOrEqualTo
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldHave
import io.kotest.matchers.string.beUUID
import io.kotest.mpp.uniqueId
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Get
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import io.netty.handler.codec.http.HttpResponseStatus.OK
import java.util.*
import kotlin.collections.ArrayList

@MicronautTest
class TravelControllerTest: AnnotationSpec() {

    private val natsServiceImp = mockk<NatsServiceImp>()
    private val travelService = mockk<TravelService>()
    private val travelController = mockk<TravelController>()

    private lateinit var  travel: Travel

    @BeforeEach
    fun setUp() {
       travel = Travel(UUID.randomUUID(), "cacun", "viagem de familia", 10, 11999.99)
    }

    @Test
    fun `request create travel with success`(){
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

    /*
    @Test
    fun `request delete travel with success`() {
        every { travelService.getById(any()) } returns travel
        every { travelService.delete(any()) } returns Unit
        val result = travelController.delete(travel.id!!.toString())
        result shouldBe Unit
    }
    */
}