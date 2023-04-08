package by.beatdev.userservice.dto;

import by.beatdev.userservice.domain.UserStatus;

public record UserUpdateResponseDto(
        Long id,
        UserStatus currentStatus,
        UserStatus previousStatus
) {
}
