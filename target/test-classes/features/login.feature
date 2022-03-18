@Regression @smoke @login
Feature: Library app Login feature
  User Story:
  As a user, I should be able to login with correct credentials to different
  accounts. And dashboard should be displayed.

  Accounts are: librarian, student, admin

  Background: For the scenarios in this feature file user is expected to be on login page
  #Background is like precondition or BeforeMethod in TestNG
    Given user is on the library login page
   #we got same wording for Given for all users below
   # and it goes as Background for whole test

  @librarian @employee @wip #you can call 'either by 'librarian' or by 'employee'
    #wip means "work in progress"
  Scenario: Login as librarian
    When user enters librarian username
    And user enters librarian password
    Then user should see the dashboard


  @student @db
  Scenario: Login as student
    When user enters student username
    And user enters student password
    Then user should see the dashboard

  @admin @employee #you can call 'either by 'admin' or by 'employee'
  Scenario: Login as admin
    When user enters admin username
    And user enters admin password
    Then user should see the dashboard
#comments with adding #


