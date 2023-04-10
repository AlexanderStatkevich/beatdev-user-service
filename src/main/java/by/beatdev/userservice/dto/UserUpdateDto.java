package by.beatdev.userservice.dto;

import by.beatdev.userservice.domain.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Builder
@Jacksonized
@Getter
public class UserUpdateDto {
    @NotNull
    private final UserStatus status;
}
