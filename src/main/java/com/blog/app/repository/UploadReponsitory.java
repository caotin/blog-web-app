package com.blog.app.repository;

import com.blog.app.model.Upload;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadReponsitory extends CrudRepository<Upload,Integer> {
}
