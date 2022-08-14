package com.jones.nationalparks.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.jones.nationalparks.R

class CustomInfoWindow(val context: Context): GoogleMap.InfoWindowAdapter {

    override fun getInfoContents(p0: Marker): View? {
        TODO("Not yet implemented")
    }

    override fun getInfoWindow(marker: Marker): View? {

        val view = LayoutInflater.from(context).inflate(R.layout.custom_info_window,null,false)

        val parkName: TextView = view.findViewById(R.id.info_title)
        val parkState: TextView = view.findViewById(R.id.info_state)

        parkName.text = marker.title
        parkState.text = marker.snippet

        return view
    }


}