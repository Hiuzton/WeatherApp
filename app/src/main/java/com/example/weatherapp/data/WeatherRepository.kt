package com.example.weatherapp.data

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.model.ForecastDay

class WeatherRepository(
    private val api: WeatherApi = WeatherService.api,
    private val apiKey: String = BuildConfig.WEATHER_API_KEY
) {
    suspend fun getTomorrow(city: String): ForecastDay? {

        return try {
            val resp = api.forecast(apiKey, city, days = 2)
            resp.forecast.forecastday.getOrNull(1)
        } catch (e: Exception) {
            null
        }
    }
}
