Feature: Wikipedia search functionality and verifications

  #WSF-45234

  Scenario: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When User types "Bill Gates" in the wiki search box
    And User clicks wiki search button
    Then User sees "Bill Gates" is in the wiki title

  Scenario: Wikipedia Search Functionality Header Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header

  Scenario Outline: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    Then User sees "<expectedMainHeader>" is in the main header
    @onePart
    Examples: search values we are going to be using in this scenario is as below
      | searchValue  | expectedTitle | expectedMainHeader |
      | Steve Jobs   | Steve Jobs    | Steve Jobs         |
      | Bob Marley   | Bob Marley    | Bob Marley         |
      | Chuck Norris | Chuck Norris  | Chuck Norris       |
    @anotherPart
    Examples:
      | searchValue     | expectedTitle   | expectedMainHeader |
      | Marie Curie     | Marie Curie     | Marie Curie        |
      | Anthony Hopkins | Anthony Hopkins | Anthony Hopkins    |

    #creating table using searchValue, expectedTitle, expectedMainHeader,
    # as parameters to put into  search box of Wiki to find one name by one