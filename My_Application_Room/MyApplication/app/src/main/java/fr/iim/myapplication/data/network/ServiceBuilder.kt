package fr.iim.myapplication.data.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl("https://api.nasa.gov/planetary/")
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}