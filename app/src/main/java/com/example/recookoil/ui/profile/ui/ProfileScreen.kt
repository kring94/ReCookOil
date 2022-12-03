package com.example.recookoil.ui.profile.ui

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recookoil.AuthActivity
import com.example.recookoil.ui.profile.UserViewModel
import com.example.recookoil.ui.theme.DarkGray
import com.example.recookoil.ui.theme.PrimaryDark
import com.example.recookoil.ui.theme.PrimaryDisable
import com.example.recookoil.ui.theme.Secondary
import com.google.firebase.auth.FirebaseAuth


@Composable
fun ProfileScreen(viewModel: UserViewModel){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
    ){

        val context = LocalContext.current

        val dataUser = viewModel.state.value.user

        Column(modifier = Modifier) {
            titleProfile(modifier = Modifier.align(Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.padding(4.dp))
            titleData(modifier = Modifier, "Nombre")
            Spacer(modifier = Modifier.padding(4.dp))
            data(modifier = Modifier, data = dataUser.name)

            Spacer(modifier = Modifier.padding(4.dp))
            titleData(modifier = Modifier, "Apellido")
            Spacer(modifier = Modifier.padding(4.dp))
            data(modifier = Modifier, data = dataUser.lastname)

            Spacer(modifier = Modifier.padding(4.dp))
            titleData(modifier = Modifier, "Identificación")
            Spacer(modifier = Modifier.padding(4.dp))
            data(modifier = Modifier, data = dataUser.identification)

            Spacer(modifier = Modifier.padding(4.dp))
            titleData(modifier = Modifier, "Número de telefono")
            Spacer(modifier = Modifier.padding(4.dp))
            data(modifier = Modifier, data = dataUser.phoneNumber)

            Spacer(modifier = Modifier.padding(4.dp))
            titleData(modifier = Modifier, "Dirección")
            Spacer(modifier = Modifier.padding(4.dp))
            data(modifier = Modifier, data = dataUser.address)

            Spacer(modifier = Modifier.padding(4.dp))
            titleData(modifier = Modifier, "Correo Electrónico")
            Spacer(modifier = Modifier.padding(4.dp))
            data(modifier = Modifier, data = dataUser.email)

            Spacer(modifier = Modifier.padding(16.dp))
            LogoutButton {
                FirebaseAuth.getInstance().signOut()
                val navigate = Intent(context, AuthActivity::class.java)
                context.startActivity(navigate)
            }
        }
    }
}


@Composable
fun titleProfile(modifier: Modifier){
    Text(
        modifier = modifier
            .padding(4.dp),
        text = "Datos de usuario",
        fontSize = 24.sp,
        color = PrimaryDark,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun titleData(modifier: Modifier, dataTitle: String){
    Text(
        modifier = modifier
            .padding(4.dp),
        text = dataTitle,
        fontSize = 14.sp,
        color = PrimaryDark,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun data(modifier: Modifier, data: String){
    Text(
        modifier = modifier
            .padding(4.dp),
        text = data,
        fontSize = 20.sp,
        color = DarkGray,
    )
}

@Composable
fun LogoutButton(onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() }, modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(48.dp), colors = ButtonDefaults.buttonColors(
            backgroundColor = Secondary, disabledBackgroundColor = PrimaryDisable, contentColor = Color.White, disabledContentColor = Color.White
        )
    ) {
        Text(text = "Cerrar Sesión")
    }
}