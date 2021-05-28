package com.acme.publisher.utils

import com.acme.publisher.model.Travel
import com.acme.publisher.model.handler.TravelException

class TravelUtils {
    companion object{
        fun localValid(travel: Travel): Travel {

            if(travel.local.isNullOrEmpty()) {
                throw TravelException()
            }
            return travel
        }
    }
}
