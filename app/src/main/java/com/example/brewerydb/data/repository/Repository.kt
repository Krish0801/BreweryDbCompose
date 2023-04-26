package com.example.brewerydb.data.repository

import com.example.brewerydb.data.model.BreweryItem

interface Repository {

    suspend fun getBrewery(): List<BreweryItem>
    suspend fun getBreweryItem(id : String): BreweryItem

}