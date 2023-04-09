package by.beatdev.userservice.dto;


import by.beatdev.userservice.domain.UserStatus;
import by.beatdev.userservice.validation.UniqueEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Builder
@Jacksonized
@Getter
public class UserCreateDto {

    @NotBlank
    @UniqueEntity
    private final String email;

    @NotBlank
    private final String fullName;

    @NotBlank
    private final String imageUri;

    @NotNull
    private final UserStatus status;

    @NotBlank
    private final String password;
}
