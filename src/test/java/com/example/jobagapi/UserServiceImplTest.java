package com.example.jobagapi;
import com.example.jobagapi.domain.model.User;
import com.example.jobagapi.domain.repository.UserRepository;
import com.example.jobagapi.domain.service.UserService;
import com.example.jobagapi.service.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {

    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @TestConfiguration
    static class UserServiceImplTestConfiguration
    {
        @Bean
        public UserService userService()
        {
            return new UserServiceImpl();
        }
    }
    @Test
    @DisplayName("When getUserById With Valid Title Then Returns Employeer")
    public void whenGetUserByIdWithValidIdThenReturnsEmployeer() {
        // Arrange
        Long Id = 1L;
        User user = new User().setId(Id);
        when(userRepository.findById(Id))
                .thenReturn(Optional.of(user));

        // Act
        User foundUser = userService.getUserById(Id);

        // Assert
        assertThat(foundUser.getId()).isEqualTo(Id);

    }

    /*
    @Test
    @DisplayName("When getEmployeerByPosicion With Valid Title Then Returns Employeer")
    public void whenGetUserByFirstnameWithValidFirstnameThenReturnsUser() {
        // Arrange
        String firstname = "Carolina";
        User user = new User().setFirstname(firstname);
        when(userRepository.findByFirstname(firstname))
                .thenReturn(Optional.of(firstname));

        // Act
        User foundUser = userService.getUserByFirstname(firstname);

        // Assert
        assertThat(foundUser.getFirstname().isEqualTo(firstname));

    }

*/


}