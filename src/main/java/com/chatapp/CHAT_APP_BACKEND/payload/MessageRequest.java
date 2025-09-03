package com.chatapp.CHAT_APP_BACKEND.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    private String content;
    private String sender;
    private String roomId;

    private String fileName;
    private String fileType;
    private String fileData;
}
