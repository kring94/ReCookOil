package com.example.recookoil.ui.chat

import com.example.recookoil.model.Message

data class ChatListState(
    val isLoading: Boolean = false,
    val chats: List<Message> = emptyList(),
    val error: String = ""
)
