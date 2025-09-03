package com.chatapp.CHAT_APP_BACKEND.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String sender;
    private String content;
    private LocalDateTime timeStamp;

    // For file messages
    private String fileName;
    private String fileType;
    private String fileData; // base64 string
}
