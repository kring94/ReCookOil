package com.example.recookoil.ui.home.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recookoil.ui.theme.Secondary
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import com.example.recookoil.R
import com.example.recookoil.ui.theme.PrimaryDark


@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        ){
        PersonalProfile(Modifier)
    }
}

@Composable
fun PersonalProfile(modifier: Modifier) {
    Row(
        Modifier
            .size(width = 400.dp, height = 150.dp)
            .background(Secondary)) {
        ProfileImage()
        Column(modifier = modifier.fillMaxSize()) {
            NameText(Modifier.align(Alignment.Start))
            Spacer(modifier = Modifier.padding(8.dp))
            PointsText(Modifier.align(Alignment.Start))
        }
    }
}

@Composable
fun PointsText(align: Modifier) {
    TODO("Not yet implemented")
}

@Composable
fun NameText(align: Modifier) {
    TODO("Not yet implemented")
}

@Composable
fun ProfileImage() {
    val borderWidth = 4.dp
    Image(
        painter = painterResource(id = R.drawable.logo_header),
        contentDescription = "Image profile",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp)
            .border(
                BorderStroke(borderWidth, PrimaryDark),
                CircleShape
            )
            .padding(borderWidth)
            .clip(CircleShape)
    )
}
