package com.example.demo.controllers;

import com.example.demo.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("/upload-file")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        fileUploadService.uploadFile(file);
    }
}
