package com.blog.app.controller;

import com.blog.app.model.Users;
import com.blog.app.service.UsersService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
class UsersRestController {
    @Autowired
    private UsersService usersService;
    @GetMapping("/user")
    public List<Users> get() {
        return (List<Users>) usersService.findAll();
    }
    @GetMapping("/user/{name}")
    public Users get(@PathVariable(value="name") String name){
        return usersService.findOne(name);

    }
    @PostMapping("/user")
    public void post(@RequestBody Users user){
        if (usersService.findOne(user.getUsername())!=null){
            return;
        }
        usersService.save(user);
    }
    @PutMapping("/user/{name}")
    public ResponseEntity<Users> update(@RequestBody Users user){
        Users users=usersService.findOne(user.getUsername());
        if (user==null){
            return ResponseEntity.notFound().build();
        }
        usersService.save(user);
        users=usersService.findOne(user.getUsername());
        return ResponseEntity.ok(users);
    }
    @DeleteMapping("/user/{name}")
    public ResponseEntity<Users> delete(@PathVariable(value = "name") String name){
        Users user=usersService.findOne(name);
        if (user==null){
            return ResponseEntity.notFound().build();
        }
        usersService.delete(name);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/user/search/{name}")
    public List<Users> search(@PathVariable(value = "name") String username){
        return (List<Users>) usersService.findAllByUsernameLike(username);
    }
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@RequestBody Users login) {
//
//        String jwtToken = "";
//
//        if (login.getUsername() == null || login.getPassword() == null) {
//            return null;
//        }
//
//        String name = login.getUsername();
//        String password = login.getPassword();
//
//        Users user = usersService.findOne(login.getUsername());
//
//        if (user == null) {
//            return  null;
//        }
//
//        String pwd = user.getPassword();
//
//        if (!password.equals(pwd)) {
//            return null;
//        }
//        Claims claims=Jwts.claims().setSubject(user.getUsername());
//        jwtToken = Jwts.builder().setSubject(name).setClaims(claims)
//                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
//
//        return jwtToken;
//    }
    @PostMapping("/login")
    public Users login(@RequestBody Users user){
        Users u=new Users();
        u=usersService.findOne(user.getUsername());
        if (u==null) return null;
        if (u.getUsername().equals(user.getUsername())&&u.getPassword().equals(user.getPassword())){
            return u;
        }
        return null;
    }
    @GetMapping("/usercount")
    public long getcount() {
        return usersService.count();
    }

    @GetMapping("/userget/{username}/{password}")
    public String getUser(@PathVariable String username,@PathVariable String password){
        System.out.println(username);
        if (usersService.find(username,password)) return "1";
        return "0";
    }
}
