package fr.iim.myapplication.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import fr.iim.myapplication.data.model.NasaImageOfTheDay

@Dao
interface NasaImageOfTheDayDao {
    @Query("SELECT * FROM nasaImageOfTheDay")
    fun getAll(): List<NasaImageOfTheDay>

    @Insert
    fun insertAll(images: List<NasaImageOfTheDay>)

    @Delete
    fun delete(image: NasaImageOfTheDay)
}