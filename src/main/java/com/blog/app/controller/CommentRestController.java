package com.blog.app.controller;

import com.blog.app.model.Comment;
import com.blog.app.model.Post;
import com.blog.app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CommentRestController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/comment")
    public List<Comment> get() {
        return (List<Comment>) commentService.findAll();
    }
    @GetMapping("/comment/{id}")
    public ResponseEntity<Comment> get(@PathVariable(value="id") int id){
        Comment comment=commentService.findOne(id);
        if (comment==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(comment);
    }
    @PostMapping("/comment")
    public void post(@RequestBody Comment comment){
        commentService.save(comment);
    }
    @PutMapping("/comment")
    public ResponseEntity<Comment> update(@RequestBody Comment comment){
        Comment com=commentService.findOne(comment.getId());
        if (com==null){
            return ResponseEntity.notFound().build();
        }
        commentService.save(comment);
        return ResponseEntity.ok(comment);
    }
    @DeleteMapping("/comment/{id}")
    public void delete(@PathVariable(value = "id") int id){
        commentService.delete(id);
    }
    @GetMapping("/commentcount")
    public long getcount() {
        return commentService.count();
    }
    @GetMapping("/findcomment/{id}")
    public List<Comment> getList(@PathVariable int id){
        return (List<Comment>)commentService.findAllByPid(id);
    }
}
