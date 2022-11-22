package com.example.recookoil.ui.home.ui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.recookoil.AuthActivity
import com.example.recookoil.R
import com.example.recookoil.ui.home.UserViewModel
import com.example.recookoil.ui.theme.*
import com.google.firebase.auth.FirebaseAuth


@Composable
fun HomeScreen(context: Context, viewModel: UserViewModel){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Primary)
        ){
        Column(modifier = Modifier) {
            CardData(Modifier.align(Alignment.CenterHorizontally), viewModel)
            BodyData(context)
        }

    }
}

@Composable
fun CardData(modifier: Modifier, viewModel: UserViewModel) {
    val fullName = "${viewModel.name.value ?: ""} ${viewModel.lastName.value ?: ""}"
    val points = viewModel.points.value ?: ""
    Row(
        modifier
            .size(width = 400.dp, height = 150.dp)
            .padding(8.dp)

    ) {
        Column(modifier = modifier
            .padding(4.dp)
            .weight(0.7F,true)) {
            NameText(Modifier.align(Alignment.Start), fullName)
            Spacer(modifier = Modifier.padding(4.dp))
            PointsText(Modifier.align(Alignment.Start), points)
        }
        Spacer(modifier = Modifier.width(4.dp))
        ProfileImage(Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
fun BodyData(context:Context){
    Card(
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(White)) {
//            LogoutButton() {
//                FirebaseAuth.getInstance().signOut()
//                val navigate = Intent(context, AuthActivity::class.java)
//                context.startActivity(navigate)
//            }
        }
    }
}

@Composable
fun PointsText(align: Modifier, points: String) {
    Text(
        text = "Puntos: $points",
        fontSize = 18.sp,
        color = White,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun NameText(align: Modifier, name: String) {
    Text(
        text = name,
        fontSize = 26.sp,
        color = White,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ProfileImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.profile_image),
        contentDescription = "Image profile",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(80.dp)
            .border(3.dp, MaterialTheme.colors.secondary, CircleShape)
            .clip(CircleShape)
    )
}

//@Composable
//fun LogoutButton(onLoginSelected: () -> Unit) {
//    Button(
//        onClick = { onLoginSelected() }, modifier = Modifier
//            .padding(10.dp)
//            .fillMaxWidth()
//            .height(48.dp), colors = ButtonDefaults.buttonColors(
//            backgroundColor = Secondary, disabledBackgroundColor = PrimaryDisable, contentColor = Color.White, disabledContentColor = Color.White
//        )
//    ) {
//        Text(text = "Cerrar Sesión")
//    }
//}
