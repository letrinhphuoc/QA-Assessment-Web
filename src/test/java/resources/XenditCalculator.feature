Feature: Test online calculator scenarios

  @Xendit-QA-Assessment
  Scenario Outline: Test subtraction, division and CE functionalities
    Given Open chrome browser and start application
    When I enter following values and press CE button
      | value1   | <value1>   |
      | value2   | <value2>   |
      | operator | <operator> |
    Then I should be able to see <expected>
    Examples:
      | value1     | value2 | operator | expected |
      | 0          | 1      | -        | -1       |
      | 2          | 1      | -        | 1        |
      | -999999999 | 1      | -        | -1e+9    |
      | 4          | 2      | /        | 2        |
      | 0          | 1      | /        | 0        |
      | 1          | 0      | /        | Error    |
      | 1          | 1      | +        | 2        |
      | 1          | 0      | +        | 1        |
      | 999999999  | 1      | +        | 1e+9     |
      | -1         | 2      | +        | 1        |
      | 2          | -1     | +        | 1        |