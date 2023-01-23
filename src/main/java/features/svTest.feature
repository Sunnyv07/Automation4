Feature: SV Tests

  @svtest1
  Scenario: Checking re-usability of functions with driver
    Given Opening Web Page
    Then Enter username and password


  Scenario: Rest
    Then Click Submit
    Then Enter OTP
    Then Navigate to HP
    Then Select Brand HP020
    Then Click on Lead Management
    Then Click Lead Task Management
    Then Click on Call lead Radio button
    Then Print Message
    Then Close Browser