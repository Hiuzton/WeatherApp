package com.example.weatherapp.data.model
import kotlinx.serialization.Serializable

@Serializable data class ForecastResponse(val location: Location, val forecast: Forecast)
@Serializable data class Location(val name: String, val country: String)
@Serializable data class Forecast(val forecastday: List<ForecastDay>)
@Serializable data class ForecastDay(val date: String, val day: Day)
@Serializable data class Day(val maxtemp_c: Float, val mintemp_c: Float)