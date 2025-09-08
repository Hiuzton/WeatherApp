package com.example.weatherapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.WeatherRepository
import com.example.weatherapp.data.model.toUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class WeatherViewModel(
    private val repo: WeatherRepository = WeatherRepository()
) : ViewModel() {
    private val _items = MutableStateFlow<List<CityWeatherUi>>(emptyList())
    val items: StateFlow<List<CityWeatherUi>> = _items

    private val cities = mutableListOf("Chisinau", "Sibiu", "Bucharest")

    fun load() {
        viewModelScope.launch {
            val list = cities.mapNotNull { c -> runCatching { repo.getTomorrow(c) }.getOrNull()?.toUI(c) }
            _items.value = list
        }
    }

    fun addCity(city: String) { if (city.isNotBlank()) { cities.add(city.trim()); load() } }
    fun removeCity(city: String) { cities.remove(city); load() }
}