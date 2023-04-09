package by.beatdev.userservice.dto;


import by.beatdev.userservice.domain.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Builder
@Jacksonized
@Getter
public class UserResponseDto {
    private final Long id;
    private final LocalDateTime dateTimeCreate;
    private final LocalDateTime dateTimeUpdate;
    private final String email;
    private final String fullName;
    private final String imageUri;
    private final UserStatus status;
    private final String password;
}
