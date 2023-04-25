package com.example.brewerydb.ui.breweryDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brewerydb.data.model.BreweryItem
import com.example.brewerydb.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreweryDetailViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    val breweryDetail = MutableStateFlow(ArrayList<BreweryItem>(emptyList()))


    fun updateBreweryItem(breweryId: String) {
        viewModelScope.launch {
            breweryDetail.value = repository.getBrewery1(breweryId)
        }
    }

}