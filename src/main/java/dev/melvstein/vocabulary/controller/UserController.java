package dev.melvstein.vocabulary.controller;

import dev.melvstein.vocabulary.dto.SaveUserRequestDto;
import dev.melvstein.vocabulary.dto.UserDto;
import dev.melvstein.vocabulary.entity.User;
import dev.melvstein.vocabulary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        if (!users.isEmpty()) {
            return ResponseEntity.ok(userService.toDtos(users));
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);

        if (user != null) {
            return ResponseEntity.ok(userService.toDto(user));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody SaveUserRequestDto request) {
        User user = userService.toUser(request);
        user.setEncryptedPassword(passwordEncoder.encode(request.password()));
        User savedUser = userService.saveUser(user);

        return ResponseEntity.ok(userService.toDto(savedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
