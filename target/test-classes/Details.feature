Feature: Details API
#This is Cucumber feature file which uses for the BDD

  # - Scenario defines the functionality that is going to be tested.
  @TestIshan
  Scenario: Send API call to Details-API and verify the result
    #When key word uses to show the action under the flow of scenario
    When I send the "GET" request to the endpoint "DetailsAPI" with below parameter
      | catalogue | false |
    #Then key word uses to show the verification points
    Then I should receive response with below details for "DetailsAPI"
      | Status_code     | 200             |
      | Name            | Carbon credits  |
      | CanRelist       | true            |
      | Node_Name       | Promotions      |
      | Promotions_Name | Gallery         |
      | Description     | 2x larger image |
    #There are many keywords use in cucumber feature file with different
    # requirement based on scenarios.
    # Example: Background, Given, Scenario Outline, Examples, And