package com.example.jobagapi;
import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.repository.EmployeerRepository;
import com.example.jobagapi.domain.service.EmployeerService;
import com.example.jobagapi.service.EmployeerServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {Employeer.class})
@ExtendWith(SpringExtension.class)
public class EmployeerServiceImplTest {

    @MockBean
    private EmployeerRepository employeerRepository;

    @TestConfiguration
    static class EmployeerServiceImplTestConfiguration
    {
        @Bean
        public EmployeerService employeerService()
        {
            return new EmployeerServiceImpl();
        }
    }


    @Test
    @DisplayName("When getEmployeerByPosicion With Valid Title Then Returns Employeer")
    public void whenGetEmployeerByPosicionWithValidPosicionThenReturnsEmployeer() {
        // Arrange
        String posicion = "posicion";
        Employeer employeer = new Employeer().setPosicion(posicion);
        when(employeerRepository.findByPosicion(posicion))
                .thenReturn(Optional.of(employeer));

        // Act
       // Employeer foundEmployeer = employeerRepository.findByPosicion(posicion);

        // Assert
      //  assertThat(foundEmployeer.getPosicion()).isEqualTo(posicion);

    }




}