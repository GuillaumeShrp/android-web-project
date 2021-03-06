package com.ismin.projectapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CovidTestCenterService {
    @GET("CovidCenters")
    fun getAllCovidCenters(): Call<List<CovidTestCenter>>

    @GET("CovidCenters/search/{covidCenterId}")
    fun getCovidCenter(@Path("covidCenterId") covidCenterId: String): Call<CovidTestCenter>

    @GET("CovidCenters/rs/{rs}")
    fun getCovidCenterByRs(@Path("rs") rs: String): Call<CovidTestCenter>
}