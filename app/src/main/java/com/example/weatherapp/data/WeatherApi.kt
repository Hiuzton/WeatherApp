package com.example.weatherapp.data

import com.example.weatherapp.data.model.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/forecast.json")
    suspend fun forecast(
        @Query("key") key: String,
        @Query("q") q: String,
        @Query("days") days: Int=2,
    ): ForecastResponse
}