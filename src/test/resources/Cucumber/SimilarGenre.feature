Feature: Search for related genres given genre as input
  As a user, I would like to be able to choose a genre of movie so that I can have movies of that genre recommended.

  Scenario: I successfully have been recommended movies of my chosen genre.
    Given Users chosen movie genre
    When Users search for a genre
    Then The program returns movies of the same genre