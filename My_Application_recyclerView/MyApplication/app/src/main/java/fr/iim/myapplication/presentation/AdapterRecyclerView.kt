package fr.iim.myapplication.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.iim.myapplication.R
import fr.iim.myapplication.data.model.NasaImageOfTheDay
import kotlinx.android.synthetic.main.item.view.*


class AdapterRecyclerView(
    private var list: ArrayList<NasaImageOfTheDay>,
    val context: Context?
) : RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.item,
                parent,
                false
            ) as View
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val concat = ArrayList<NasaImageOfTheDay>()
        concat.addAll(list)
        val item = concat[position]
        holder.bind(item, position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(nasaImageOfTheDay: NasaImageOfTheDay?, position: Int) {

            itemView.description.text = nasaImageOfTheDay?.explanation

            context?.let {
                Glide.with(context)
                    .load(nasaImageOfTheDay?.url)
                    .into(itemView.image)
            }

        }

    }
}
