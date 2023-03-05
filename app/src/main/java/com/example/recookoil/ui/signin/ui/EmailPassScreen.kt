package com.example.recookoil.ui.signin.ui

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.recookoil.AuthActivity
import com.example.recookoil.R
import com.example.recookoil.ui.login.ui.EmailField
import com.example.recookoil.ui.login.ui.HeaderImage
import com.example.recookoil.ui.signin.SignupViewModel
import com.example.recookoil.ui.theme.Primary
import com.example.recookoil.ui.theme.PrimaryDisable
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

@Composable
fun EmailPassScreen(viewModel: SignupViewModel){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        EmailPass(viewModel = viewModel,modifier = Modifier.align(Alignment.Center))
        Log.d("Name", viewModel.name.value.toString())
    }
}

@Composable
fun EmailPass(viewModel: SignupViewModel, modifier: Modifier = Modifier){

    val context = LocalContext.current

    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val passwordConfirmation: String by viewModel.passwordConfirmation.observeAsState(initial = "")
    val emailPassOK: Boolean by viewModel.emailPassOK.observeAsState(initial = false)

    Column(modifier = Modifier) {
        HeaderImage(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(12.dp))
        EmailField(email) {
            viewModel.onEmailPassChanged(
                it,
                password,
                passwordConfirmation
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordField(password,"Contraseña") {
            viewModel.onEmailPassChanged(
                email,
                it,
                passwordConfirmation
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordField(passwordConfirmation,"Confirmar contraseña") {
            viewModel.onEmailPassChanged(
                email,
                password,
                it
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        OnEmailPassButton(emailPassOK = emailPassOK) {

            //TODO implementación para navegar a la proxima ventana
            val name = viewModel.name.value.toString()
            val lastname = viewModel.lastName.value.toString()
            val identification = viewModel.identification.value.toString()
            val phoneNumber = viewModel.phoneNumber.value.toString()
            val address = viewModel.address.value.toString()

            viewModel.onSignin(email, password).addOnCompleteListener {
                if(it.isSuccessful){
                    viewModel.apply {
                        addNewUser(
                            retrieveIdUser(),
                            name,
                            lastname,
                            identification,
                            address,
                            phoneNumber,
                            email,
                            0
                        )
                    }
                    Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    context.startActivity(Intent(context, AuthActivity::class.java))
                } else {
                    Toast.makeText(context, "Algo salio mal, vuelve a intentarlo...", Toast.LENGTH_SHORT).show()
                }
            }
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
fun PasswordField(password: String, labelText: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(value = password,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = labelText) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        label = { Text(labelText) },
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
fun OnEmailPassButton(emailPassOK: Boolean, onSignUp: () -> Unit) {
    Button(
        onClick = { onSignUp() }, modifier = Modifier
            .fillMaxWidth()
            .height(48.dp), colors = ButtonDefaults.buttonColors(
            backgroundColor = Primary, disabledBackgroundColor = PrimaryDisable, contentColor = Color.White, disabledContentColor = Color.White
        ),
        enabled = emailPassOK
    ) {
        Text(text = "Finalizar")
    }
}