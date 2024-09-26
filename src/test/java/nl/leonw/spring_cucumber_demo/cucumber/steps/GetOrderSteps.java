package nl.leonw.spring_cucumber_demo.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

public class GetOrderSteps {

    @When("the client calls {word}")
    public void the_client_calls_orders_does_not_exist(String path) {
        var restClient = RestClient.builder()
                .baseUrl("http://localhost:8080") // TODO configure random port
                .build();

        var response = restClient.get()
                .uri(path)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                // ignore 4xx errors otherwise we get an exception on body read. Useful IRL, not here.
                .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                });

        retrievedResponse = response.toEntity(String.class);
    }

    @Then("the status code is {int}")
    public void the_status_code_is(Integer expectedStatusCode) {
        var actualStatusCode = getResponse().getStatusCode().value();
        if (actualStatusCode != expectedStatusCode) {
            throw new IllegalStateException("Received status code " + actualStatusCode + " is not expected status code " + expectedStatusCode);
        }
    }

    @Then("there is no body")
    public void there_is_no_body() {
        if (getResponse().getBody() != null) {
            throw new IllegalStateException("Empty (null) body expected, but got " + getResponse().getBody());
        }
    }

    private ResponseEntity<String> getResponse() {
        if (retrievedResponse == null) {
            throw new IllegalStateException("Do the call before analyzing the result"); // you should start with the When
        }
        return retrievedResponse;
    }


    private ResponseEntity<String> retrievedResponse; // may be null
}
