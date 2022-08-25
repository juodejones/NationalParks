package com.jones.nationalparks.ui.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jones.nationalparks.data.model.Data
import com.jones.nationalparks.data.model.ParksData
import com.jones.nationalparks.data.utils.Resource
import com.jones.nationalparks.domain.GetParksUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MapsViewModel(val app: Application, val getParksUseCase: GetParksUseCase) : ViewModel() {

    val parksData: MutableLiveData<Resource<ParksData>> = MutableLiveData()
    var selectedPark = MutableLiveData<Data>()

    fun getParks() = viewModelScope.launch(Dispatchers.IO) {
        parksData.postValue(getParksUseCase.getParks())
    }
}