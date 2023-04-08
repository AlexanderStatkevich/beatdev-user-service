package by.beatdev.userservice.dto;

import by.beatdev.userservice.domain.UserStatus;

import java.time.LocalDateTime;

public record UserResponseDto(
        Long id,
        LocalDateTime dateTimeCreate,
        LocalDateTime dateTimeUpdate,
        String email,
        String fullName,
        String imageUri,
        UserStatus status,
        String password
) {
}
