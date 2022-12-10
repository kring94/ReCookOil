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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.recookoil.R
import com.example.recookoil.ui.menu.MenuDestination.*
import com.example.recookoil.ui.menu.modules.ModuleDestination
import com.example.recookoil.ui.profile.UserViewModel
import com.example.recookoil.ui.theme.*


@Composable
fun HomeScreen(navHostController: NavHostController, viewModel: UserViewModel){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Primary)
        ){
        Column(modifier = Modifier) {
            CardData(navHostController,viewModel,Modifier.align(Alignment.CenterHorizontally))
            BodyData(navHostController)

        }

    }
}

@Composable
fun CardData(
    navHostController: NavHostController,
    viewModel: UserViewModel,
    modifier: Modifier = Modifier
) {

    //Recuperación de información de Firestore por medio de viewModel
    val dataUser = viewModel.state.value.user

    val fullName = "${dataUser.name} ${dataUser.lastname}"
    val setPoints = "Puntos: ${dataUser.points}"

    //Navegación
    val ruteProfile = ProfileScreen.route

    Row(
        modifier
            .size(width = 400.dp, height = 200.dp)
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
        ProfileImage({
            navHostController.navigate(ruteProfile)
        },Modifier.align(Alignment.CenterVertically))
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
            .clickable { onProfileImage() }
    )
}

@Composable
fun BodyData(navHostController: NavHostController,modifier: Modifier = Modifier){

    val ruteChat = ModuleDestination.ChatScreen.route
    val ruteIot = ModuleDestination.IotScreen.route
    val ruteHistory = ModuleDestination.HistoryScreen.route
    val ruteLevelAcu = ModuleDestination.AcuLevelScreen.route

    Surface(
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(0.dp,0.dp,0.dp,80.dp)

        ) {
            Row{
                CardInformation("Historial de recolección", R.drawable.ic_stats_70,{navHostController.navigate(ruteHistory)})
                CardInformation("IOT", R.drawable.ic_iot_70,{navHostController.navigate(ruteIot)})
            }
            Row{
                CardInformation("Chat", R.drawable.ic_message_70,{navHostController.navigate(ruteChat)})
                CardInformation("Nivel ACU", R.drawable.ic_level_70,{navHostController.navigate(ruteLevelAcu)})
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



