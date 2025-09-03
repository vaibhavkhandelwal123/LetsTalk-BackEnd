package com.chatapp.CHAT_APP_BACKEND.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "files")
public class StoredFile {
    @Id
    private String id;

    private String fileName;
    private String contentType;
    private String data; // base64 string
}
