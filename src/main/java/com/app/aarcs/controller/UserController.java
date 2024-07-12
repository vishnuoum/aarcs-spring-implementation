package com.app.aarcs.controller;

import com.app.aarcs.model.User;
import com.app.aarcs.sqlMappers.UserMapper;
import com.app.aarcs.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/listUsers")
    public List<User> listUsers() {
        return userMapper.getAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        return new ResponseEntity<>(Util.convertToSHA1(userMapper.register(user).toString()), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        return new ResponseEntity<>(Util.convertToSHA1(userMapper.login(user).toString()), HttpStatus.ACCEPTED);
    }

    @PostMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestBody String id) {
        return new ResponseEntity<>(userMapper.getUser(id), HttpStatus.OK);
    }
}
