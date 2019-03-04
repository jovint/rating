package com.bookstore.rating.cucumber.glue;

import com.bookstore.rating.RatingApplication;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import io.restassured.response.Response;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@SpringBootTest(classes = RatingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RatingControlStepDefinitions implements En {

    private String customerControlLevel;
    private Response ratingControlServiceResponse;
    private ResponseEntity<String> responseEntity;

    @Autowired
    private TestRestTemplate testRestTemplate;


    public RatingControlStepDefinitions(){

        Given("I am a customer whose rating control level is (.*)$", (String customerLevel) -> {
           customerControlLevel = customerLevel;
        });

        When("I request to read book with id (.*)$", (String bookID) -> {
           responseEntity = testRestTemplate
                    .getForEntity("/getdecision/"+customerControlLevel+"/"
                            +bookID,String.class);
        });

        Then("I get the decision", () -> {
           assertThat("response status is not 200",responseEntity.getStatusCode(),is(200));
        });
    }
}
