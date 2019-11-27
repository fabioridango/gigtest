@UITest
Feature: Account creation

  As an user
  I want to be able to create an account
  so I can access to website

# Unsuccessful create account blank required field
  Scenario Outline: Unsuccessful create account with blank last name in your personal information section
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name>" in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter address "<address>" in your address form
    And I enter city "<city>" in your address form
    And I select state "<state>" in your address form
    And I enter postcode "<postcode>" in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I click on register button
    Then I should see the error message "lastname is required."
    And I close browser

    Examples:
      | email address   | first name  | password | address | city   | state   | postcode | mobile phone |
      | gigtest5@gm.com | Mark     | 123456   |  aba    | Sliema | Florida | 12356    | 12455566     |


  Scenario Outline: Unsuccessful create account with blank first name in your personal information section
    Given I am on create account page with email address "<email address>"
    When I enter last name "<last name>" in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter address "<address>" in your address form
    And I enter city "<city>" in your address form
    And I select state "<state>" in your address form
    And I enter postcode "<postcode>" in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I click on register button
    Then I should see the error message "firstname is required."
    And I close browser

    Examples:
      | email address   | last name  | password | address | city   | state   | postcode | mobile phone |
      | gigtest5@gm.com | Lander     | 123456   |  aba    | Sliema | Florida | 12356    | 12455566     |


  Scenario Outline: Unsuccessful create account with blank email in your personal information section
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name>" in your personal information form
    And I enter last name "<last name>" in your personal information form
    And I enter blank email in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter address "<address>" in your address form
    And I enter city "<city>" in your address form
    And I select state "<state>" in your address form
    And I enter postcode "<postcode>" in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I click on register button
    Then I should see the error message "email is required."
    And I close browser

    Examples:
      | email address   | first name | last name  | password | address | city   | state   | postcode | mobile phone |
      | gigtest5@gm.com | Mark       | Lander     |  123456  |  aba    | Sliema | Florida | 12356    | 12455566     |


  Scenario Outline: Unsuccessful create account with blank password in your personal information section
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name>" in your personal information form
    And  I enter last name "<last name>" in your personal information form
    And I enter address "<address>" in your address form
    And I enter city "<city>" in your address form
    And I select state "<state>" in your address form
    And I enter postcode "<postcode>" in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I click on register button
    Then I should see the error message "passwd is required."
    And I close browser

    Examples:
      | email address   | first name | last name  | address | city   | state   | postcode | mobile phone |
      | gigtest5@gm.com | Mark       | Lander     |  aba    | Sliema | Florida | 12356    | 12455566     |


  Scenario Outline: Unsuccessful create account with blank address in your personal information section
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name>" in your personal information form
    And  I enter last name "<last name>" in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter city "<city>" in your address form
    And I select state "<state>" in your address form
    And I enter postcode "<postcode>" in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I click on register button
    Then I should see the error message "address1 is required."
    And I close browser

    Examples:
      | email address   | first name | last name | password | city   | state   | postcode | mobile phone |
      | gigtest5@gm.com | Mark       | Lander    |  123456  | Sliema | Florida | 12356    | 12455566     |


  Scenario Outline: Unsuccessful create account with blank city in your personal information section
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name>" in your personal information form
    And  I enter last name "<last name>" in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter address "<address>" in your address form
    And I select state "<state>" in your address form
    And I enter postcode "<postcode>" in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I click on register button
    Then I should see the error message "city is required."
    And I close browser

    Examples:
      | email address   | first name | last name | password | address | state   | postcode | mobile phone |
      | gigtest5@gm.com | Mark       | Lander    |  123456  | dddd    | Florida | 12356    | 12455566     |


  Scenario Outline: Unsuccessful create account with unselected state in your address section
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name>" in your personal information form
    And I enter last name "<last name>" in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter address "<address>" in your address form
    And I enter city "<city>" in your address form
    And I enter postcode "<postcode>" in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I click on register button
    Then I should see the error message "This country requires you to choose a State."
    And I close browser

    Examples:
      | email address   | first name | last name | password | address | city   | postcode | mobile phone |
      | gigtest5@gm.com | Mark       | Lander    |  123456  | ddd     | Sliema | 12356    | 12455566     |



  Scenario Outline: Unsuccessful create account with blank postcode in your address section
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name>" in your personal information form
    And I enter last name "<last name>" in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter address "<address>" in your address form
    And I enter city "<city>" in your address form
    And I select state "<state>" in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I click on register button
    Then I should see the error message "The Zip/Postal code you've entered is invalid. It must follow this format: 00000"
    And I close browser

    Examples:
      | email address   | first name | last name | password | address | city   | state   | mobile phone |
      | gigtest5@gm.com | Mark       | Lander    |  123456  | hhhh    | Sliema | Florida | 12455566     |


  Scenario Outline: Unsuccessful create account with blank mobile phone in your address section
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name>" in your personal information form
    And  I enter last name "<last name>" in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter address "<address>" in your address form
    And I enter city "<city>" in your address form
    And I select state "<state>" in your address form
    And I enter postcode "<postcode>" in your address form
    And I click on register button
    Then I should see the error message "You must register at least one phone number."
    And I close browser

    Examples:
      | email address   | first name | last name | password | address | city    | state   | postcode |
      | gigtest5@gm.com | Mark       | Lander    |  123456  | hhhh    | Sliema  | Florida | 12356    |


  Scenario Outline: Unsuccessful create account with blank country in your personal information section
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name>" in your personal information form
    And I enter first name "<first name>" in your personal information form
    And  I enter last name "<last name>" in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter address "<address>" in your address form
    And I enter city "<city>" in your address form
    And I select the blank option for country in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I click on register button
    Then I should see the error message "Country is invalid"
    And I close browser

    Examples:
      | email address   | first name | last name | password | address | city    | mobile phone |
      | gigtest5@gm.com | Mark       | Lander    |  123456  | hhhh    | Sliema  | 12455566     |


  Scenario Outline: Unsuccessful create account with blank address alias in your personal information section
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name>" in your personal information form
    And  I enter last name "<last name>" in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter address "<address>" in your address form
    And I enter city "<city>" in your address form
    And I select state "<state>" in your address form
    And I enter postcode "<postcode>" in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I enter blank address alias in your address form
    And I click on register button
    Then I should see the error message "alias is required."
    And I close browser

    Examples:
      | email address   | first name | last name | password | address | city   | state   | postcode |  mobile phone |
      | gigtest5@gm.com | Mark       | Lander    |  123456  | hhhh    | Sliema | Florida | 12356    |  12455566     |


# Unsuccessful create account invalid field
  Scenario Outline: Unsuccessful create account with invalid postcode in your address section
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name>" in your personal information form
    And I enter first name "<first name>" in your personal information form
    And  I enter last name "<last name>" in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter address "<address>" in your address form
    And I enter city "<city>" in your address form
    And I select state "<state>" in your address form
    And I enter postcode "<postcode>" in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I click on register button
    Then I should see the error message "The Zip/Postal code you've entered is invalid. It must follow this format: 00000"
    And I close browser

    Examples:
      | email address   | first name | last name | password | address | city   |   state   | postcode |  mobile phone |
      | gigtest5@gm.com | Mark       | Lander    |  123456  | ff      | Sliema |  Florida  |  00      |  12455566     |


  Scenario Outline: Unsuccessful create account with invalid password in your personal information section
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name>" in your personal information form
    And  I enter last name "<last name>" in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter address "<address>" in your address form
    And I enter city "<city>" in your address form
    And I select state "<state>" in your address form
    And I enter postcode "<postcode>" in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I click on register button
    Then I should see the error message "passwd is invalid."
    And I close browser

    Examples:
      | email address   | first name | last name | password | address | city   |   state   | postcode |  mobile phone |
      | gigtest5@gm.com | Mark       | Lander    |  123     | ff      | Sliema |  Florida  |  00000   |  12455566     |


  Scenario Outline: Unsuccessful create account with invalid mobile phone in your address section
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name>" in your personal information form
    And I enter first name "<first name>" in your personal information form
    And  I enter last name "<last name>" in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter address "<address>" in your address form
    And I enter city "<city>" in your address form
    And I select state "<state>" in your address form
    And I enter postcode "<postcode>" in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I click on register button
    Then I should see the error message "phone_mobile is invalid."
    And I close browser

    Examples:
      | email address   | first name | last name | password | address | city   |   state   | postcode |  mobile phone |
      | gigtest5@gm.com | Mark       | Lander    |  123567  | ff      | Sliema |  Florida  |  00000   |  aaaaa        |


  Scenario Outline: Unsuccessful create account with invalid email in in your personal information section
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name>" in your personal information form
    And  I enter last name "<last name>" in your personal information form
    And I enter email "<email>" in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter address "<address>" in your address form
    And I enter city "<city>" in your address form
    And I select state "<state>" in your address form
    And I enter postcode "<postcode>" in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I click on register button
    Then I should see the error message "email is invalid."
    And I close browser

    Examples:
      | email address   | first name | last name | password | address | city   |   state   | postcode |  mobile phone | email     |
      | gigtest5@gm.com | Mark       | Lander    |  123567  | ff      | Sliema |  Florida  |  00000   |  12455566     | gigtest4@ |


 # Successful create account
  Scenario Outline: Successful create account by filling all mandatory fields except the fields autofill
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name>" in your personal information form
    And I enter last name "<last name>" in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter address "<address>" in your address form
    And I enter city "<city>" in your address form
    And I select state "<state>" in your address form
    And I enter postcode "<postcode>" in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I click on register button
    Then I should see my account page
    And I close browser


    Examples:
      | email address     | first name  | last name  | password | address | city   | state   | postcode | mobile phone |
      | arap8@haqochh.com | Mark        | Lander     | 123456   |  aba    | Sliema | Florida | 12356    | 12455566     |


  Scenario Outline: Successful create account by filling all required fields
    Given I am on create account page with email address "<email address>"
    When I enter first name "<first name personal>" in your personal information form
    And I enter last name "<last name personal>" in your personal information form
    And I enter password "<password>" in your personal information form
    And I enter first name "<first name address>" in your address form
    And I enter last name "<last name address>" in your address form
    And I enter address "<address>" in your address form
    And I enter city "<city>" in your address form
    And I select state "<state>" in your address form
    And I enter postcode "<postcode>" in your address form
    And I enter mobile phone "<mobile phone>" in your address form
    And I enter address alias "<address alias>" in your address form
    And I click on register button
    Then I should see my account page
    And I close browser

    Examples:
      | email address     | first name personal | last name personal | password | first name address | last name address | address | city   | state   | postcode | mobile phone | address alias |
      | arap9@haqockk.com | Mark                | Lander             | 123456   |  Holly             | Benj              |  aba    | Sliema | Florida | 12356    | 12455566     | Triq ta       |