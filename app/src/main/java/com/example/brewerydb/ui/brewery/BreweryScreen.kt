package com.example.brewerydb.ui.brewery

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.brewerydb.data.model.BreweryItem
import com.example.brewerydb.navigation.Screen

@Composable
fun BreweryScreen(navController: NavController) {
    val viewModel = hiltViewModel<BreweryViewModel>()
    val breweryList by viewModel.brewery.collectAsState()

    val navigateToDetails: (String) -> Unit = { breweryId ->
        navController.navigate("${Screen.BreweryDetailScreen.route}/$breweryId")
    }

    BreweryPage(breweryList, navigateToDetails)
}

@Composable
private fun BreweryPage(
    breweryList: ArrayList<BreweryItem>,
    navigateToDetails: (String) -> Unit
) {
    val backgroundcolor = Color(0xFFC1D6F8)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundcolor) // Replace Color.White with your desired background color
    ) {
        ListBrewery(breweryList, navigateToDetails)
    }
}

@Composable
fun ListBrewery(
    breweryList: ArrayList<BreweryItem>,
    navigateToDetails: (String) -> Unit,
) {
    val listState = rememberLazyListState()
    val textColor = Color(0xFF22324C)
    val cardColor = Color(0xFF85ADEF)


    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxWidth()
    ) {
        itemsIndexed(breweryList) { index, brewery ->
            Card(
                shape = RoundedCornerShape(15.dp),
                elevation = 8.dp,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .clickable{
                        navigateToDetails(brewery.id!!)
                    }

            ) {
                Column(
                    modifier = Modifier
                        .background(color = cardColor)
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Brewery ID",
                        color = textColor,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text(
                        text = brewery.id.toString(),
                        color = textColor,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )

                    Text(
                        text = "Brewery Name",
                        color = textColor,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text(
                        text = brewery.name,
                        color = textColor,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )

                    Text(
                        text = "Brewery City",
                        color = textColor,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text(
                        text = brewery.city,
                        color = textColor,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}
