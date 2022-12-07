package com.example.recookoil.ui.chat.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.recookoil.constants.FirebaseConstants.SENDER
import com.example.recookoil.model.Message
import com.example.recookoil.ui.chat.ChatViewModel
import com.example.recookoil.ui.menu.components.NavigationTopAppBar
import com.example.recookoil.ui.theme.Primary
import com.example.recookoil.ui.theme.Secondary
import com.example.recookoil.ui.theme.White

@Composable
fun ChatScreen(navHostController: NavHostController, viewModel: ChatViewModel) {
    Scaffold (
        bottomBar = {},
        topBar = {
            TopAppBar() {
                NavigationTopAppBar(navHostController = navHostController, "Mensajes")
            }
        }
            ){
        ChatBody(viewModel)
    }
}

@Composable
fun ChatBody(viewModel: ChatViewModel, modifier: Modifier = Modifier){
    val message: String by viewModel.message.observeAsState(initial = "")
    val state = viewModel.state.value
    val listMessages = state.chats.sortedBy { it.date }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)){
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            BodyListMessages(listMessages, modifier = Modifier.weight(8.0f))
            Row(
                modifier = Modifier.weight(3.0f).heightIn(70.dp)
            ) {
                LabelMessage(message){
                    viewModel.onMessageChanged(it)
                }
                Spacer(modifier = Modifier.padding(12.dp).align(Alignment.CenterVertically))
                FabSendMessage(modifier = Modifier.align(Alignment.CenterVertically)){
                    viewModel.sendMessage(message)
                    viewModel.onMessageChanged("")
                }
            }
        }

    }
}

@Composable
fun BodyListMessages(
    messages: List<Message>,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier
    ) {
        items(items = messages){ message ->
            if(message.sender == SENDER){
                UserBubble(message = message.message, date = message.date.toString())
            }else {
                NoUserBubble(message = message.message, date = message.date.toString())
            }
        }
    }
}

@Composable
fun UserBubble(message: String, date: String,modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = message,
            textAlign = TextAlign.Start,
            softWrap = true,
            color = White,
            modifier = modifier
                .background(Secondary, shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 10.dp))
                .padding(6.dp)
                .align(Alignment.End)
        )
        Text(
            text = date,
            textAlign = TextAlign.End,
            modifier = modifier
                .align(Alignment.End),
            fontSize = 8.sp
        )
        Spacer(modifier = Modifier.padding(4.dp))
    }
}

@Composable
fun NoUserBubble(message: String, date: String,modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = message,
            textAlign = TextAlign.End,
            softWrap = true,
            color = White,
            modifier = modifier
                .background(Primary, shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 0.dp))
                .padding(6.dp)
                .align(Alignment.Start)
        )
        Text(
            text = date,
            textAlign = TextAlign.Start,
            modifier = modifier
                .align(Alignment.Start),
            fontSize = 8.sp
        )
        Spacer(modifier = Modifier.padding(4.dp))
    }
}

@Composable
fun LabelMessage(message: String, modifier: Modifier = Modifier, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(
        value = message,
        onValueChange = {onTextFieldChanged(it)},
        maxLines = 5,
        label = {Text("Message")},
        modifier = Modifier
            .width(290.dp)
    )
}

@Composable
fun FabSendMessage(modifier: Modifier = Modifier, sendMessage: () -> Unit) {
    FloatingActionButton(
        onClick = { sendMessage() },
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

//@Composable
//fun SetSendMessage(modifier: Modifier = Modifier) {
//    Row {
//        LabelMessage()
//        Spacer(modifier = Modifier.padding(8.dp))
//        FabSendMessage()
//    }
//}

// Previsualizaciones

//@Preview(showBackground = true, widthDp = 300, heightDp = 60 )
//@Composable
//fun UserBubblePreview() {
//    ReCookOilTheme {
//        UserBubble()
//    }
//}
//
//
//@Preview(showBackground = true, widthDp = 300, heightDp = 60 )
//@Composable
//fun NoUserBubblePreview() {
//    ReCookOilTheme {
//        NoUserBubble()
//    }
//}

//@Preview(showBackground = true, widthDp = 300, heightDp = 60 )
//@Composable
//fun LabelMessagePreview() {
//    ReCookOilTheme {
//        LabelMessage()
//    }
//}


//@Preview(showBackground = true, widthDp = 100, heightDp = 100 )
//@Composable
//fun FabSendMessagePreview() {
//    ReCookOilTheme {
//        FabSendMessage()
//    }
//}



//@Preview(showBackground = true)
//@Composable
//fun SetSendMessagePreview(modifier: Modifier = Modifier) {
//    ReCookOilTheme {
//        SetSendMessage()
//    }
//}
