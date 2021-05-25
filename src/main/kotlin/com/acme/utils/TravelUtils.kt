package com.acme.utils

import com.acme.model.Travel
import com.acme.model.handler.TravelException

class TravelUtils {
    companion object{
        fun localValid(travel: Travel): Travel{

            if(travel.local.isNullOrEmpty()) {
                throw TravelException()
            }
            return travel
        }
    }
}
