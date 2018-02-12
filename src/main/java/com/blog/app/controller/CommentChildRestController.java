package com.blog.app.controller;

import com.blog.app.model.CommentChild;
import com.blog.app.service.CommentChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CommentChildRestController {
    @Autowired
    private CommentChildService commentChildService;
    @GetMapping("/commentchild")
    public List<CommentChild> get() {
        return (List<CommentChild>) commentChildService.findAll();
    }
    @GetMapping("/commentchild/{id}")
    public ResponseEntity<CommentChild> get(@PathVariable(value="id") int id){
        CommentChild comment=commentChildService.findOne(id);
        if (comment==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(comment);
    }
    @PostMapping("/user/commentchild")
    public ResponseEntity<CommentChild> post(@RequestBody CommentChild comment){
        CommentChild us=commentChildService.findOne(comment.getId());
        if (us==null){
            return ResponseEntity.notFound().build();
        }
        commentChildService.save(comment);
        return ResponseEntity.ok().body(comment);
    }
    @PutMapping("/user/commentchild")
    public ResponseEntity<CommentChild> update(@RequestBody CommentChild comment){
        CommentChild com=commentChildService.findOne(comment.getId());
        if (com==null){
            return ResponseEntity.notFound().build();
        }
        commentChildService.save(comment);
        return ResponseEntity.ok().body(comment);
    }
    @DeleteMapping("/admin/commentchild/{id}")
    public ResponseEntity<CommentChild> delete(@PathVariable(value = "id") int id){
        CommentChild comment=commentChildService.findOne(id);
        if (comment==null){
            return ResponseEntity.notFound().build();
        }
        commentChildService.delete(id);
        return ResponseEntity.ok().body(comment);
    }
}
