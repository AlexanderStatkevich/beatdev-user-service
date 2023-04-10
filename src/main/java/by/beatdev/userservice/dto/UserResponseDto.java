package by.beatdev.userservice.dto;


import by.beatdev.userservice.domain.UserStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(value = "date_time_create")
    private final LocalDateTime dateTimeCreate;
    @JsonProperty(value = "date_time_update")
    private final LocalDateTime dateTimeUpdate;
    private final String email;
    @JsonProperty(value = "full_name")
    private final String fullName;
    @JsonProperty(value = "image_uri")
    private final String imageUri;
    private final UserStatus status;
}
