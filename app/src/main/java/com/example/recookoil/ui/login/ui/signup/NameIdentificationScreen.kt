package com.example.recookoil.ui.login.ui.signup

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.recookoil.R
import com.example.recookoil.ui.theme.Primary
import com.example.recookoil.ui.theme.PrimaryDisable

@Composable
fun NameIdentificationScreen(viewModel: SignupViewModel){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        NameIdentification(modifier = Modifier, viewModel = viewModel)
    }
}

@Composable
fun NameIdentification(modifier: Modifier, viewModel: SignupViewModel){
    val name: String by viewModel.name.observeAsState("")
    val secondName: String by viewModel.secondName.observeAsState("")
    val lastName: String by viewModel.lastName.observeAsState("")
    val secondLastName: String by viewModel.secondLastName.observeAsState("")
    val identification: String by viewModel.identification.observeAsState("")
    val nameIdentificationOK: Boolean by viewModel.nameIdentificationOK.observeAsState(false)
    Column(modifier = Modifier) {
        HeaderImageNameIdentification(modifier = Modifier)
        Spacer(modifier = Modifier.padding(12.dp))
        Row(modifier = Modifier) {
            NameField(name = name){
                viewModel.onNameIdentificationChanged(it,lastName,identification)
            }
            SecondNameField(second = secondName){
                viewModel.onNameIdentificationChanged(name,lastName, identification)
            }
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Row(modifier = Modifier) {
            LastNameField(lastName = lastName){
                viewModel.onNameIdentificationChanged(name,it, identification)
            }
            SecondLastNameField(second = secondLastName){
                viewModel.onNameIdentificationChanged(name,lastName, identification)
            }
        }
        Spacer(modifier = Modifier.padding(4.dp))
        IdentificationField(identification = identification){
            viewModel.onNameIdentificationChanged(name,lastName, it)
        }
        Spacer(modifier = Modifier.padding(4.dp))
        OnNameIdentificationButton(nameIdentificationOK){
            //TODO implementación para navegar a la proxima ventana
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
        placeholder = { Text(text = "Nombre") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        label = { Text("Nombre") }
    )
}

@Composable
fun SecondNameField(second: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(value = second,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Segundo nombre") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        label = { Text("Segundo nombre") }
    )
}

@Composable
fun LastNameField(lastName: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(value = lastName,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Apellido") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        label = { Text("Apellido") }
    )
}

@Composable
fun SecondLastNameField(second: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(value = second,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Segundo apellido") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        label = { Text("Segundo apellido") }
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