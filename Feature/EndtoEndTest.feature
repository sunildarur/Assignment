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
Feature: End to End Test
	Testing End to End Functionality for the Application

@tag1
Scenario: Successful Login with Valid Credentials
Given User is on Home Page
When User Navigate to Login Page
And User enters Username and Password
Then Message displayed LoginApp Successful
When User doesnot enter FirstName
Then Message displayed Please fill FirstName
When User enters Applicant Information
Then Message displayed Applicant Information Saved

@tag2
Scenario: Successful ErrorMessage with InValid Credentials
Given User is on Home Page
When User Navigate to Login Page
And User enters invalid Username and Password
Then Message displayed Login UnSuccessful