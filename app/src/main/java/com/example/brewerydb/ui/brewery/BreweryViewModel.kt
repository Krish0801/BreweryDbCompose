package com.example.brewerydb.ui.brewery

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
class BreweryViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {

    val _brewery = MutableStateFlow(ArrayList<BreweryItem>(emptyList()))
    var brewery : StateFlow<ArrayList<BreweryItem>> = _brewery

   init{

        viewModelScope.launch{
            _brewery.value= repository.getBrewery()
        }
    }

}