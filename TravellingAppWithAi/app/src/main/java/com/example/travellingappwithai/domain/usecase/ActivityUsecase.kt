package com.example.travellingappwithai.domain.usecase

import androidx.lifecycle.ViewModel
import com.example.travellingappwithai.data.database.local.daos.ActivityDao
import com.example.travellingappwithai.data.database.local.entity.ActivityEntity
import com.example.travellingappwithai.data.database.repositories.ActivityRepository
import com.example.travellingappwithai.domain.models.Activity

class ActivityUsecase(private val activityRepo: ActivityRepository) : ViewModel() {

    suspend fun getAllActivities(): List<Activity> {
        return activityRepo.getAllActivities().map { it }
    }

    suspend fun getActivityById(activityId: Int): Activity? {
        return activityRepo.getActivityById(activityId)
    }

    suspend fun insertActivity(activity: Activity) {
        activityRepo.insertActivity(activity)
    }

    suspend fun deleteActivityById(activityId: Int) {
        activityRepo.deleteActivityById(activityId)
    }

    suspend fun getActivityByName(name: String): Activity? {
        return activityRepo.getActivityByName(name)
    }

    suspend fun getActivitiesByType(type: String): List<Activity> {
        return activityRepo.getActivitiesByType(type)
    }

    suspend fun getActivitiesByDestinationId(destinationId: Int): List<Activity> {
        return activityRepo.getActivitiesByDestinationId(destinationId)
    }
}