package com.example.brewerydb.ui.breweryDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.brewerydb.data.model.BreweryItem

@Composable
fun BreweryDetailScreen(
    breweryId: String
) {
    val breweryDetailModel = hiltViewModel<BreweryDetailViewModel>()
    val breweryDetails by breweryDetailModel.breweryDetail.collectAsState()

    breweryDetailModel.updateBreweryItem(breweryId)

    BreweryDetailPage(breweryDetails = breweryDetails)
}

@Composable
fun BreweryDetailPage(breweryDetails: BreweryItem) {


    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color(0xFFC1D6F8))
            .padding(16.dp)
    ) {
        Text(
            text = breweryDetails.name ?: "N/A",
            color = Color(0xFFC1D6F8),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(0xFF22324C))
                .clip(RoundedCornerShape(8.dp))
                .padding(8.dp)
        )
        Text(
            text = breweryDetails.id.toString(),
            color = Color(0xFF22324C),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 34.dp)

        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            shape = RoundedCornerShape(0.dp),
            elevation = 8.dp,
            backgroundColor = Color(0xFF85ADEF),
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Address",
                        color = Color(0xFFC1D6F8),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 0.dp, bottom = 8.dp)
                            .height(50.dp)
                            .background(Color(0xFF22324C))
                            .clip(RoundedCornerShape(8.dp))
                            .padding(start = 16.dp)
                    )
                    Text(
                        text = breweryDetails.address1  ?: "N/A",
                        color = Color(0xFFC1D6F8),
                        fontSize = 20.sp,
                        modifier = Modifier.weight(1f)
                            .padding(bottom = 8.dp)
                            .height(50.dp)
                            .background(Color(0xFF22324C))
                            .clip(RoundedCornerShape(8.dp)),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "City",
                        color = Color(0xFFC1D6F8),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 0.dp,bottom = 8.dp)
                            .height(50.dp)
                            .background(Color(0xFF22324C))
                            .clip(RoundedCornerShape(8.dp))
                            .padding(start = 16.dp)

                    )
                        Text(
                            text = breweryDetails.city  ?: "N/A",
                            color = Color(0xFFC1D6F8),
                            fontSize = 20.sp,
                            modifier = Modifier.weight(1f)
                                .padding(bottom = 8.dp)
                                .height(50.dp)
                                .background(Color(0xFF22324C))
                                .clip(RoundedCornerShape(8.dp)),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "State",
                            color = Color(0xFFC1D6F8),
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 0.dp,bottom = 8.dp)
                                .height(50.dp)
                                .background(Color(0xFF22324C))
                                .clip(RoundedCornerShape(8.dp))
                                .padding(start = 16.dp)
                        )
                        Text(
                            text = breweryDetails.state  ?: "N/A",
                            color = Color(0xFFC1D6F8),
                            fontSize = 20.sp,
                            modifier = Modifier.weight(1f)
                                .padding(bottom = 8.dp)
                                .height(50.dp)
                                .background(Color(0xFF22324C))
                                .clip(RoundedCornerShape(8.dp)),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Postcode",
                        color = Color(0xFFC1D6F8),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 0.dp)
                            .height(50.dp)
                            .background(Color(0xFF22324C))
                            .clip(RoundedCornerShape(8.dp))
                            .padding(start = 16.dp)
                    )
                    Text(
                        text = breweryDetails.postalCode  ?: "N/A",
                        color = Color(0xFFC1D6F8),
                        fontSize = 20.sp,
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                            .background(Color(0xFF22324C))
                            .clip(RoundedCornerShape(8.dp)),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
                }
            }
        }
    }


