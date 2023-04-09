package by.beatdev.userservice.dto;

import by.beatdev.userservice.domain.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserUpdateDto {
    @NotNull
    private UserStatus status;
}
