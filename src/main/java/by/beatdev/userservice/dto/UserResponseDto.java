package by.beatdev.userservice.dto;


import by.beatdev.userservice.domain.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponseDto {
    Long id;
    LocalDateTime dateTimeCreate;
    LocalDateTime dateTimeUpdate;
    String email;
    String fullName;
    String imageUri;
    UserStatus status;
    String password;
}
