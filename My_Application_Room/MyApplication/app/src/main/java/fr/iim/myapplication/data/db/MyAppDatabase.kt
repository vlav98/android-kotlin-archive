package fr.iim.myapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.iim.myapplication.data.model.NasaImageOfTheDay

@Database(
    entities = [NasaImageOfTheDay::class],
    version = 1)

abstract class MyAppDatabase : RoomDatabase() {
    abstract fun nasaImageOfTheDayDao(): NasaImageOfTheDayDao
}