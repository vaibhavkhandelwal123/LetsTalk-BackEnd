package com.chatapp.CHAT_APP_BACKEND;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.chatapp.CHAT_APP_BACKEND.api",
		"com.chatapp.CHAT_APP_BACKEND.service",
		"com.chatapp.CHAT_APP_BACKEND.repository",
		"com.chatapp.CHAT_APP_BACKEND.entity",
		"com.chatapp.CHAT_APP_BACKEND.exception",
		"com.chatapp.CHAT_APP_BACKEND.config",
		"com.chatapp.CHAT_APP_BACKEND.payload"
})
public class ChatAppBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChatAppBackendApplication.class, args);
	}
}
