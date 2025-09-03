package com.chatapp.CHAT_APP_BACKEND.api;

import com.chatapp.CHAT_APP_BACKEND.entity.StoredFile;
import com.chatapp.CHAT_APP_BACKEND.repository.StoredFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "http://localhost:5173")
public class FileController {

    @Autowired
    private StoredFileRepository fileRepository;

    @PostMapping("/upload")
    public ResponseEntity<StoredFile> uploadFile(@RequestBody StoredFile file) {
        // generate unique ID for this file
        file.setId(UUID.randomUUID().toString());
        fileRepository.save(file);
        return ResponseEntity.ok(file);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoredFile> getFile(@PathVariable String id) {
        Optional<StoredFile> file = fileRepository.findById(id);
        return file.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
