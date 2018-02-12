package com.blog.app.service;

import com.blog.app.model.Upload;
import com.blog.app.repository.UploadReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    UploadReponsitory uploadReponsitory;
    @Override
    public Iterable<Upload> findAll() {
        return uploadReponsitory.findAll();
    }

    @Override
    public Upload findOne(int uploadId) {
        return uploadReponsitory.findOne(uploadId);
    }

    @Override
    public void save(Upload upload) {
        uploadReponsitory.save(upload);
    }

    @Override
    public void delete(int uploadId) {
        uploadReponsitory.delete(uploadId);
    }
}
