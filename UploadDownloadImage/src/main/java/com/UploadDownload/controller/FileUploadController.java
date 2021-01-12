package com.UploadDownload.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.UploadDownload.service.DatabaseFileService;


@RestController
public class FileUploadController {
	@Autowired
	DatabaseFileService databaseFileService;
	
	@PostMapping("/uploadFile")
	public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
				databaseFileService.storeFile(file);
	}

}
