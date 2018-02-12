package com.blog.app.controller;

import com.blog.app.model.Upload;
import com.blog.app.repository.UploadReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UploadRestController {
    @Autowired
    UploadReponsitory uploadReponsitory;
    @PostMapping("/upload")
    public void save(@RequestBody Upload upload){
        uploadReponsitory.save(upload);
    }
    @GetMapping("/upload")
    public List<Upload> get(){
        return (List<Upload>)uploadReponsitory.findAll();
    }
}
