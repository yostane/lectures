Feature: Simple Web Interaction

  Scenario: Visiting google.com
    Given Open Browser
    When navigate to google.com
    Then Validate the Google page is open
    And Close the browser