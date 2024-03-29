Feature: NBA Warrior

  @smoke
  Scenario Outline: Get NBA footer links
    Given Open '<Browser>'
    Given Open '<Browser>' and load 'NBA Bulls' URL
    When Page is Loaded
    Then Navigate to footer
    Then Get all footer links
    Then Export to csv file

    Examples:
      | Browser |
      | Firefox  |
      | Chrome  |
      | Edge  |