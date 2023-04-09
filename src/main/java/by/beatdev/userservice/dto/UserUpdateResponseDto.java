package by.beatdev.userservice.dto;

import by.beatdev.userservice.domain.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@RequiredArgsConstructor
@Builder
@Jacksonized
@Getter
public class UserUpdateResponseDto {
    private final Long id;
    private final UserStatus currentStatus;
    private final UserStatus previousStatus;
}
