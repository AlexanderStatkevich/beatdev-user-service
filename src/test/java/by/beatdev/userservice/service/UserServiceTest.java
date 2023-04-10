package by.beatdev.userservice.service;

import by.beatdev.userservice.domain.User;
import by.beatdev.userservice.domain.UserStatus;
import by.beatdev.userservice.dto.UserUpdateDto;
import by.beatdev.userservice.dto.UserUpdateResponseDto;
import by.beatdev.userservice.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Nested
    class UserServiceUpdateTests {

        @Test
        @DisplayName("User service update check return value")
        void checkUpdateReturningCorrectDtoWithCurrentAndPreviousStatus() {
            UserStatus previousStatus = UserStatus.ONLINE;
            when(userRepository.findById(1L)).thenReturn(Optional.of(User.builder().status(previousStatus).build()));
            UserStatus currentStatus = UserStatus.OFFLINE;
            UserUpdateResponseDto updatedEntity = userService.update(1L, new UserUpdateDto(currentStatus));
            assertThat(updatedEntity.getCurrentStatus()).isEqualTo(currentStatus);
            assertThat(updatedEntity.getPreviousStatus()).isEqualTo(previousStatus);
        }

        @Test
        @DisplayName("User service update check times")
        void checkUpdateCallRepositoryOnlyOneTime() {
            when(userRepository.findById(1L)).thenReturn(Optional.of(User.builder().status(UserStatus.ONLINE).build()));
            userService.update(1L, new UserUpdateDto(UserStatus.OFFLINE));
            verify(userRepository, times(1)).findById(1L);
        }
    }
}
