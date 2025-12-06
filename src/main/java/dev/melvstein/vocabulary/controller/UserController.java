package dev.melvstein.vocabulary.controller;

import dev.melvstein.vocabulary.dto.SaveUserRequestDto;
import dev.melvstein.vocabulary.dto.UserDto;
import dev.melvstein.vocabulary.entity.User;
import dev.melvstein.vocabulary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody SaveUserRequestDto request) {
        User user = userService.toUser(request);
        user.setEncryptedPassword(passwordEncoder.encode(request.password()));
        User savedUser = userService.saveUser(user);

        return ResponseEntity.ok(userService.toDto(savedUser));
    }
}
