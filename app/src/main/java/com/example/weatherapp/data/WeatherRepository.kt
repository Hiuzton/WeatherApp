package com.example.weatherapp.data

import android.util.Log
import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.model.ForecastDay

class WeatherRepository(
    private val api: WeatherApi = WeatherService.api,
    private val apiKey: String = BuildConfig.WEATHER_API_KEY
) {
    suspend fun getTomorrow(city: String): ForecastDay? {
        Log.d("WeatherRepository", "Requesting city=$city with apiKey=$apiKey")

        return try {
            val resp = api.forecast(apiKey, city, days = 2)
            Log.d("WeatherRepository", "API response for $city = $resp")
            resp.forecast.forecastday.getOrNull(1) // safe access for tomorrow
        } catch (e: Exception) {
            Log.e("WeatherRepository", "Error fetching forecast for $city", e)
            null
        }
    }
}
