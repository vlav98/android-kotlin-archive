package fr.iim.myapplication.presentation.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import fr.iim.myapplication.R
import fr.iim.myapplication.data.model.NasaImageOfTheDay
import fr.iim.myapplication.data.network.NasaService
import fr.iim.myapplication.data.network.ServiceBuilder
import fr.iim.myapplication.presentation.AdapterRecyclerView
import fr.iim.myapplication.presentation.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.activity_feed.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FeedActivity : AppCompatActivity() {

    private lateinit var viewModel: FeedViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        viewModel = FeedViewModel(this)
        getNasaList()

    }

    private fun getNasaList(){
        val request = ServiceBuilder.buildService(NasaService::class.java)
        val call = request.getList("sfeJZzrmX4SmLPO0qJrESORnEniYLn72q7WlZswk", "10")

        call.enqueue(object : Callback<List<NasaImageOfTheDay>> {
            override fun onResponse(
                call: Call<List<NasaImageOfTheDay>>,
                response: Response<List<NasaImageOfTheDay>>
            ) {
                if (response.isSuccessful) {
                    feedList.adapter =
                        AdapterRecyclerView(ArrayList(response.body()), this@FeedActivity)
                    feedList.layoutManager = LinearLayoutManager(this@FeedActivity)
                }
            }
            override fun onFailure(call: Call<List<NasaImageOfTheDay>>, t: Throwable) {
                Toast.makeText(this@FeedActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

