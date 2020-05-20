package dev.vikey89.retailers.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.vikey89.core.data.Retailer
import dev.vikey89.core.data.RetailersRepository
import javax.inject.Inject

class RetailerViewModel @Inject constructor(
    private val retailersRepository: RetailersRepository
) : ViewModel() {

    private val _retailers = MutableLiveData<List<Retailer>>()

    val observerRetailers: LiveData<List<Retailer>> = _retailers

    fun load() {
        _retailers.value = retailersRepository.getRetailers()
    }
}