package com.example.simpleuser.controller;

import com.example.simpleuser.model.User;
import com.example.simpleuser.service.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users")
public class SimpleUserController {

    private final SimpleUserService simpleUserService;

    @Autowired
    public SimpleUserController(SimpleUserService simpleUserService) {
        this.simpleUserService = simpleUserService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(simpleUserService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return new ResponseEntity<>(simpleUserService.addUser(user), HttpStatus.OK);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getOneUser(@PathVariable("userName") String userName) {
        return new ResponseEntity<>(simpleUserService.findUser(userName), HttpStatus.OK);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@PathVariable("userName") String userName, @RequestBody User user) {
        return new ResponseEntity<>(simpleUserService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<?> deleteUser(@PathVariable("userName") String userName) {
        simpleUserService.deleteUser(userName);

        return new ResponseEntity<>(userName + " deleted successfully!", HttpStatus.OK);
    }
}
