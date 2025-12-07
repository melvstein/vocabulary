package dev.melvstein.vocabulary.service;

import dev.melvstein.vocabulary.dto.SaveUserRequestDto;
import dev.melvstein.vocabulary.dto.UserDto;
import dev.melvstein.vocabulary.entity.User;
import dev.melvstein.vocabulary.mapper.UserMapper;
import dev.melvstein.vocabulary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public UserDto toDto(User user) {
        return userMapper.toDto(user);
    }

    public User toEntity(UserDto dto) {
        return userMapper.toEntity(dto);
    }

    public User toUser(SaveUserRequestDto dto) {
        return userMapper.toUser(dto);
    }

    public List<UserDto> toDtos(List<User> users) {
        return users.stream().map(this::toDto).toList();
    }
}
