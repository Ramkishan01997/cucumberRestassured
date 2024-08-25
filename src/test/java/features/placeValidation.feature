Feature: validating add place api call

  Scenario Outline: verify place is being added sucessfully using post api call of add place api
      Given: Add place payload "<name>" "<language>" "<address>"
      When: user calls "AddPlaceAPI" with "post" request
      Then: Api call got sucess with status code 200
      And: "status" in response body is "ok"
      And: "scope" in response body is "App"

Examples:
        |name    |language   |address   |
        |Arhouse  |English   |World cross center |