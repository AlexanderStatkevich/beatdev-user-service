package by.beatdev.userservice.service;

import by.beatdev.userservice.domain.User;
import by.beatdev.userservice.domain.UserStatus;
import by.beatdev.userservice.dto.UserUpdateDto;
import by.beatdev.userservice.dto.UserUpdateResponseDto;
import by.beatdev.userservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    private final IBlacklistCheckEmailService userVerifyEmailService;
    private final UserRepository repository;

    @Override
    @Transactional
    public Long create(User user) {
        userVerifyEmailService.check(user.getEmail());
        repository.saveAndFlush(user);
        return user.getId();
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
    }

    @Override
    @Transactional
    public UserUpdateResponseDto update(Long id, UserUpdateDto userUpdateDto) {
        User user = repository.getReferenceById(id);
        UserStatus previousStatus = user.getStatus();
        UserStatus currentStatus = userUpdateDto.status();
        user.setStatus(currentStatus);
        repository.save(user);
        return new UserUpdateResponseDto(id, currentStatus, previousStatus);
    }
}
