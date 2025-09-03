package com.chatapp.CHAT_APP_BACKEND.service;

import com.chatapp.CHAT_APP_BACKEND.entity.Message;
import com.chatapp.CHAT_APP_BACKEND.entity.Room;
import com.chatapp.CHAT_APP_BACKEND.exception.ChatAppException;
import com.chatapp.CHAT_APP_BACKEND.payload.MessageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {
    Room createRoom(String roomId) throws ChatAppException;
    Room getRoom(String roomId) throws ChatAppException;
    List<Message> getMessages(String roomId, int page, int size) throws ChatAppException;
    Message sendMessage(String roomId, MessageRequest request) throws ChatAppException;
}
