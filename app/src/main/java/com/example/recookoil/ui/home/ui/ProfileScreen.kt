package com.example.recookoil.ui.home.ui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recookoil.AuthActivity
import com.example.recookoil.ui.home.HomeViewModel
import com.example.recookoil.ui.home.UserViewModel
import com.example.recookoil.ui.login.ui.signup.SignupViewModel
import com.example.recookoil.ui.theme.DarkGray
import com.example.recookoil.ui.theme.PrimaryDark
import com.example.recookoil.ui.theme.PrimaryDisable
import com.example.recookoil.ui.theme.Secondary
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun ProfileScreen(context: Context, viewModel: UserViewModel){
    Box(modifier = Modifier
        .fillMaxSize()
    ){


//        val user = Firebase.auth.currentUser!!.uid
//        val state = viewModel.state.value
//        val userRetriever = state.user
//        viewModel.getUser(user)

        val name = viewModel.name.value ?: ""
        val lastname = viewModel.lastName.value ?: ""
        val identification = viewModel.identification.value ?: ""
        val phoneNumber = viewModel.phoneNumber.value ?: ""
        val address = viewModel.address.value ?: ""
        val email = viewModel.email.value ?: ""




        Column(modifier = Modifier) {
            titleProfile(modifier = Modifier.align(Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.padding(4.dp))
            titleData(modifier = Modifier, "Nombre")
            Spacer(modifier = Modifier.padding(4.dp))
            data(modifier = Modifier, data = name)

            Spacer(modifier = Modifier.padding(4.dp))
            titleData(modifier = Modifier, "Apellido")
            Spacer(modifier = Modifier.padding(4.dp))
            data(modifier = Modifier, data = lastname)

            Spacer(modifier = Modifier.padding(4.dp))
            titleData(modifier = Modifier, "Identificación")
            Spacer(modifier = Modifier.padding(4.dp))
            data(modifier = Modifier, data = identification)

            Spacer(modifier = Modifier.padding(4.dp))
            titleData(modifier = Modifier, "Número de telefono")
            Spacer(modifier = Modifier.padding(4.dp))
            data(modifier = Modifier, data = phoneNumber)

            Spacer(modifier = Modifier.padding(4.dp))
            titleData(modifier = Modifier, "Dirección")
            Spacer(modifier = Modifier.padding(4.dp))
            data(modifier = Modifier, data = address)

            Spacer(modifier = Modifier.padding(4.dp))
            titleData(modifier = Modifier, "Correo Electrónico")
            Spacer(modifier = Modifier.padding(4.dp))
            data(modifier = Modifier, data = email)

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