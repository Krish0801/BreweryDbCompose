package com.example.brewerydb.ui.brewery

import com.example.brewerydb.data.model.BreweryItem
import com.example.brewerydb.data.repository.Repository

class FakeRepository : Repository {

    private val brewery = mutableListOf<BreweryItem>()


    override suspend fun getBrewery(): List<BreweryItem> {
        return brewery.toList()
    }

    override suspend fun getBreweryItem(id: String): BreweryItem {
        return brewery.find { it.id == id } ?: BreweryItem()
    }


    fun clearBrewery() {
        brewery.clear()
    }
}


