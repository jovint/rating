Feature: Rating Control
    Scenario: Rating control decision to read book
        Given I am a customer whose rating control level is 8
        When I request to read book with id 1234
        Then I get the decision