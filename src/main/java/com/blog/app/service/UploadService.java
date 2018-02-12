package com.blog.app.service;

import com.blog.app.model.Upload;

public interface UploadService {
    Iterable<Upload> findAll();
    Upload findOne(int uploadId);
    void save(Upload upload);
    void delete(int uploadId);
}
