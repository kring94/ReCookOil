package com.example.recookoil.ui.home.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.recookoil.R
import com.example.recookoil.ui.profile.UserViewModel
import com.example.recookoil.ui.theme.*


@Composable
fun HomeScreen(viewModel: UserViewModel){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Primary)
        ){
        Column(modifier = Modifier) {
            CardData(Modifier.align(Alignment.CenterHorizontally), viewModel)
            BodyData()
        }

    }
}

@Composable
fun CardData(modifier: Modifier, viewModel: UserViewModel) {
    val dataUser = viewModel.state.value.user

    val fullName = "${dataUser.name} ${dataUser.lastname}"
    val setPoints = "Puntos: ${dataUser.points}"

    Row(
        modifier
            .size(width = 400.dp, height = 150.dp)
            .padding(8.dp)

    ) {
        Column(modifier = modifier
            .padding(4.dp)
            .weight(0.7F, true)
            ) {
            NameText(fullName, Modifier.align(Alignment.Start))
            Spacer(modifier = Modifier.padding(4.dp))
            PointsText(setPoints, Modifier.align(Alignment.Start))
        }
        Spacer(modifier = Modifier.width(4.dp))
        ProfileImage(Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
fun BodyData(){
    Card(
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
    ) {
        Column(modifier = Modifier
            .fillMaxSize()) {
        }
    }
}

@Composable
fun PointsText(points: String, modifier: Modifier = Modifier) {
    Text(
        text = points,
        fontSize = 18.sp,
        color = DarkGray,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun NameText(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        fontSize = 26.sp,
        color = White,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ProfileImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.generic_profile),
        contentDescription = "Image profile",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(80.dp)
            .border(3.dp, MaterialTheme.colors.secondary, CircleShape)
            .clip(CircleShape)
    )
}

