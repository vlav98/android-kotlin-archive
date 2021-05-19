package fr.iim.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface UserService {

    @GET("/login")
    fun login(): Call<Void>

}