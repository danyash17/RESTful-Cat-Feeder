package com.bsu.tpbackend.controller;

import com.bsu.tpbackend.entity.UserEntity;
import com.bsu.tpbackend.exception.user.UserAlreadyExistException;
import com.bsu.tpbackend.exception.user.UserNotFoundException;
import com.bsu.tpbackend.service.LogService;
import com.bsu.tpbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;

    @GetMapping
    public ResponseEntity get(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(userService.getSingleUser());
        } catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity register(@RequestBody UserEntity user) {
        try {
            userService.register(user);
            return ResponseEntity.ok("All done, new user registered");
        } catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestParam Integer id, @RequestBody UserEntity newUser) {
        try {
            userService.updateUser(id,newUser);
            return ResponseEntity.ok("User updated");
        } catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@RequestParam Integer id) {
        try {
            userService.deleteUser();
            return ResponseEntity.ok("User deleted");
        } catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
