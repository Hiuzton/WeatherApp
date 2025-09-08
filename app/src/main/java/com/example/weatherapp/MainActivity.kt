package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.weatherapp.presentation.WeatherViewModel
import com.example.weatherapp.gui.WeatherScreen

class MainActivity : ComponentActivity() {
    private val vm: WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.load()
        setContent { WeatherScreen(vm) }
    }
}