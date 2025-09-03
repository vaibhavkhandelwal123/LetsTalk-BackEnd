package com.chatapp.CHAT_APP_BACKEND.service;

import com.chatapp.CHAT_APP_BACKEND.entity.Message;
import com.chatapp.CHAT_APP_BACKEND.entity.Room;
import com.chatapp.CHAT_APP_BACKEND.exception.ChatAppException;
import com.chatapp.CHAT_APP_BACKEND.payload.MessageRequest;
import com.chatapp.CHAT_APP_BACKEND.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoomServiceImplementation implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room createRoom(String roomId) throws ChatAppException {
        if (roomRepository.findByRoomId(roomId) != null) {
            throw new ChatAppException("Room already exists");
        }
        Room room = new Room();
        room.setRoomId(roomId);
        return roomRepository.save(room);
    }

    @Override
    public Room getRoom(String roomId) throws ChatAppException {
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            throw new ChatAppException("Room not exists");
        }
        return room;
    }

    @Override
    public List<Message> getMessages(String roomId, int page, int size) throws ChatAppException {
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            throw new ChatAppException("Room not exists");
        }
        List<Message> messages = room.getMessageList();
        int start = Math.max(0, messages.size() - (page + 1) * size);
        int end = Math.min(messages.size(), start + size);
        return messages.subList(start, end);
    }

    @Override
    public Message sendMessage(String roomId, MessageRequest request) throws ChatAppException {
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            throw new ChatAppException("room not found!");
        }

        Message message = new Message();
        message.setSender(request.getSender());
        message.setContent(request.getContent());
        message.setTimeStamp(LocalDateTime.now());

        // handle file if present
        message.setFileName(request.getFileName());
        message.setFileType(request.getFileType());
        message.setFileData(request.getFileData());

        room.getMessageList().add(message);
        roomRepository.save(room);

        return message;
    }


}
