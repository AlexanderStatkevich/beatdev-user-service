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
    private Long id;
    private LocalDateTime dateTimeCreate;
    private LocalDateTime dateTimeUpdate;
    private String email;
    private String fullName;
    private String imageUri;
    private UserStatus status;
    private String password;
}
