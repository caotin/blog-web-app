package com.blog.app.controller;

import com.blog.app.model.Category;
import com.blog.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> get() {
        return (List<Category>) categoryService.findAll();
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<Category> get(@PathVariable(value="id") int cid){
        Category cate=categoryService.findOne(cid);
        if (cate==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cate);
    }
    @PostMapping("/category")
    public void post(@RequestBody Category category){
        categoryService.save(category);
    }
    @PutMapping("/category/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category){
        Category cate=categoryService.findOne(category.getCid());
        if (cate==null){
            return ResponseEntity.notFound().build();
        }
        categoryService.save(category);
        cate=categoryService.findOne(category.getCid());
        return ResponseEntity.ok(cate);
    }
    @DeleteMapping("/category/{id}")
    public ResponseEntity<Category> delete(@PathVariable(value = "id") int cid){
        Category cate=categoryService.findOne(cid);
        if (cate==null){
            return ResponseEntity.notFound().build();
        }
        categoryService.delete(cid);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/categorycount")
    public long countCategory(){
        return categoryService.countAllByCid();
    }
}
