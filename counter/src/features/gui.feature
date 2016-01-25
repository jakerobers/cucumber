Feature: User Interface Validation
  Validating the user interface will make sure that the
  buttons and the labels match. Additionally, other extraneous
  functionality will be validated (such as exiting the program).

  Scenario: Pressing the x_incr button
    Given the current x_incr count is 0
    When the x_incr button is pressed 1 times
    Then the xcount should be 1

  Scenario: Pressing the y_incr button
    Given the current y_incr count is 0
    When the y_incr button is pressed 1 times
    Then the ycount should be 1

  Scenario: Pressing the x_incr button thrice
    Given the current x_incr count is 1
    When the x_incr button is pressed 2 times
    Then the xcount should be 3

