package com.blog.app.controller;

import com.blog.app.model.Post;
import com.blog.app.repository.PostRepository;
import com.blog.app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PostRestController {
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/post")
    public List<Post> get() {
        return (List<Post>) postService.findAll();
    }
    @GetMapping("/post/{id}")
    public ResponseEntity<Post> get(@PathVariable(value="id") int id){
        Post post=postService.findOne(id);
        if (post==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(post);
    }
    @PostMapping("/post")
    public ResponseEntity<Post> post(@RequestBody Post post){
        postService.save(post);
        return ResponseEntity.ok().body(post);
    }
    @PutMapping("/post/{id}")
    public ResponseEntity<Post> update(@RequestBody Post post){
        Post p=postService.findOne(post.getCid());
        if (p==null){
            return ResponseEntity.notFound().build();
        }
        postService.save(post);
        return ResponseEntity.ok().body(post);
    }
    @DeleteMapping("/post/{id}")
    public ResponseEntity<Post> delete(@PathVariable(value = "id") int cid){
        Post post=postService.findOne(cid);
        if (post==null){
            return ResponseEntity.notFound().build();
        }
        postService.delete(cid);
        return ResponseEntity.ok().body(post);
    }
    @GetMapping("/postlimit/{page}/{size}")
    public Page<Post> getAllLimit(@PathVariable int page, @PathVariable int size){
        return (Page<Post>) postService.findAll(new PageRequest(page,size,Sort.Direction.DESC,"pid"));
    }
    @GetMapping("/postcategory/{cid}")
    public List<Post> findAllByCidOrderByCidDesc(@PathVariable int cid){
        return (List<Post>)postService.findAllByCidOrderByCidDesc(cid);
    }
    @GetMapping("/postcount")
    public long getcount() {
        return postService.count();
    }
    @GetMapping("/postsearch/{name}")
    public List<Post> search(@PathVariable String name){
        return (List<Post>)postService.findAllByNameContaining(name);
    }
}
