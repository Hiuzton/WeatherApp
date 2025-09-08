package com.example.weatherapp.data.model

import com.example.weatherapp.presentation.CityWeatherUi

fun ForecastDay.toUI(city: String) = CityWeatherUi(
    city = city,
    date = date,
    minC = day.mintemp_c,
    maxC = day.maxtemp_c
)