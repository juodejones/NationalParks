package com.jones.nationalparks.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jones.nationalparks.R
import com.jones.nationalparks.data.model.Data
import com.jones.nationalparks.data.model.ParksData
import com.squareup.picasso.Picasso

class ParkRecyclerViewAdapter(
    private var parksData: ParksData?,
    val parkClickListener: OnParkClickListener
) : RecyclerView.Adapter<ParkRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.park_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val park = parksData?.data?.get(position)!!

        holder.parkName.text = park.name
        holder.parkState.text = park.states
        holder.parkType.text = park.designation
        if (park.images?.size!! > 0) {
            Picasso.get()
                .load(park.images?.get(0)!!.url)
                .placeholder(android.R.drawable.stat_sys_download)
                .error(android.R.drawable.stat_notify_error)
                .resize(250, 250)
                .centerCrop()
                .into(holder.parkImage)
        }
    }

    override fun getItemCount(): Int {
        return parksData?.data?.size!!
    }

    fun updateItem(parks: ParksData) {
        this.parksData = parks!!
    }

    inner class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var parkImage: ImageView = itemView.findViewById(R.id.park_row_imageView)
        var parkName: TextView = itemView.findViewById(R.id.park_row_name)
        var parkType: TextView = itemView.findViewById(R.id.park_row_type)
        var parkState: TextView = itemView.findViewById(R.id.park_row_state)
        private val onParkClickListener = parkClickListener

        override fun onClick(v: View?) {
            val currPark = parksData?.data?.get(adapterPosition)!!
            onParkClickListener.onParkClicked(currPark)
        }
    }
}

interface OnParkClickListener {
    fun onParkClicked(data: Data)
}