package com.UploadDownload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.UploadDownload.model.DatabaseFile;
import com.UploadDownload.service.DatabaseFileService;

public class FileDownloadController {
	@Autowired
	DatabaseFileService fileStorageService;
	
	@GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId) {
        DatabaseFile databaseFile = fileStorageService.getFile(fileId).get();
        
        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + databaseFile.getFileName())
            .body(new ByteArrayResource(databaseFile.getData()));
    }

}
