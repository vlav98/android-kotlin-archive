package fr.iim.myapplication.presentation.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.room.Room
import fr.iim.myapplication.data.db.MyAppDatabase
import fr.iim.myapplication.data.model.NasaImageOfTheDay
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

    fun insertImagesInDb(list : List<NasaImageOfTheDay>) {
        GlobalScope.launch {
            val userDao = db.nasaImageOfTheDayDao()
            userDao.insertAll(list)
        }
    }

    fun getImagesFromDb() {
        GlobalScope.launch {
            val userDao = db.nasaImageOfTheDayDao()
            var a = userDao.getAll()
            Log.d("FeedViewModel",a.toString())
        }

    }

}

