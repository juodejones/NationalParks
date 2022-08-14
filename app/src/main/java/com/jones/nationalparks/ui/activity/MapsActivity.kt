package com.jones.nationalparks.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.jones.nationalparks.R
import com.jones.nationalparks.data.model.Data
import com.jones.nationalparks.databinding.ActivityMapsBinding
import com.jones.nationalparks.ui.CustomInfoWindow
import com.jones.nationalparks.ui.MapsViewModelFactory
import com.jones.nationalparks.ui.ParksViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener{

    @Inject lateinit var parksViewModelFactory: MapsViewModelFactory
    lateinit var parksViewModel: ParksViewModel

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        parksViewModel = ViewModelProvider(this,parksViewModelFactory)[ParksViewModel::class.java]
        parksViewModel.getParks()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setInfoWindowAdapter(CustomInfoWindow(applicationContext))
        mMap.setOnInfoWindowClickListener(this)
        parksViewModel.parksData.observe(this) {
            //Log.d("MainParks", "onMapReady: ${it.data}")
            populateMap(it.data?.data)
        }
    }

    private fun populateMap(parkList: List<Data?>?) {
        for (i in 0 until parkList?.size!!) {
//                Log.d("MainParks", "onMapReady: ${parksList[i]?.fullName}")
            val latLong = LatLng(parkList[i]?.latitude?.toDouble()!!,parkList[i]?.longitude?.toDouble()!!)
            val markerOptions = MarkerOptions()
                .position(latLong)
                .title(parkList[i]?.name)
                .snippet(parkList[i]?.states)
            mMap.addMarker(markerOptions)
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLong))
        }
    }

    override fun onInfoWindowClick(marker: Marker) {
//        Log.d("MainParks", "onInfoWindowClick: ${marker.title}")
    }
}