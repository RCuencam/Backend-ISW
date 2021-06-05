package com.example.jobagapi.cucumber;

import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.model.JobOffer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.jni.Local;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Random;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ApplyJobSteps {

    @LocalServerPort
    private int port;
    private RestTemplate restTemplate = new RestTemplate();
    private String postUrl="http://localhost:8080";

    private Long jobOfferId=1L;
    private String error=null;

    @Given("I want a new job")
    public void iWantANewJob() {
        String url=postUrl + "/api/employeer/" + 2 + "/joboffers";
        String allJobs=restTemplate.getForObject(url, String.class);
        log.info(allJobs);
        assertTrue(!allJobs.isEmpty());
    }

    public String randomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        return generatedString;
    }

    @Given("The job offer have a stable minimum {long} and {long}")
    public void the_job_offer_have_a_stable_minimum_and(Long salary, Long id) {
        String employeerurl=postUrl + "/api/employeers";

        LocalDate data=LocalDate.now();
        String employeerUrl=postUrl+"/api/employeers";
        Employeer newEmployeer=new Employeer(id,"example","example","example",123L,"example","example","example");
        Employeer employeer=restTemplate.postForObject(employeerUrl,newEmployeer,Employeer.class);
        String url=postUrl + "/api/employeers/" + 1 + "/joboffers";
        JobOffer newJob= new JobOffer();
        newJob.setId(id);
        newJob.setSalary(salary);
        newJob.setDescription("asd");
        newJob.setBegin_date_offer(data);
        newJob.setFinal_date_offer(data);
        newJob.setDirection("aea");
        newJob.setEmployeer(employeer);


        JobOffer job=restTemplate.postForObject(url,newJob,JobOffer.class);
        log.info(job);
        assertNotNull(job);
    }


    @Then("I should be able to see my newly job")
    public void iShouldBeAbleToSeeMyNewlyJob() {
        String url=postUrl + "/api/jobOffer/" + jobOfferId + "/employeer/1";
        JobOffer job=restTemplate.getForObject(url,JobOffer.class);
        assertNotNull(job);
    }

    @Given("The job offer have a low minimum {long}")
    public void the_job_offer_have_a_low_minimum(Long salary) {
        String url=postUrl + "/api/employeers/" + 2 + "/joboffers";
        LocalDate data=LocalDate.now();
        Employeer employeer=new Employeer();
        log.info(salary);
        JobOffer newJob= new JobOffer();
        newJob.setId(jobOfferId);
        newJob.setSalary(salary);
        newJob.setDescription("asd");
        newJob.setBegin_date_offer(data);
        newJob.setFinal_date_offer(data);
        newJob.setDirection("aea");
        newJob.setEmployeer(employeer);

        try
        {
            JobOffer job=restTemplate.postForObject(url,newJob,JobOffer.class);
            log.info(job);
        }catch(RestClientException e){
            error="El salario debe ser mayor o igual a 930";
        }
        assertEquals(error,"El salario debe ser mayor o igual a 930");
    }
    @Then("I should be able to see {string}")
    public void i_should_be_able_to_see(String errorMessage) {
        assertEquals(errorMessage,error);
    }

}
