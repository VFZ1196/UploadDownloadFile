package com.UploadDownload.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.UploadDownload.model.DatabaseFile;
import com.UploadDownload.repository.DatabaseFileRepository;

@Service
public class DatabaseFileService {
	
	@Autowired
	DatabaseFileRepository databaseFileRepo;

	public DatabaseFile storeFile(MultipartFile file) throws IOException {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());

		return databaseFileRepo.save(dbFile);
	}
	
	public Optional<DatabaseFile> getFile(Integer fileId) {
		return databaseFileRepo.findById(fileId);
	}

}
