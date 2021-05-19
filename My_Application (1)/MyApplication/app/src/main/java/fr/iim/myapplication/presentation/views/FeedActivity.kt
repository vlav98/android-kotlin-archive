package fr.iim.myapplication.presentation.views

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import fr.iim.myapplication.R
import fr.iim.myapplication.data.model.NasaImageOfTheDay
import fr.iim.myapplication.data.network.NasaService
import fr.iim.myapplication.data.network.ServiceBuilder
import fr.iim.myapplication.presentation.viewmodel.FeedViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FeedActivity : AppCompatActivity() {

    private lateinit var viewModel : FeedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)

        viewModel = FeedViewModel()
        getNasaImageList()


    }

    private fun getNasaImageList(){
        val request = ServiceBuilder.buildService(NasaService::class.java)
        val call = request.getList("sfeJZzrmX4SmLPO0qJrESORnEniYLn72q7WlZswk","10")

        call.enqueue(object : Callback<List<NasaImageOfTheDay>> {
            override fun onResponse(call: Call<List<NasaImageOfTheDay>>, response: Response<List<NasaImageOfTheDay>>) {

                if (response.isSuccessful){
                    Log.d("MainActivity",response.body()?.toString()?:"")
                } else {
                    Log.d("MainActivity",response.message())
                }
            }
            override fun onFailure(call: Call<List<NasaImageOfTheDay>>, t: Throwable) {
                t.message?.let {
                    Log.e("MainActivity",it)
                }
            }
        })
    }
}

