package com.example.recookoil.ui.login.ui.signup

import android.content.Context
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
import androidx.compose.ui.unit.dp
import com.example.recookoil.R
import com.example.recookoil.ui.theme.*


@Composable
fun NameIdentificationScreen(
    viewModel: SignupViewModel,
    context: Context,
    navigateAddressPhone: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        NameIdentification(modifier = Modifier, viewModel = viewModel, context, navigateAddressPhone)
    }
}

@Composable
fun NameIdentification(modifier: Modifier, viewModel: SignupViewModel, context: Context, navigateAddressPhone: () -> Unit){
    val name: String by viewModel.name.observeAsState("")
    val lastName: String by viewModel.lastName.observeAsState("")
    val identification: String by viewModel.identification.observeAsState("")
    val nameIdentificationOK: Boolean by viewModel.nameIdentificationOK.observeAsState(false)
    Column(modifier = Modifier) {
        HeaderImageNameIdentification(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(8.dp))
        NameField(name = name){
            viewModel.onNameIdentificationChanged(it,lastName,identification)
        }
        Spacer(modifier = Modifier.padding(4.dp))
        LastNameField(lastName = lastName){
            viewModel.onNameIdentificationChanged(name,it, identification)
        }
        Spacer(modifier = Modifier.padding(4.dp))
        IdentificationField(identification = identification){
            viewModel.onNameIdentificationChanged(name,lastName, it)
        }
        Spacer(modifier = Modifier.padding(12.dp))
        OnNameIdentificationButton(nameIdentificationOK){
            //TODO implementación para navegar a la proxima ventana
            navigateAddressPhone()
        }
    }
}


@Composable
fun HeaderImageNameIdentification(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_header),
        contentDescription = "Header image",
        modifier = modifier
    )
}

@Composable
fun NameField(name: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(value = name,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Nombres") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        label = { Text("Nombres") }
    )
}


@Composable
fun LastNameField(lastName: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(value = lastName,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Apellidos") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        label = { Text("Apellidos") }
    )
}


@Composable
fun IdentificationField(identification: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(value = identification,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Número de identificación (C.C)") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        label = { Text("Número de identificación (C.C)") }
    )
}

@Composable
fun OnNameIdentificationButton(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() }, modifier = Modifier
            .fillMaxWidth()
            .height(48.dp), colors = ButtonDefaults.buttonColors(
            backgroundColor = Primary, disabledBackgroundColor = PrimaryDisable, contentColor = Color.White, disabledContentColor = Color.White
        ),
        enabled = loginEnable
    ) {
        Text(text = "Siguiente")
    }
}