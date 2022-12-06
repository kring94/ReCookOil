package com.example.recookoil.ui.chat.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.recookoil.ui.menu.components.NavigationTopAppBar
import com.example.recookoil.ui.theme.Primary
import com.example.recookoil.ui.theme.ReCookOilTheme
import com.example.recookoil.ui.theme.Secondary
import com.example.recookoil.ui.theme.White
import java.util.Date

@Composable
fun ChatScreen(navHostController: NavHostController) {
    Scaffold (
        bottomBar = {},
        topBar = {
            TopAppBar() {
                NavigationTopAppBar(navHostController = navHostController, "Mensajes")
            }
        }
            ){
        ChatBody()
    }
}

@Composable
fun ChatBody(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(4.dp)){
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            BodyListMessages(modifier = Modifier.weight(8.0f))
            Row(
                modifier = Modifier.weight(2.0f)
            ) {
                LabelMessage(modifier = Modifier.weight(6.0f))
                Spacer(modifier = Modifier.padding(8.dp))
                FabSendMessage(modifier = Modifier.weight(1.0f))
            }
        }

    }
}

@Composable
fun BodyListMessages(modifier: Modifier = Modifier){
    LazyColumn(
        modifier = modifier
    ) {
        item {
            UserBubble()
        }
        item {
            NoUserBubble()
        }
    }
}

@Composable
fun UserBubble(message: String = "Message User", date: String= Date().toString(),modifier: Modifier = Modifier) {
    Text(
        text = message,
        textAlign = TextAlign.Start,
        softWrap = true,
        color = White,
        modifier = modifier
            .background(Secondary, shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 10.dp))
            .padding(4.dp)
    )
    Text(
        text = date,
        textAlign = TextAlign.End,
        modifier = modifier,
        fontSize = 8.sp
    )
    Spacer(modifier = Modifier.padding(4.dp))
}

@Composable
fun NoUserBubble(message: String = "Message Oil", date: String = Date().toString(),modifier: Modifier = Modifier) {
    Text(
        text = message,
        textAlign = TextAlign.End,
        softWrap = true,
        color = White,
        modifier = modifier
            .background(Primary, shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 0.dp))
            .padding(4.dp)
    )
    Text(
        text = date,
        textAlign = TextAlign.Start,
        modifier = modifier,
        fontSize = 8.sp
    )
    Spacer(modifier = Modifier.padding(4.dp))
}

@Composable
fun LabelMessage(modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = {Text("Message")},
        modifier = Modifier
            .width(310.dp)
    )
}

@Composable
fun FabSendMessage(modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = {  },
        shape = RoundedCornerShape(30.dp,0.dp, 30.dp, 30.dp),
        modifier = Modifier
            .rotate(-135f)

    ) {
        Icon(
            imageVector = Icons.Default.Send,
            contentDescription = "Enviar mensaje",
            modifier = Modifier.rotate(135f)
        )
    }
}

@Composable
fun SetSendMessage(modifier: Modifier = Modifier) {
    Row {
        LabelMessage()
        Spacer(modifier = Modifier.padding(8.dp))
        FabSendMessage()
    }
}

// Previsualizaciones

@Preview(showBackground = true, widthDp = 300, heightDp = 60 )
@Composable
fun UserBubblePreview() {
    ReCookOilTheme {
        UserBubble()
    }
}


@Preview(showBackground = true, widthDp = 300, heightDp = 60 )
@Composable
fun NoUserBubblePreview() {
    ReCookOilTheme {
        NoUserBubble()
    }
}

@Preview(showBackground = true, widthDp = 300, heightDp = 60 )
@Composable
fun LabelMessagePreview() {
    ReCookOilTheme {
        LabelMessage()
    }
}


@Preview(showBackground = true, widthDp = 100, heightDp = 100 )
@Composable
fun FabSendMessagePreview() {
    ReCookOilTheme {
        FabSendMessage()
    }
}



@Preview(showBackground = true)
@Composable
fun SetSendMessagePreview(modifier: Modifier = Modifier) {
    ReCookOilTheme {
        SetSendMessage()
    }
}
