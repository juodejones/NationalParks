package com.jones.nationalparks.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jones.nationalparks.R
import com.jones.nationalparks.data.model.Data
import com.jones.nationalparks.data.model.ParksData
import com.jones.nationalparks.ui.adapter.OnParkClickListener
import com.jones.nationalparks.ui.adapter.ParkRecyclerViewAdapter
import com.jones.nationalparks.ui.viewmodel.MapsViewModel
import com.jones.nationalparks.ui.viewmodel.MapsViewModelFactory
import javax.inject.Inject

class ParksFragment : Fragment(),OnParkClickListener {

    private lateinit var mapsViewModelFactory: MapsViewModelFactory
    private lateinit var mapsViewModel: MapsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: ParkRecyclerViewAdapter
    private var parkList: ParksData? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_parks, container, false)
        mapsViewModel = ViewModelProvider(requireActivity())[MapsViewModel::class.java]
        mapsViewModel.getParks()
        recyclerView = view.findViewById(R.id.park_recyclerView)
        setAdapter()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setList()
    }

    companion object {
        fun newInstance() = ParksFragment()
    }

    override fun onParkClicked(data: Data) {
        mapsViewModel.selectedPark.postValue(data)
        childFragmentManager.beginTransaction()
            .add(R.id.park_fragment, DetailsFragment())
    }

    private fun setAdapter() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewAdapter = ParkRecyclerViewAdapter(parkList,this)
        recyclerView.adapter = recyclerViewAdapter
    }

    private fun setList() {
        mapsViewModel.parksData.observe(viewLifecycleOwner) {
            parkList = mapsViewModel.parksData.value!!.data
            recyclerViewAdapter.updateItem(parkList!!)
        }
    }

}