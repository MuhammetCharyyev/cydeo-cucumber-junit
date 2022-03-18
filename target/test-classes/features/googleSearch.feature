Feature: Google search functionality
  Agile story: As a User, when I'm on a Google search page,
  I should be able to search whatever I want and see relevant information

  Scenario: Search page title verification
    When User in on Google search page
    Then User should see title is Google

    Scenario: Search functionality result title verification
      Given User is on Google search page
      When User types apple and click enter
      Then User sees apple in the google title

  @wip
  Scenario: Search functionality result title verification
    Given User is on Google search page
    When User types "apple" and click enter
    Then User sees "apple" in the google title