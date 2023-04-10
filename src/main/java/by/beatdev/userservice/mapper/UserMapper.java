package by.beatdev.userservice.mapper;

import by.beatdev.userservice.domain.User;
import by.beatdev.userservice.dto.UserCreateDto;
import by.beatdev.userservice.dto.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User toEntity(UserCreateDto source);

    UserResponseDto toDto(User source);

}
