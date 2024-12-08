package com.example.travellingappwithai.domain.usecase

import com.example.travellingappwithai.data.database.local.entity.WeatherEntity
import com.example.travellingappwithai.data.database.repositories.WeatherRepository
import com.example.travellingappwithai.domain.models.Weather

class GetWeatherUsecase(private val weatherRepository: WeatherRepository) {

    suspend fun getWeatherByDestinationId(destinationId: Int): Weather? {
        return weatherRepository.getWeatherByDestinationId(destinationId)
    }

    suspend fun getAllWeather(): List<Weather> {
        return weatherRepository.getAllWeather()
    }

    suspend fun deleteWeatherById(weatherId: Int) {
        weatherRepository.deleteWeatherById(weatherId)
    }

    suspend fun deleteAllWeather() {
        weatherRepository.deleteAllWeather()
    }

    suspend fun insertWeather(weather: Weather) {
        weatherRepository.insertWeather(weather)
    }
}