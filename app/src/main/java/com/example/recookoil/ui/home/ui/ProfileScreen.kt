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
import com.example.recookoil.ui.theme.DarkGray
import com.example.recookoil.ui.theme.PrimaryDark
import com.example.recookoil.ui.theme.PrimaryDisable
import com.example.recookoil.ui.theme.Secondary
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase



@Composable
fun ProfileScreen(context: Context){
    Box(modifier = Modifier
        .fillMaxSize()
    ){

        val user = Firebase.auth.currentUser!!.uid
        val dataUser = FirebaseDatabase.getInstance().reference.child("Users").child(user).get()
        var name = ""
        var lastname = ""
        var identification = ""
        var phoneNumber = ""
        var address = ""
        var email = ""

        dataUser.addOnCompleteListener { data ->
            name = data.result.child("Name").value.toString()
            lastname = data.result.child("Lastname").value.toString()
            identification = data.result.child("Identification").value.toString()
            phoneNumber = data.result.child("PhoneNumber").value.toString()
            address = data.result.child("Address").value.toString()
            email = data.result.child("Email").value.toString()

        }

//        val postListener = object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                if(dataSnapshot.exists()){
//                     name = dataSnapshot.child("Name").value.toString()
//                     lastname = dataSnapshot.child("Lastname").value.toString()
//                     identification = dataSnapshot.child("Identification").value.toString()
//                     phoneNumber = dataSnapshot.child("PhoneNumber").value.toString()
//                     address = dataSnapshot.child("Address").value.toString()
//                     email = dataSnapshot.child("email").value.toString()
//
//                }
//            }
//            override fun onCancelled(databaseError: DatabaseError) {
//                Toast.makeText(context, "Algo salio mal...", Toast.LENGTH_SHORT).show()
//            }
//        }

        //dataUser.addValueEventListener(postListener)

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
        fontSize = 20.sp,
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
        fontSize = 18.sp,
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