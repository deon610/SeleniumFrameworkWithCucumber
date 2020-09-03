Feature: SauceDemoLogin.feature
  As an user,
  I want to verify that
  the user is able to login

  @Regression
  Scenario Outline: User logins with correct credentials
    Given User has navigated to application
    When Login to the application
    Then Verify the title is '<Title>'
    And Add product to the cart
    And Logout of the application

    Examples: 
      | Title     |
      | Swag Labs |

      
  @Regression
  Scenario: User logins with correct credentials
    Given User has navigated to application
    When Login to the application with wrong credentials
    Then Verify user cannot login
