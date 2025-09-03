package com.chatapp.CHAT_APP_BACKEND.api;

import com.chatapp.CHAT_APP_BACKEND.entity.Message;
import com.chatapp.CHAT_APP_BACKEND.entity.Room;
import com.chatapp.CHAT_APP_BACKEND.exception.ChatAppException;
import com.chatapp.CHAT_APP_BACKEND.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@CrossOrigin("http://localhost:5173")
public class RoomAPI {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create")
    public ResponseEntity<?> createRoom(@RequestBody String roomId) throws ChatAppException {
        return new ResponseEntity<>(roomService.createRoom(roomId),HttpStatus.CREATED);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<Room> getRoom(@PathVariable String roomId) throws ChatAppException{
        return new ResponseEntity<>(roomService.getRoom(roomId),HttpStatus.OK);
    }

    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getMessage(
            @PathVariable String roomId,
            @RequestParam(value="page",defaultValue = "0",required =false) int page,
            @RequestParam(value="size",defaultValue = "20",required =false) int size
    ) throws ChatAppException{
        return new ResponseEntity<>(roomService.getMessages(roomId,page,size),HttpStatus.OK);
    }
}
