package by.beatdev.userservice.controller;

import by.beatdev.userservice.domain.User;
import by.beatdev.userservice.dto.UserCreateDto;
import by.beatdev.userservice.dto.UserResponseDto;
import by.beatdev.userservice.dto.UserUpdateDto;
import by.beatdev.userservice.dto.UserUpdateResponseDto;
import by.beatdev.userservice.exception.custom.UserEmailInBlacklistException;
import by.beatdev.userservice.exception.response.ErrorResponse;
import by.beatdev.userservice.mapper.UserMapper;
import by.beatdev.userservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final IUserService userService;
    private final UserMapper userMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@Valid @RequestBody UserCreateDto userCreateDto) {
        User user = userMapper.toEntity(userCreateDto);
        return userService.create(user);
    }

    @GetMapping(path = "/{id}")
    public UserResponseDto getById(@PathVariable Long id) {
        User user = userService.findById(id);
        return userMapper.toDto(user);
    }

    @PatchMapping(path = "/{id}")
    public UserUpdateResponseDto update(@PathVariable Long id,
                                        @Valid @RequestBody UserUpdateDto userUpdateDto) {
        return userService.update(id, userUpdateDto);
    }

    @ExceptionHandler(UserEmailInBlacklistException.class)
    protected ResponseEntity<Object> handleUserEmailInBlacklistException(UserEmailInBlacklistException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
