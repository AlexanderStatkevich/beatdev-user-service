package by.beatdev.userservice.web;

import by.beatdev.userservice.domain.User;
import by.beatdev.userservice.dto.UserResponseDto;
import by.beatdev.userservice.mapper.UserMapper;
import by.beatdev.userservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserMapper userMapper;
    @MockBean
    private UserService userService;

    @Test
    public void getByIdShouldReturnUserResponseDtoWithCorrectEmailField() throws Exception {
        UserResponseDto userResponseDto = UserResponseDto.builder().id(1L).email("test@test.com").build();
        User user = User.builder().id(1L).email("test@test.com").build();
        when(userService.findById(1L)).thenReturn(user);
        when(userMapper.toDto(user)).thenReturn(userResponseDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/users/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("test@test.com"));
    }
}
