package com.acme.controller.test

import com.acme.controller.TravelController
import com.acme.model.Travel
import com.acme.service.TravelService
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


@MicronautTest
class TravelControllerTest {

    @InjectMockKs
    lateinit var travelController: TravelController

    @MockK
    lateinit var travelService: TravelService
    lateinit var travel: Travel

    @BeforeEach
    fun setUp() {
        clearAllMocks()
        MockKAnnotations.init(this)
        travel = Travel(1L, "cacun", "viagem de familia", 10, 11999.99)
    }


    @Test
    fun `request travel with success`() {
        every { travelService.create(any()) } returns travel
        val result = travelController.create(travel)
        Assertions.assertEquals(travel, result.body())
    }

    @Test
    fun `request get travel with success`() {
        every { travelService.getAll() } returns arrayListOf(travel)
        val result = travelController.getAll()
        Assertions.assertEquals(arrayListOf(travel), result.body())
    }

    @Test
    fun `request update travel with success`() {
        every { travelService.update(1, travel) } returns travel
        val result = travelController.update(1, travel)
        Assertions.assertEquals(travel, result.body())
    }

    @Test
    fun `delete travel with success`() {
        every { travelService.getById(any()) } returns travel
        every { travelService.delete(any()) } returns Unit
        val result = travelController.delete(1)
        Assertions.assertEquals(HttpStatus.OK, result.status())
    }
}
