package com.example.jobagapi;
import com.example.jobagapi.domain.model.User;
import com.example.jobagapi.domain.repository.UserRepository;
import com.example.jobagapi.domain.service.UserService;
import com.example.jobagapi.exception.ResourceNotFoundException;
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
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
    public class UserServiceImplTest {
        @MockBean
        private UserRepository userRepository;

        @TestConfiguration
        static class UserServiceImplTestConfiguration {
            public UserService userService() {
                return new UserServiceImpl();
            }
        }

        @Test
        @DisplayName("when SaveUser With Valid User Then Returns Success") //happy path
        public void whenSaveUserWithValidUserThenReturnsSuccess() {
            Long id = 1L;
            String name = "example@upc.edu.pe";
            String password = "Nota#20";
            User user = new User().setId(id).setFirstname(name).setPassword(password);
            User savedUser = userRepository.save(user);
            assertThat(savedUser);
        }


        /*@Test
        @DisplayName("when UpdateUser With Valid User Then Returns Success") //happy path
        public void whenUpdateUserWithValidUserThenReturnsSuccess() {
            //Arrange
            Long id = 1L;
            String name = "example@upc.edu.pe";
            String password = "Nota#20";
            User user = new User().setId(id).setFirstname(name).setPassword(password);

            String newPassword = "Nota@20";
            user.setPassword(newPassword);
            userRepository.save(user);
            Optional<User> updateUser = userRepository.findById(id);
            assertThat(updateUser.get().getPassword()).isEqualTo(newPassword);
        }*/
    }


