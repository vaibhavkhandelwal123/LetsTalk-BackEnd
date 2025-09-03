package com.chatapp.CHAT_APP_BACKEND.repository;

import com.chatapp.CHAT_APP_BACKEND.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {
    Room findByRoomId(String roomId);
}
