Feature: TC01_LoginModule

Scenario: User is able to Login with Correct Credentials
	Given User is on Admin Login Page
	When User enters username as "admin"
	And Password as "pass"
	And clicks on Login Button
	Then Page Title will be "Dashboard"