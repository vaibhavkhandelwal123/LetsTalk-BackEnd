package com.chatapp.CHAT_APP_BACKEND.api;

import com.chatapp.CHAT_APP_BACKEND.entity.Message;
import com.chatapp.CHAT_APP_BACKEND.exception.ChatAppException;
import com.chatapp.CHAT_APP_BACKEND.payload.MessageRequest;
import com.chatapp.CHAT_APP_BACKEND.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("https://letstalk-1cki.onrender.com/")
public class ChatAPI {

    @Autowired
    private RoomService roomService;

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request
    ) throws ChatAppException {
        return roomService.sendMessage(roomId,request);
    }

}
