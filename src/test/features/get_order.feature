Feature: Retrieve an individual order

# Working with feature files in IntelliJ works best with the cucumber plugin installed

  Scenario: Requesting a non-existing order returns HTTP code 404 and no body

  Scenario: Requesting a existing order returns HTTP code 200 with the order data in the body in JSON format

  Scenario: Creating an order returns a http 404 as this is not supported

  Scenario: Updating an order returns a http 404 as this is not supported
