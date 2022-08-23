package com.jones.nationalparks.ui.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.jones.nationalparks.R
import com.jones.nationalparks.ui.ParksViewModel
import com.jones.nationalparks.ui.adapter.ViewPagerAdapter
import java.lang.StringBuilder

class DetailsFragment : Fragment() {

    private lateinit var parkViewModel: ParksViewModel
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager2


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager = view.findViewById(R.id.details_viewpager)
        parkViewModel = ViewModelProvider(requireActivity())[ParksViewModel::class.java]

        parkViewModel.selectedPark.observe(viewLifecycleOwner) { park ->
            val detailsParkName = view.findViewById<TextView>(R.id.details_park_name)
            val detailsDescription = view.findViewById<TextView>(R.id.details_description)
            val detailsfParkDesignation = view.findViewById<TextView>(R.id.detailsf_park_designation)
            val detailsActivities = view.findViewById<TextView>(R.id.details_activities)
            val detailsEntrancefees = view.findViewById<TextView>(R.id.details_entrancefees)
            val detailsOperatinghours = view.findViewById<TextView>(R.id.details_operatinghours)
            val detailsTopics = view.findViewById<TextView>(R.id.details_topics)
            val detailsDirections = view.findViewById<TextView>(R.id.details_directions)
            detailsParkName.text = park.fullName
            viewPagerAdapter = ViewPagerAdapter(park.images!!)
            viewPager.adapter = viewPagerAdapter
            detailsDescription.text = park.description
            detailsfParkDesignation.text = park.designation

            val stringBuilder = StringBuilder()
            for (i in park.activities!!) {
                stringBuilder.append(i?.name).append(" | ")
            }
            detailsActivities.text = stringBuilder
            if (!park.entranceFees?.isEmpty()!!) {
                detailsEntrancefees.text =
                    String.format("Cost : $%s", park.entranceFees?.get(0)?.cost)
            } else {
                detailsEntrancefees.text = getString(R.string.info_not_available)
            }
            stringBuilder.clear()
            stringBuilder.append("Monday: ").append(park.operatingHours?.get(0)?.standardHours?.monday).append("\n")
                .append("Tuesday: ").append(park.operatingHours?.get(0)?.standardHours?.tuesday).append("\n")
                .append("Wednesday: ").append(park.operatingHours?.get(0)?.standardHours?.wednesday).append("\n")
                .append("Thursday: ").append(park.operatingHours?.get(0)?.standardHours?.thursday).append("\n")
                .append("Friday: ").append(park.operatingHours?.get(0)?.standardHours?.friday).append("\n")
                .append("Saturday: ").append(park.operatingHours?.get(0)?.standardHours?.saturday).append("\n")
                .append("Sunday: ").append(park.operatingHours?.get(0)?.standardHours?.sunday).append("\n")
            detailsOperatinghours.text = stringBuilder
            stringBuilder.clear()
            for (i in park.topics!!) {
                stringBuilder.append(i?.name).append(" | ")
            }
            detailsTopics.text = stringBuilder
            stringBuilder.clear()
            if (!TextUtils.isEmpty(park.directionsInfo)) {
                detailsDirections.text = park.directionsInfo
            } else {
//                detailsDirections.text = getString(R.string.directions_not_available)
            }
        }
    }


}