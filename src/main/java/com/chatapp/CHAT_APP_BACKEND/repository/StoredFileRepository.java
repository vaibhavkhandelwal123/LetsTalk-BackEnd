package com.chatapp.CHAT_APP_BACKEND.repository;

import com.chatapp.CHAT_APP_BACKEND.entity.StoredFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoredFileRepository extends MongoRepository<StoredFile, String> {}
