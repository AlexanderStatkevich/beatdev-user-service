package by.beatdev.userservice.dto;

import by.beatdev.userservice.domain.UserStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UserCreateDto(
        @NotBlank
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
        String email,
        @NotBlank
        String fullName,
        @NotBlank
        String imageUri,
        @NotNull
        UserStatus status,
        @NotBlank
        String password
) {
}
