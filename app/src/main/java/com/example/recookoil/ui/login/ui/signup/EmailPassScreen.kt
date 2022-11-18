package com.example.recookoil.ui.login.ui.signup

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.recookoil.AuthActivity
import com.example.recookoil.R
import com.example.recookoil.Signup3Activity
import com.example.recookoil.ui.theme.Primary
import com.example.recookoil.ui.theme.PrimaryDisable

@Composable
fun EmailPassScreen(viewModel: SignupViewModel, context: Context){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        EmailPass(modifier = Modifier.align(Alignment.Center), viewModel = viewModel, context)
    }
}

@Composable
fun EmailPass(modifier: Modifier, viewModel: SignupViewModel, context: Context){
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val emailPassOK: Boolean by viewModel.emailPassOK.observeAsState(initial = false)

    Column(modifier = Modifier) {
        HeaderImage(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(12.dp))
        EmailField(email) {
            viewModel.onEmailPassChanged(
                it,
                password
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordField(password) {
            viewModel.onEmailPassChanged(
                email,
                it
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        OnEmailPassButton(emailPassOK = emailPassOK) {
            //TODO implementación para navegar a la proxima ventana
            context.startActivity(Intent(context, AuthActivity::class.java))
        }
    }
}

@Composable
fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(value = email,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        label = { Text("Email") }
    )
}

@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(value = password,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        label = { Text("Contraseña") },
        visualTransformation = PasswordVisualTransformation(),
    )
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_header),
        contentDescription = "Header image",
        modifier = modifier
    )
}

@Composable
fun OnEmailPassButton(emailPassOK: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() }, modifier = Modifier
            .fillMaxWidth()
            .height(48.dp), colors = ButtonDefaults.buttonColors(
            backgroundColor = Primary, disabledBackgroundColor = PrimaryDisable, contentColor = Color.White, disabledContentColor = Color.White
        ),
        enabled = emailPassOK
    ) {
        Text(text = "Finalizar")
    }
}