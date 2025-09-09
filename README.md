# Weather App

This Weather App was developed as part of a technical requirement from an IT company. The goal was to build a Kotlin-based Android application that consumes weather data from the [WeatherAPI.com](https://www.weatherapi.com/) 
service and displays **forecast information for selected cities**.

---

## Project Overview

The application demonstrates:
- Integration with a third-party **REST API** (WeatherAPI.com).  
- Use of **Retrofit** for networking.  
- **Repository pattern** for data handling.  
- **ViewModel + StateFlow** for state management.  
- **Jetpack Compose** for modern, declarative UI.

---

## Development Process

1. **API Exploration**  
   - Tested the WeatherAPI endpoints using Swagger.  
   - Identified the `forecast.json` endpoint as the most suitable for the app.  
   - Required parameters:  
     - `q` → city name  
     - `days` → number of forecast days

<p align="center">       
  <img width="1444" height="736" alt="image" src="https://github.com/user-attachments/assets/2da2be6b-a5e7-41c0-b265-ede5ce8a45d1" />
</p>

2. **API Response Analysis**  
   - Studied the JSON structure of the forecast response.  
   - Extracted relevant fields: **minimum/maximum temperature**, **humidity**, and **wind speed**.  
   - To run the API, an **API key** was required for authentication. Once provided, I received successful `200 OK` HTTP responses.  
   - **Limitations:**  
     - Wind direction was only available in the *hourly data*, making it inconsistent across the daily forecast.  

   <p align="center">
     <img width="564" height="273" alt="Swagger Response Example" src="https://github.com/user-attachments/assets/6ca715a7-fc5c-48eb-9309-c948379327f6" />
   </p>

   <p align="center">
     <img width="460" height="484" alt="JSON Forecast Example" src="https://github.com/user-attachments/assets/11e38c44-a8b9-488c-a65d-0346c8b83711" />
   </p>

3. **Architecture & Implementation**  
   - **Models**: Created Kotlin data classes mapped to the API response.  
   - **Networking**: Configured Retrofit service.  
   - **Repository**: Abstracted data-fetching logic.  
   - **ViewModel**: Managed state and exposed a clean UI model (`CityWeatherUi`).  
   - **UI**: Designed a simple **table layout** showing:  
     - City  
     - Min °C  
     - Max °C  
     - Humidity %  
     - Wind Speed kph 

---

## Screenshots

- **Table populated with weather data**
  
<p align="center">
  <img width="238" height="640" alt="image" src="https://github.com/user-attachments/assets/bb7e74a0-8f8c-4fbe-92de-98f5ae7285ba" />
</p>

---

## Known Limitations

- Wind direction was not included in the final table, since WeatherAPI only provides it inside hourly forecast objects, which vary throughout the day.  

---

## Future Improvements

- Add **persistent storage** (DataStore/Room) for user-selected cities.   
- Include **current location** support via Android location services.  
- Display **hourly details** in a secondary screen.  

---

## Tech Stack

- **Language**: Kotlin  
- **UI**: Jetpack Compose  
- **Networking**: Retrofit + OkHttp   
- **Architecture**: MVVM (ViewModel + Repository)  
- **Dependency Management**: Gradle Version Catalog  
