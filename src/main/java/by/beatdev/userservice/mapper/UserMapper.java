package by.beatdev.userservice.mapper;

import by.beatdev.userservice.domain.User;
import by.beatdev.userservice.dto.UserCreateDto;
import by.beatdev.userservice.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {

    User toEntity(UserCreateDto source);

    UserResponseDto toDto(User source);

    void map(UserCreateDto source, @MappingTarget User target);
}
