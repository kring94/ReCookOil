package com.example.recookoil.ui.signin.ui

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
import com.example.recookoil.ui.signin.SignupViewModel
import com.example.recookoil.ui.theme.Primary
import com.example.recookoil.ui.theme.PrimaryDisable

@Composable
fun AddressPhoneScreen(viewModel: SignupViewModel,
                       navigateEmailPassScreen: () -> Unit){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        AddressPhone(viewModel = viewModel, navigateEmailPassScreen, modifier = Modifier)
    }
}


@Composable
fun AddressPhone(viewModel: SignupViewModel, navigateEmailPassScreen: () -> Unit, modifier: Modifier = Modifier){
    val address: String by viewModel.address.observeAsState("")
    val phoneNumber: String by viewModel.phoneNumber.observeAsState("")
    val addressPhoneOK: Boolean by viewModel.addressPhoneOK.observeAsState(false)

    Column(modifier = Modifier) {
        HeaderAddressPhoneImage(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(12.dp))
        PhoneNumberField(phoneNumber = phoneNumber){
            viewModel.onAddressPhoneChanged(it, address)
        }
        Spacer(modifier = Modifier.padding(4.dp))
        AddressField(address = address){
            viewModel.onAddressPhoneChanged(phoneNumber, it)
        }
        Spacer(modifier = Modifier.padding(16.dp))
        OnAddressPhoneButton(signupEnable = addressPhoneOK) {

            //TODO implementación para navegar a la proxima ventana
            navigateEmailPassScreen()
        }
    }
}


@Composable
fun HeaderAddressPhoneImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_header),
        contentDescription = "Header image",
        modifier = modifier
    )
}

@Composable
fun PhoneNumberField(phoneNumber: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(value = phoneNumber,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Número celular") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        label = { Text("Número celular") }
    )
}

@Composable
fun AddressField(address: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(value = address,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Dirección") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        label = { Text("Dirección") }
    )
}

@Composable
fun OnAddressPhoneButton(signupEnable: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() }, modifier = Modifier
            .fillMaxWidth()
            .height(48.dp), colors = ButtonDefaults.buttonColors(
            backgroundColor = Primary, disabledBackgroundColor = PrimaryDisable, contentColor = Color.White, disabledContentColor = Color.White
        ),
        enabled = signupEnable
    ) {
        Text(text = "Siguiente")
    }
}