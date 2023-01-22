Feature: Validating Place API

  @addPlace
  Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When User calls "AddPlaceAPI" with "POST" http request
    Then The API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaceAPI"

  Examples:
    |name      |language |address            |
    |My house  |English  |World Cross Center |
    |Your house|Spanish  |Poslednij Pereulok |

  @deletePlace
  Scenario: Verify if Delete Place functionality is working
    Given DeletePlace Payload
    When User calls "deletePlaceAPI" with "POST" http request
    Then The API call got success with status code 200
    And "status" in response body is "OK"
