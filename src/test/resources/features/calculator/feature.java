Feature: Calculator sum service
  As a user
  I want to add two numbers using the /sum service
  So that I can get the correct result

  Scenario: Adding two positive numbers
    Given the application is running
    When I call the sum endpoint with parameters a=5 and b=6
    Then the response should be "11"

