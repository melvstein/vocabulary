package dev.melvstein.vocabulary.mapper;

import dev.melvstein.vocabulary.dto.SaveUserRequestDto;
import dev.melvstein.vocabulary.dto.UserDto;
import dev.melvstein.vocabulary.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        if (user == null) {
            return null;
        }

        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public User toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }

        return User.builder()
                .id(dto.id())
                .username(dto.username())
                .firstName(dto.firstName())
                .middleName(dto.middleName())
                .lastName(dto.lastName())
                .email(dto.email())
                .createdAt(dto.createdAt())
                .updatedAt(dto.updatedAt())
                .build();
    }

    public User toUser(SaveUserRequestDto dto) {
        if (dto == null) {
            return null;
        }

        return User.builder()
                .username(dto.username())
                .firstName(dto.firstName())
                .middleName(dto.middleName())
                .lastName(dto.lastName())
                .email(dto.email())
                .password(dto.password())
                .build();
    }
}
