package com.example.pdftest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class FileUploadController {

    private static final Logger logger = Logger.getLogger(FileUploadController.class.getName());

    @PostMapping("/uploadPdf")
    public String uploadPdf(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "No file uploaded";
        }

        String fileName = file.getOriginalFilename();
        logger.info("Uploaded file name: " + fileName);

        // You can also print the file name directly
        System.out.println("Uploaded file name: " + fileName);

        return "File uploaded successfully: " + fileName;
    }
}
