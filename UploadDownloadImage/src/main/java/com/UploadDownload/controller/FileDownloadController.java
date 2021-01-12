package com.UploadDownload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.UploadDownload.model.DatabaseFile;
import com.UploadDownload.service.DatabaseFileService;

public class FileDownloadController {
	@Autowired
	DatabaseFileService databaseFileService;
	
	@GetMapping("/downloadFile/{fileId}")
	public DatabaseFile downloadFile(@PathVariable Integer fileId) {
		DatabaseFile databaseFile = databaseFileService.getFile(fileId).get();
		return databaseFile;
	}

}
