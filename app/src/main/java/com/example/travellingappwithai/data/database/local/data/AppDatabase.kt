package com.example.travellingappwithai.data.database.local.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.travellingappwithai.data.database.local.daos.ActivityDao
import com.example.travellingappwithai.data.database.local.daos.DestinationDao
import com.example.travellingappwithai.data.database.local.daos.RestaurantDao
import com.example.travellingappwithai.data.database.local.daos.UserDao
import com.example.travellingappwithai.data.database.local.entity.UserEntity
import com.example.travellingappwithai.data.database.local.entity.DestinationEntity
import com.example.travellingappwithai.data.database.local.entity.ActivityEntity
import com.example.travellingappwithai.data.database.local.entity.RestaurantEntity


@Database(entities = [UserEntity::class, DestinationEntity::class, ActivityEntity::class, RestaurantEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun destinationDao(): DestinationDao
    abstract fun activityDao(): ActivityDao
    abstract fun restaurantDao(): RestaurantDao

}