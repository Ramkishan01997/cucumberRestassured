Feature: Validating Place API's

  @AddPlace @Regression
  Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
    Given Add Place Payload with "<name>"  "<language>" "<address>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaceAPI"

    Examples: 
      | name    | language | address            |
      | AAhouse | English  | World cross center |

  #	|BBhouse | Spanish  |Sea cross center  |
  @DeletePlace @Regression
  Scenario: Verify if Delete Place functionality is working
    Given DeletePlace Payload
    When user calls "deletePlaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
@User
  Scenario: Verify user creation is working
    Given add user payload with "name" and "job"
    When user call "createAPI" api with "POST" request
    Then the api call got success with status code 201
    And verify that response having "name" , "job" and id
