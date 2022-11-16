package com.example.recookoil.ui.home.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recookoil.ui.theme.Secondary
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.recookoil.R
import com.example.recookoil.ui.theme.Gray
import com.example.recookoil.ui.theme.PrimaryDark
import com.example.recookoil.ui.theme.SecondaryDark


@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        ){
        PersonalProfile(Modifier)
    }
}

@Composable
fun PersonalProfile(modifier: Modifier) {
    Row(
        Modifier
            .size(width = 400.dp, height = 150.dp)
            .background(Gray)
            ) {
        Column(modifier = modifier
            .size(150.dp,150.dp)
        ) {
            ProfileImage()
        }
        Column(modifier = modifier
            .fillMaxSize()
            .padding(4.dp)) {
            NameText(Modifier.align(Alignment.Start))
            Spacer(modifier = Modifier.padding(8.dp))
            PointsText(Modifier.align(Alignment.Start))
        }
    }
}

@Composable
fun PointsText(align: Modifier) {
    Text(
        text = "Puntos:",
        fontSize = 14.sp,
        color = PrimaryDark,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun NameText(align: Modifier) {
    Text(
        text = "Nombre:",
        fontSize = 14.sp,
        color = Secondary,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ProfileImage() {
    val borderWidth = 4.dp
    Image(
        painter = painterResource(id = R.drawable.logo_header),
        contentDescription = "Image profile",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(100.dp)
            .border(
                BorderStroke(borderWidth, PrimaryDark),
                CircleShape
            )
            .padding(borderWidth)
            .clip(CircleShape)
    )
}
