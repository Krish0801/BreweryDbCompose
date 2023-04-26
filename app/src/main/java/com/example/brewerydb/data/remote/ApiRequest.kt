package com.example.brewerydb.data.remote

import com.example.brewerydb.data.model.BreweryItem
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequest {

    @GET(ApiDetails.END_POINT)
    suspend fun getBrewery() : List<BreweryItem>

    @GET(ApiDetails.BREWERY_ID)
    suspend fun getBreweryItem(@Path("id") id: String) : BreweryItem


}