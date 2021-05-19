package fr.iim.myapplication.data.network

import fr.iim.myapplication.data.model.NasaImageOfTheDay
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaService {

    @GET("apod")
    fun getList(@Query("api_key") apiKey : String, @Query("count") count : String): Call<List<NasaImageOfTheDay>>

}