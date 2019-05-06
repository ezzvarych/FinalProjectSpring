package com.example.demo.controller.restController;

import com.example.demo.model.entity.user.User;
import com.example.demo.model.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO Write tests
@RestController
@RequestMapping("/users")
@Slf4j
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        log.debug("This method works");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.create(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
        user.setId(id);
        return ResponseEntity.status(HttpStatus.CONTINUE).body(userService.update(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
