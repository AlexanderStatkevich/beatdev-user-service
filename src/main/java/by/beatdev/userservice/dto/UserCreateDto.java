package by.beatdev.userservice.dto;


import by.beatdev.userservice.domain.UserStatus;
import by.beatdev.userservice.validation.UniqueEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserCreateDto {

    @NotBlank
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    @UniqueEntity
    private String email;

    @NotBlank
    private String fullName;

    @NotBlank
    private String imageUri;

    @NotNull
    private UserStatus status;

    @NotBlank
    private String password;
}
