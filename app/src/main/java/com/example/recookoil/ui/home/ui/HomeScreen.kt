package com.example.recookoil.ui.home.ui

import androidx.annotation.DrawableRes
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.recookoil.R
import com.example.recookoil.ui.profile.UserViewModel
import com.example.recookoil.ui.theme.*
import org.checkerframework.checker.units.qual.m


@Composable
fun HomeScreen(viewModel: UserViewModel){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Primary)
        ){
        Column(modifier = Modifier) {
            CardData(viewModel,Modifier.align(Alignment.CenterHorizontally))
            BodyData()
        }

    }
}

@Composable
fun CardData( viewModel: UserViewModel, modifier: Modifier = Modifier) {

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
        ProfileImage({},Modifier.align(Alignment.CenterVertically))
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
        fontSize = 22.sp,
        color = White,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ProfileImage(onProfileImage: () -> Unit, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.generic_profile),
        contentDescription = "Image profile",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(80.dp)
            .border(3.dp, MaterialTheme.colors.secondary, CircleShape)
            .clip(CircleShape)
            .clickable { onProfileImage }
    )
}

@Composable
fun BodyData(modifier: Modifier = Modifier){
    Surface(
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(0.dp,0.dp,0.dp,50.dp)

        ) {
            Row{
                CardInformation("Historial de recolección", R.drawable.ic_stats_70,{})
                CardInformation("IOT", R.drawable.ic_iot_70,{})
            }
            Row{
                CardInformation("Mensajes", R.drawable.ic_message_70,{})
                CardInformation("Nivel ACU", R.drawable.ic_level_70,{})
            }

        }
    }
}

@Composable
fun CardInformation(
    title: String,
    @DrawableRes image: Int,
    onCardSelected: () -> Unit,
    modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .size(150.dp, 160.dp)
            .padding(10.dp)
            .clickable { onCardSelected() },
        elevation = 5.dp

    ) {
        Column(modifier = modifier.padding(4.dp)) {
            Text(
                text = title,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .size(150.dp, 40.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(4.dp))
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .size(80.dp, 80.dp)
            )
        }

    }
}

@Preview
@Composable
fun BodyDataPreview(){
    ReCookOilTheme {
        BodyData()
    }
}

