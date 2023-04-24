package com.example.brewerydb.ui.breweryDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brewerydb.data.model.BreweryItem
import com.example.brewerydb.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreweryDetailViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    val _selectedBreweryItem = MutableStateFlow(ArrayList<BreweryItem>(emptyList()))
    var selectedBreweryItem : StateFlow<ArrayList<BreweryItem>> = _selectedBreweryItem

    fun updateBreweryItem(breweryId: Long) {
        viewModelScope.launch {
            _selectedBreweryItem.value = repository.getBreweryDetail(breweryId)
        }
    }

}