package by.beatdev.userservice.dto;

import by.beatdev.userservice.domain.UserStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(value = "current_status")
    private final UserStatus currentStatus;
    @JsonProperty(value = "previous_status")
    private final UserStatus previousStatus;
}
