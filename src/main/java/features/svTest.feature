Feature: SV Tests

  @svtest1
  Scenario: Navigating to Call Leads Option
    Given Opening Web Page
    Then Enter username and password


  Scenario: Rest
    Then Click Submit
    Then Enter OTP
    Then Navigate to HP
    Then Select Brand HPotwoo
    Then Click on Lead Management
    Then Click on Call Leads
    Then Click on Filter Button
    Then Click on Export Button
    Then Return count of Initialize
    Then Print Message
    Then Close Browser

  @svtest2
  Scenario: Navigating to Form Leads Option
    Given Opening Web Page
    Then Enter username and password
    Then Click Submit
    Then Enter OTP
    Then Navigate to HP
    Then Select Brand HPotwoo
    Then Click on Lead Management
    Then Click on Form Leads
    Then Click on Export Button for Form Leads
    Then Print Message
    Then Close Browser