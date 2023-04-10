package by.beatdev.userservice.integration;

import by.beatdev.userservice.domain.User;
import by.beatdev.userservice.domain.UserStatus;
import by.beatdev.userservice.repository.UserRepository;
import by.beatdev.userservice.service.BlacklistCheckEmailService;
import by.beatdev.userservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@Testcontainers
public class IntegrationTest {
    @Container
    private static MySQLContainer<?> mySqlContainer = new MySQLContainer<>("mysql:8.0.32")
            .withDatabaseName("users")
            .withUsername("test")
            .withPassword("test");

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BlacklistCheckEmailService blacklistCheckEmailService;

    @Autowired
    private UserService userService;

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mySqlContainer::getUsername);
        registry.add("spring.datasource.password", mySqlContainer::getPassword);
    }

    @Test
    void checkGetMethodReturnAppropriateEntity() {
        User expected = User.builder()
                .id(1L)
                .dateTimeCreate(LocalDateTime.now())
                .dateTimeUpdate(LocalDateTime.now())
                .email("test@test.test")
                .fullName("test test")
                .imageUri("smth")
                .status(UserStatus.ONLINE)
                .password("3213")
                .build();
        userRepository.save(expected);
        User actual = userService.findById(1L);

        assertThat(actual).isEqualTo(expected);
    }
}
