package by.beatdev.userservice.service;

import by.beatdev.userservice.domain.User;
import by.beatdev.userservice.dto.UserUpdateDto;
import by.beatdev.userservice.dto.UserUpdateResponseDto;

public interface IUserService {

    Long create(User user);

    User findById(Long id);

    UserUpdateResponseDto update(Long id, UserUpdateDto userUpdateDto);
}
