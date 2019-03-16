Feature: Main search

  Narrative:
  In order find available flights
  As a client of https://www.vueling.com/es
  I want to be able to search flights

  Scenario: Initial search
    Given I'm main page
    When I try to find a flight
      | origin  | destination | outboundDate | returnDate | passengers |
      | Almeria | Alicante    | NEXT_WEEK    |            | 1          |
    Then I get available flight
