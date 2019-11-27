@UITest
Feature: User authentication

  As an user
  I want to be able to authenticate an already registered user or by create account
  so I can access to website

  # Authentication Account already registered
  Scenario Outline: Successful login with valid credentials
    Given I am on authenticate page
    When I sign in with email address "<email address>" and password "<password>"
    Then I should be redirected on my account page

    Examples:
      | email address   | password  |
      | gigtest@gm.com  | jerod79FA |

  Scenario Outline: Unsuccessful login with invalid email address and invalid password
    Given I am on authenticate page
    When I sign in with email address "<email address>" and password "<password>"
    Then I should see the "Authentication failed." error message

    Examples:
      | email address | password |
      | gig@gm.com    | 123456   |

  Scenario Outline: Unsuccessful login with valid email address and invalid password
    Given I am on authenticate page
    When I sign in with email address "<email address>" and password "<password>"
    Then I should see the "Authentication failed." error message

    Examples:
      | email address   | password |
      | gigtest@gm.com  | 123456   |

  Scenario Outline: Unsuccessful login with invalid email address and valid password
    Given I am on authenticate page
    When I sign in with email address "<email address>" and password "<password>"
    Then I should see the "Authentication failed." error message

    Examples:
      | email address | password  |
      | gig@gm.com    | jerod79FA |

  Scenario Outline: Unsuccessful login with valid email address and invalid password format
    Given I am on authenticate page
    When I sign in with email address "<email address>" and password "<password>"
    Then I should see the "Invalid password." error message

    Examples:
      | email address  | password |
      | gigtest@gm.com | 123      |

  Scenario Outline: Unsuccessful login with invalid email address format and valid password
    Given I am on authenticate page
    When I sign in with email address "<email address>" and password "<password>"
    Then I should see the "Invalid email address." error message

    Examples:
      | email address | password  |
      | gig@gm        | jerod79FA |

  Scenario: Unsuccessful login with blank email address and password
    Given I am on authenticate page
    When I sign in with blank email address and password
    Then I should see the "An email address required." error message

  Scenario Outline: Unsuccessful login with blank password
    Given I am on authenticate page
    When I sign in with email address "<email address>" and blank password
    Then I should see the "Password is required." error message

    Examples:
      | email address   |
      | gigtest@gm.com  |

  Scenario Outline: Unsuccessful login with blank email address
    Given I am on authenticate page
    When I sign in with blank email address and password "<password>"
    Then I should see the "An email address required." error message

    Examples:
      | password  |
      | jerod79FA |

    # Authentication Create Account
  Scenario Outline: Successful email address validation with valid email address in create an account form
    Given I am on authenticate page
    When I want create an account with email address "<email address>"
    Then I should be redirected on account creation page

    Examples:
      | email address   |
      | gigtest3@gm.com |

  Scenario Outline: Unsuccessful email address validation with invalid email address format in create an account form
    Given I am on authenticate page
    When I want create an account with email address "<email address>"
    Then I should see an "Invalid email address." error message

    Examples:
      | email address |
      | Daniel@test   |

  Scenario Outline: Unsuccessful email address validation with email address already registered in create an account form
    Given I am on authenticate page
    When I want create an account with email address "<email address>"
    Then I should see an "An account using this email address has already been registered. Please enter a valid password or request a new one." error message

    Examples:
      | email address  |
      | gigtest@gm.com |

  Scenario Outline: Unsuccessful email address validation with blank email address in create an account form
    Given I am on authenticate page
    When I want create an account with email address "<email address>"
    Then I should see an "Invalid email address." error message

    Examples:
      | email address |
      | Daniel@test   |


