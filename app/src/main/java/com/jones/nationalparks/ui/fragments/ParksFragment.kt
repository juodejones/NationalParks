package com.jones.nationalparks.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.jones.nationalparks.R
import com.jones.nationalparks.data.model.Data
import com.jones.nationalparks.ui.MapsViewModelFactory
import com.jones.nationalparks.ui.ParksViewModel
import com.jones.nationalparks.ui.adapter.OnParkClickListener
import javax.inject.Inject

class ParksFragment : Fragment(),OnParkClickListener {

    @Inject
    lateinit var parksViewModelFactory: MapsViewModelFactory
    lateinit var parksViewModel: ParksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parksViewModel = ViewModelProvider(this,parksViewModelFactory)[ParksViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parks, container, false)
    }

    companion object {
        fun newInstance() = ParksFragment()
    }

    override fun onParkClicked(data: Data) {
        parksViewModel.selectedPark.postValue(data)

    }

}