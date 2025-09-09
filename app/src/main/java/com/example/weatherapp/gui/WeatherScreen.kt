package com.example.weatherapp.gui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import com.example.weatherapp.presentation.CityWeatherUi
import com.example.weatherapp.presentation.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(vm: WeatherViewModel) {
    val items by vm.items.collectAsState()

    Scaffold(topBar = { TopAppBar(title = { Text("Tomorrow’s Weather") }) }) { padding ->
        Column(
            Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Table header
            Row(
                Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray)
                    .padding(8.dp)
            ) {
                Text("City", fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.weight(1f))
                Text("Min °C", fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.weight(1f))
                Text("Max °C", fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.weight(1f))
                Text("Humidity %", fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.weight(1f))
                Text("Wind Speed kph", fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.weight(1f))
            }

            Spacer(Modifier.height(8.dp))

            // Table rows
            LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                items(items) { itx: CityWeatherUi ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .border(1.dp, Color.LightGray)
                            .padding(8.dp)
                    ) {
                        Text(itx.city, modifier = Modifier.weight(1f))
                        Text("${itx.minC}", modifier = Modifier.weight(1f))
                        Text("${itx.maxC}", modifier = Modifier.weight(1f))
                        Text("${itx.humidity}", modifier = Modifier.weight(1f))
                        Text("${itx.maxWindSpeedKph}", modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}
