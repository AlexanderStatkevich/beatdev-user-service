package by.beatdev.userservice.dto;

import by.beatdev.userservice.domain.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserUpdateResponseDto {
    Long id;
    UserStatus currentStatus;
    UserStatus previousStatus;
}
