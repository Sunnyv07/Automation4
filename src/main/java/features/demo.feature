Feature: Test

  @Test1
  Scenario: test 1
    Given Opening Web Page
    Then Print Message
    Then Close Browser

  @Test2
  Scenario: test 2
    Given Opening Web Page
    Then Enter username and password
    Then Print Message
    Then Close Browser

  @Test3
  Scenario: test 3
    Given Opening Web Page
    Then Enter username and password
    Then Click Submit
    Then Print Message
    Then Close Browser

  @Test4

