Feature: Is there a film of that title in the database
  As a user, I want to check if there is a film with that same title so that I can confirm it exists.

  Scenario: The title matches an existing title in the database.
    Given Users chosen title
    When User is searching for a film
    Then The program returns the movie title