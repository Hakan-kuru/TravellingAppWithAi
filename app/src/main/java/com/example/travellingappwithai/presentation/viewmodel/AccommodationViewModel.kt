package com.example.travellingappwithai.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travellingappwithai.domain.models.Accommodation
import com.example.travellingappwithai.domain.usecase.AccommodationUsecase
import kotlinx.coroutines.launch

class AccommodationViewModel(private val accommodationUsecase: AccommodationUsecase) : ViewModel() {

    fun getAllAccommandation(onResult: (List<Accommodation>) -> Unit) {
        viewModelScope.launch {
            val accommandation = accommodationUsecase.getAllAccommandation()
            onResult(accommandation)
        }
    }

    fun getAccommandationById(accomodationId: Int, onResult: (Accommodation?) -> Unit) {
        viewModelScope.launch {
            val accommandation = accommodationUsecase.getAccommandationById(accomodationId)
            onResult(accommandation)
        }
    }

    fun insertAccommandation(accomodation: Accommodation, onComplete: () -> Unit) {
        viewModelScope.launch {
            accommodationUsecase.insertAccommandation(accomodation)
            onComplete()
        }
    }

    fun deleteAccommandationById(accomodationId: Int, onComplete: () -> Unit) {
        viewModelScope.launch {
            accommodationUsecase.deleteAccommandationById(accomodationId)
            onComplete()
        }
    }

    fun deleteAllAccommandation(onComplete: () -> Unit) {
        viewModelScope.launch {
            accommodationUsecase.deleteAllAccommandation()
            onComplete()
        }
    }

    fun getAccommandationByName(name: String, onResult: (Accommodation?) -> Unit) {
        viewModelScope.launch {
            val accommandation = accommodationUsecase.getAccommandationByName(name)
            onResult(accommandation)
        }
    }

    fun getAccommandationByType(type: String, onResult: (List<Accommodation>) -> Unit) {
        viewModelScope.launch {
            val accommandation = accommodationUsecase.getAccommandationByType(type)
            onResult(accommandation)
        }
    }

    fun getAccommandationByDestinationId(destinationId: Int, onResult: (List<Accommodation>) -> Unit) {
        viewModelScope.launch {
            val accommandation = accommodationUsecase.getAccommandationByDestinationId(destinationId)
            onResult(accommandation)
        }
    }
}