package com.jones.nationalparks.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jones.nationalparks.R
import com.jones.nationalparks.data.model.Data
import com.jones.nationalparks.databinding.ActivityMapsBinding
import com.jones.nationalparks.ui.CustomInfoWindow
import com.jones.nationalparks.ui.MapsViewModelFactory
import com.jones.nationalparks.ui.ParksViewModel
import com.jones.nationalparks.ui.fragments.ParksFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MapsActivity : FragmentActivity(), OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener{

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

        var bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            val id = it.itemId
            if (id == R.id.maps_nav_button) {
                mMap.clear()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.map,mapFragment).commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .add(R.id.map,ParksFragment.newInstance()).commit()
            }
            true
        }


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