package nl.leonw.spring_cucumber_demo.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetOrderSteps {
    @When("the client calls \\/orders\\/does-not-exist")
    public void the_client_calls_orders_does_not_exist() {
    }
    @Then("the status code is {int}")
    public void the_status_code_is(Integer expectedStatusCode) {
    }
    @Then("the body is empty")
    public void the_body_is_empty() {
    }
}
