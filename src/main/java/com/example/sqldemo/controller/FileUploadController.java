package com.example.sqldemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @PostMapping(value = "/upload/image", consumes = "multipart/form-data")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select file";
        }
        try {
            String path = "C:\\upload/";
            File file1 = new File(path);

            if (!file1.exists()) {
                file1.mkdir();
            }

            String filePath = path + file.getOriginalFilename();
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "File Uploaded Successfully.";
    }
}
