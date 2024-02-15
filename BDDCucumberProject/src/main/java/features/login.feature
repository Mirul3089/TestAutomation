#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Td Bank Login

 #without example keyword
  #Scenario: TD bank Login with invalid credintials
    #Given User is on login page
    #When title of login page is "EasyWeb Login"
#Then user enters invalid credentials "vdggdvgdvgd@vgdwdff" and "sbdvgd@vdvd"
#Then user clicks on login button
#Then user quit

#with examples keyword
Scenario Outline: TD bank Login with valid and invalid credintials
    Given User is on login page
    When title of login page is "EasyWeb Login"
Then user enters invalid credentials "<username>" and "<password>"
Then user clicks on login button
Then user quit

Examples:
      | username | passwword |
      | mirulp   | test@1223 |
      | 36738020202 | wggwefye |