package dev.melvstein.vocabulary.dto;

import lombok.Builder;

@Builder
public record SaveUserRequestDto(
        String username,
        String firstName,
        String middleName,
        String lastName,
        String email,
        String password
) {
}
