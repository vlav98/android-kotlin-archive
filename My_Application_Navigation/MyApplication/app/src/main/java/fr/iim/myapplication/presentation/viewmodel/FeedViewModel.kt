package fr.iim.myapplication.presentation.viewmodel

import android.content.Context
import android.media.Image
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.room.Room
import fr.iim.myapplication.data.db.MyAppDatabase
import fr.iim.myapplication.data.model.NasaImageOfTheDay
import kotlinx.coroutines.*

class FeedViewModel(context : Context) : ViewModel() {

    val db = Room.databaseBuilder(
        context,
        MyAppDatabase::class.java, "database-name"
    ).build()

    fun test() : List<NasaImageOfTheDay>{
        val userDao = db.nasaImageOfTheDayDao()
        val users: List<NasaImageOfTheDay> = userDao.getAll()
        return users
    }

    fun insert(list : List<NasaImageOfTheDay>) {

        CoroutineScope(Dispatchers.IO).launch {
            val userDao = db.nasaImageOfTheDayDao()
            userDao.insertAll(list[1])
        }

    }

    fun get() : List<NasaImageOfTheDay>{
            val userDao = db.nasaImageOfTheDayDao()
            return userDao.getAll()

    }

}

