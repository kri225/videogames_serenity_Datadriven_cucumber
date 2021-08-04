Feature: Testing different request on the Videogame application

  Scenario: Check if the videogame application can be access by users
    When user sends a get request to endpoint, they must get back a valid status code 200

Scenario Outline: Create a new videogame and verify if the videogame is added
  When I create a new videogame by providing the information id"<id>" name"<name>" releaseDate"<releaseDate>" reviewScore"<reviewScore>" category"<category>" rating"<rating>"
  Then I should be able to verify videogame with "<id>" is created
  Examples:
    | id | name | releaseDate | reviewScore | category | rating |
|5|Yakitri  |2021-08-01T10:02:16.369Z|59|Cardguard |5       |

  Scenario: Update a videogame and verify it has been updated
    When I update a vidogame by providing new "<name>" category rating
    Then I verify product is updated

  Scenario: Delete a created videogame & verify the videogame is deleted
    When I delete a created videogame ,they must get back a valid status code  is 200
    Then I verify the videogame is deleted




