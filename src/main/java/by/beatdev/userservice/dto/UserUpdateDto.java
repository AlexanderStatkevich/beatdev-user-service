package by.beatdev.userservice.dto;

import by.beatdev.userservice.domain.UserStatus;
import jakarta.validation.constraints.NotNull;


public record UserUpdateDto(
        @NotNull
        UserStatus status
) {
}
