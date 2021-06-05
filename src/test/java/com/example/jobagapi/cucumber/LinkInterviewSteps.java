package com.example.jobagapi.cucumber;

import com.example.jobagapi.domain.model.Interview;
import com.example.jobagapi.domain.model.Postulant;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LinkInterviewSteps {

    @LocalServerPort

    private RestTemplate restTemplate = new RestTemplate();
    private String postUrl="http://localhost:8080";
    private Long interviewId=1l;
    private String success=null;




    @Given("I am in the interview section")
    public void iAmInTheInterviewSection() {

        String url=postUrl + "/api" + "/postulants/" + 1 + "/interviews";
        String allInterviews=restTemplate.getForObject(url, String.class);
        log.info(allInterviews);
        assertTrue(!allInterviews.isEmpty());
    }

    public String randomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        return generatedString;
    }

    @And("I register the interview link {string}")
    public void i_register_the_interview_link(String link) {
        Postulant newpostulant = new Postulant(1L, "firstname", "lastname", randomString(), 123L, "password","document","civil");
        String url2=postUrl+"/api" +"/postulants";
        Postulant postulant=restTemplate.postForObject(url2,newpostulant,Postulant.class);

        log.info(postulant);
        String url=postUrl + "/api" + "/postulants/" + 2 + "/interviews";
        LocalDate data=LocalDate.now();
        Interview newInterview=new Interview();
        newInterview.setId(interviewId);
        newInterview.setDate_Interview(data);
        newInterview.setFinal_date_Interview(data);
        newInterview.setLink_Interview(link);
        newInterview.setPostulant(newpostulant);


        Interview interview=restTemplate.postForObject(url,newInterview,Interview.class);

        success="successful access to the platform";
        log.info(interview);

        assertNotNull(interview);
    }

    @Then("I want to see the {string}")
    public void i_want_to_see_the(String string) {
        assertEquals(success,string);




    }

}
