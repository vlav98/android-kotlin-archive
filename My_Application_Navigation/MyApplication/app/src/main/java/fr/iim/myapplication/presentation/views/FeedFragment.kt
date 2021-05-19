package fr.iim.myapplication.presentation.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import fr.iim.myapplication.R
import fr.iim.myapplication.data.model.NasaImageOfTheDay
import fr.iim.myapplication.data.network.NasaService
import fr.iim.myapplication.data.network.ServiceBuilder
import fr.iim.myapplication.presentation.AdapterRecyclerView
import fr.iim.myapplication.presentation.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedFragment : Fragment() {

    private lateinit var viewModel: FeedViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context?.let {
            viewModel = FeedViewModel(it)
        }



        getList()
        CoroutineScope(Dispatchers.IO).launch {
            var a = viewModel.get()
            activity?.runOnUiThread {
                //Toast.makeText(activity, a[0].explanation, Toast.LENGTH_LONG ).show()
            }

        }
        feed_param_button.setOnClickListener {
            (activity as FeedActivity).navigateToParam()
        }
    }

    fun getList(){
        val request = ServiceBuilder.buildService(NasaService::class.java)
        val call = request.getList("sfeJZzrmX4SmLPO0qJrESORnEniYLn72q7WlZswk", "10")

        call.enqueue(object : Callback<List<NasaImageOfTheDay>> {
            override fun onResponse(
                call: Call<List<NasaImageOfTheDay>>,
                response: Response<List<NasaImageOfTheDay>>
            ) {
                if (response.isSuccessful) {
                    feedList.adapter =
                        AdapterRecyclerView(ArrayList(response.body()), activity)
                    feedList.layoutManager = LinearLayoutManager(activity)

                    response.body()?.let { list ->
                        viewModel.insert(list)
                    }

                }
            }

            override fun onFailure(call: Call<List<NasaImageOfTheDay>>, t: Throwable) {
                Toast.makeText(activity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }


}