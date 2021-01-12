package com.UploadDownload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UploadDownload.model.DatabaseFile;
@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Integer> {

}
