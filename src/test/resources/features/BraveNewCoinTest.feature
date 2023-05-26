@Brave
Feature: BraveNewCoin API scenarios: POST GetToken

    Scenario: As a user, I can retrieve a token when making a valid POST request
        Given I have a valid API key for the https://bravenewcoin.p.rapidapi.com URI
        When I send a POST request with a valid TokenRequestBody payload to the /oauth/token endpoint
        Then I can validate I received a valid token in the response
   
    Scenario: As a user, I can retrieve a token when making a valid POST request
        Given I have an invalid API key for the https://bravenewcoin.p.rapidapi.com URI
        When I send a POST request with a valid TokenRequestBody payload to the /oauth/token endpoint
        Then I receive an HTTP code status 429

    Scenario: As a user, when I send a POST request without "grant_type", I get an HTTP code status 400
        Given I have a valid API key for the https://bravenewcoin.p.rapidapi.com URI
        When I send a POST request without 'grant_type' in it's body to the /oauth/token endpoint
        Then I receive an HTTP code status 400