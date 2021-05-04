package com.acme.controller.test

import com.acme.controller.TravelController
import com.acme.repository.TravelRepository
import com.acme.service.TravelService
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.mockito.InjectMocks
import org.mockito.Mock

@MicronautTest
class TravelServiceTest {

    @Mock
    lateinit var travelRepository: TravelRepository

    @InjectMocks
    lateinit var travelService: TravelService
}