# spring-cucumber-demo

An example of creating an integration test with Cucumber for a Spring application.

## The Test Pyramid

In the test pyramid you have the low lever junit tests, medium level integration tests, and end-to-end tests.
This project demos the integration test - we test this application in it's entirety, including the 'real' database, 
but mock all external systems. This type of testing is particularly useful if your code needs to take decisions based 
on data that is distributed over the network. 

### Why Cucumber

Using Cucumber adds a layer of abstraction so that the text of the test can more clearly communicate 
what the important parameters are. And if done well Cucumber test results can be pushed to Confluence 
and form living, verified, documentation on the behaviour of your system.


## Running

Just run mvn clean verify on the command line.