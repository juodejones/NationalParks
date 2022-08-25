package com.jones.nationalparks.ui.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jones.nationalparks.domain.GetParksUseCase

class MapsViewModelFactory(
    val app: Application,
    val getParksUseCase: GetParksUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MapsViewModel(app,getParksUseCase) as T
    }
}