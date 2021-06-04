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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LinkInterviewSteps {

    @LocalServerPort
    private int port;
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

    @Given("I register the interview link {string}")
    public void i_register_the_interview_link(String link) {

        String url=postUrl + "/api" + "/postulants/" + 9 + "/interviews";
        LocalDate data=LocalDate.now();
        Postulant postulant=new Postulant();
        Interview newInterview=new Interview();
        newInterview.setId(interviewId);
        newInterview.setDate_Interview(data);
        newInterview.setFinal_date_Interview(data);
        newInterview.setLink_Interview(link);
        newInterview.setPostulant(postulant);


        Interview interview=restTemplate.postForObject(url,newInterview,Interview.class);
        interviewId=interview.getId();
        success="successful access to the platform";
        log.info(interview);
        assertNotNull(interview);
    }

    @Then("I want to see the {string}")
    public void i_want_to_see_the(String string) {
        assertEquals(success,string);
    }
}
