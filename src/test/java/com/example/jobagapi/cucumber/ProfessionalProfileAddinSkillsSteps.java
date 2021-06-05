package com.example.jobagapi.cucumber;


import com.example.jobagapi.domain.model.Postulant;
import com.example.jobagapi.domain.repository.PostulantRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProfessionalProfileAddinSkillsSteps {

    @LocalServerPort
    private RestTemplate restTemplate = new RestTemplate();
    private String postUrl="http://localhost:8080";



    private String error=null;

    public String randomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        return generatedString;
    }
    @Given("the postulant is the seccion professionalprofile")
    public void the_postulant_is_the_seccion_professionalprofile() {

        Postulant newpostulant = new Postulant(1L, "firstname", "lastname", randomString(), 123L, "password","document","civil");
        String url2=postUrl+"/api" +"/postulants";
        Postulant postulant=restTemplate.postForObject(url2,newpostulant,Postulant.class);
        log.info(postulant);

        String url=postUrl + "/api" + "/postulants/" + newpostulant.getId() + "/professionalprofile";
        String allProfessionalProfile=restTemplate.getForObject(url, String.class);
        log.info(allProfessionalProfile);
        assertTrue(!allProfessionalProfile.isEmpty());


    }


    @When("register his skills like <skill{int}> and <skill{int}>")
    public void registerHisSkillsLikeSkillAndSkill(int arg0, int arg1) {

    }

    @Then("I should be able to register my skills")
    public void iShouldBeAbleToRegisterMySkills() {
    }


}
