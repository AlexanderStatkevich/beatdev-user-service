package by.beatdev.userservice.service;

import by.beatdev.userservice.domain.User;
import by.beatdev.userservice.domain.UserStatus;
import by.beatdev.userservice.dto.UserUpdateDto;
import by.beatdev.userservice.dto.UserUpdateResponseDto;
import by.beatdev.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

/**
 * Described class is the core of the system.
 * It binds storage and output of application.
 * As well as uses CRUD operations for this purpose.
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    private final IBlacklistCheckEmailService userVerifyEmailService;
    private final UserRepository repository;

    /**
     * Method creates a new user.
     *
     * @param user that was passed from the controller and that will be saved in the database
     * @return unique id of new user
     */
    @Override
    @Transactional
    public Long create(User user) {
        userVerifyEmailService.check(user.getEmail());
        repository.saveAndFlush(user);
        return user.getId();
    }

    /**
     * Method finds an existed user.
     *
     * @param id is used to search in the database
     * @return entity of searched user
     */
    @Override
    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
    }

    /**
     * Method updates user status.
     *
     * @param id            is used to search in the database
     * @param userUpdateDto contains user status value
     * @return dto which contain id of updated user, previous and current status
     */
    @Override
    @Transactional
    public UserUpdateResponseDto update(Long id, UserUpdateDto userUpdateDto) {
        User user = findById(id);
        UserStatus previousStatus = user.getStatus();
        UserStatus currentStatus = userUpdateDto.getStatus();
        if (previousStatus == currentStatus) {
            log.warn("The current status is the same as the previous one");
        }
        user.setStatus(currentStatus);
        repository.save(user);
        return new UserUpdateResponseDto(id, currentStatus, previousStatus);
    }

    public boolean exists(String email) {
        return repository.existsByEmail(email);
    }
}
