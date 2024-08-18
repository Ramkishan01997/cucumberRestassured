Feature: validating add place api call

  Scenario: verify place is being added sucessfully using post api call of add place api
      Given: Add place payload
      When: user calls "AddPlaceAPI" with post request
      Then: Api call got sucess with status code 200
      And: "status" in response body is "ok"
      And: "scope" in response body is "App"

