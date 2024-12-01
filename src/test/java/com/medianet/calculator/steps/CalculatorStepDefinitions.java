package com.medianet.calculator.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorStepDefinitions {

    @LocalServerPort
    private int port;

    private String response;

    @Given("the application is running")
    public void theApplicationIsRunning() {
        // This step ensures that the application context is loaded
        assert port > 0;
    }

    @When("I call the sum endpoint with parameters a={int} and b={int}")
    public void iCallTheSumEndpointWithParameters(int a, int b) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("http://localhost:%d/sum?a=%d&b=%d", port, a, b);
        response = restTemplate.getForObject(url, String.class);
    }

    @Then("the response should be {string}")
    public void theResponseShouldBe(String expectedResponse) {
        assertEquals(expectedResponse, response, "The response did not match the expected result.");
    }
}
