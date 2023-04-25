package com.example.brewerydb.data.repository

import com.example.brewerydb.data.remote.ApiRequest
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    val apiRequest: ApiRequest
) : Repository{

    override suspend fun getBrewery() = apiRequest.getBrewery()
    override suspend fun getBrewery1(breweryId: Long) = apiRequest.getBrewery()



}