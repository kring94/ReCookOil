package com.example.recookoil.ui.login.ui

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recookoil.HomeActivity
import com.example.recookoil.R
import com.example.recookoil.SignupActivity
import com.example.recookoil.ui.theme.*
import com.google.firebase.auth.FirebaseAuth


@Composable
fun LoginScreen(viewModel: LoginViewModel, context: Context) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Login(Modifier.align(Alignment.Center), viewModel, context)
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel, context: Context) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)

    if (isLoading) {
        Box(Modifier.fillMaxSize()) {

        }
    } else {
        Column(modifier = modifier) {
            HeaderImage(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(12.dp))
            EmailField(email) { viewModel.onLoginChanged(it, password) }
            Spacer(modifier = Modifier.padding(4.dp))
            PasswordField(password) { viewModel.onLoginChanged(email, it) }
            Spacer(modifier = Modifier.padding(8.dp))
            ForgotPassword(Modifier.align(Alignment.End))
            Spacer(modifier = Modifier.padding(12.dp))
            LoginButton(loginEnable) {
                //LogIn with FireBase
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(context, "Login exitoso!!", Toast.LENGTH_SHORT).show()
                        val navigate = Intent(context,HomeActivity::class.java)
                        context.startActivity(navigate)
                    } else {
                        Toast.makeText(context, "Login no exitoso!!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            Spacer(modifier = Modifier.padding(4.dp))
            SignUp(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                context.startActivity(Intent(context, SignupActivity::class.java))
            }
        }
    }

}

@Composable
fun SignUp(modifier: Modifier, onLoginSelected: () -> Unit) {
    Text(
        text = "Registrarse",
        modifier = modifier.clickable(onClick =  { onLoginSelected() }),
        fontSize = 16.sp,
        color = PrimaryDark
    )
}

@Composable
fun LoginButton(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() }, modifier = Modifier
            .fillMaxWidth()
            .height(48.dp), colors = ButtonDefaults.buttonColors(
            backgroundColor = Primary, disabledBackgroundColor = PrimaryDisable, contentColor = Color.White, disabledContentColor = Color.White
        ),
        enabled = loginEnable
    ) {
        Text(text = "Iniciar sesión")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Olvidaste la contraseña?",
        modifier = modifier.clickable { },
        fontSize = 12.sp,
        color = SecondaryDark
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
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_header),
        contentDescription = "Header image",
        modifier = modifier
    )
}

