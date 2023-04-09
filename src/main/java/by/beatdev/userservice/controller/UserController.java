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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

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


@Tag(name = "Users API")

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final IUserService userService;
    private final UserMapper userMapper;

    @Operation(
            description = "Create new entity of user",
            responses = {
                    @ApiResponse(content = @Content(mediaType = "Long"), responseCode = "200", description = "User created"),
                    @ApiResponse(responseCode = "400", description = "validation exception")}
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@Valid @RequestBody UserCreateDto userCreateDto) {
        User user = userMapper.toEntity(userCreateDto);
        return userService.create(user);
    }


    @Operation(
            description = "Get user info by id",
            responses = {
                    @ApiResponse(content = @Content(mediaType = "application/json"), responseCode = "200", description = "User successfully returned"),
                    @ApiResponse(responseCode = "400", description = "validation exception")}
    )
    @GetMapping(path = "/{id}")
    public UserResponseDto getById(@PathVariable Long id) {
        User user = userService.findById(id);
        return userMapper.toDto(user);
    }


    @Operation(
            description = "Update user status (ONLINE/OFFLINE)",
            responses = {
                    @ApiResponse(content = @Content(mediaType = "application/json"), responseCode = "200", description = "User updated"),
                    @ApiResponse(responseCode = "400", description = "validation exception")}
    )
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
