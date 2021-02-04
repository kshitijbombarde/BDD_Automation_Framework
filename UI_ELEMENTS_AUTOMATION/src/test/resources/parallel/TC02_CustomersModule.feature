Feature: CustomersModule

Background:
Given User has Already Logged into the application
|username|password|
|admin|pass|

Scenario: User is able to add new customer successfully
	Given User is on Dashboard
	When User clicks on Customers Button
	And  clicks on Add Customer Button
	Then Page Title will be "Customers"
	And User Toggles Approved_Switch
	And User will Enter the Login_Name as "user5"
	And User will Enter First_Name as "User"
	And User will Enter Last_Name as "Five"
	And User will Enter Email as "user@five.com"
	And User will Enter Password as "pass"
	And User will confirm Password as "pass"
	And User will Click on Save
	And TransactionsTab will get Visible on UI 
	
Scenario: User is able to delete customer
	Given User is on Dashboard
	When User clicks on Customers Button
	And User Deletes Customer with Id as "13"
	And Confirms the Delete Action