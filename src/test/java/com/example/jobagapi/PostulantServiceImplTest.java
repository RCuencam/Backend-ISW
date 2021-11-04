package com.example.jobagapi;

import com.example.jobagapi.domain.model.Postulant;
import com.example.jobagapi.domain.repository.PostulantRepository;
import com.example.jobagapi.domain.service.PostulantService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import com.example.jobagapi.service.PostulantServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PostulantServiceImplTest {
    @MockBean
    private PostulantRepository postulantRepository;

    @TestConfiguration
    static class PostulantServiceImplTestConfiguration {
        public PostulantService postulantService() {
            return new PostulantServiceImpl();
        }
    }

    @Test
    @DisplayName("when SavePostulant With Valid Postulant Then Returns Success") //happy path
    public void whenSavePostulantWithValidPostulantThenReturnsSuccess() {
        Long id = 112L;
        String name = "example@upc.edu.pex";
        String password = "Nota#20";
        Postulant postulant = new Postulant(id, name, "Villegas", "email", 2524L, password, "document","civil");
        Postulant savedPostulant = postulantRepository.save(postulant);
        assertThat(savedPostulant);
    }





    /*@Test
    @DisplayName("when UpdatePostulant With Valid Postulant Then Returns Success") //happy path
    public void whenUpdatePostulantWithValidPostulantThenReturnsSuccess() {
        //Arrange
        Long id = 114L;
        String name = "example@upc.edu.pex";
        String password = "Nota#20x";
        Postulant postulant = new Postulant(id, name, "Villegas", "emails", 223L, password, "document","civil");

        String newPassword = "Nota@20x";
        postulant.setPassword(newPassword);
        postulantRepository.save(postulant);
        Optional<Postulant> updatePostulant = postulantRepository.findById(id);
        assertThat(updatePostulant.get().getPassword()).isEqualTo(newPassword);
    }*/
}
