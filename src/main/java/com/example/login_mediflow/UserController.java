package com.example.login_mediflow;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@Valid @PathVariable String username) {
        Optional<User> user = userService.findByUserName(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.created(URI.create("api/users/" + createdUser.getUserName())).body(createdUser);
    }

    @PutMapping("/{username}")
    public ResponseEntity<User> updateUser(@Valid @PathVariable String username, @Valid @RequestBody User user) {
        Optional<User> mahbe = userService.updateUser(username, user);
        if (mahbe.isPresent()) {
            return ResponseEntity.ok(mahbe.get());
        }
        return ResponseEntity.notFound().build();
    }

}
