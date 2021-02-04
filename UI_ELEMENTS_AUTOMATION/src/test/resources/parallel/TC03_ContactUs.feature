@skip
Feature: Contact Us

Scenario Outline: Contact Us scenario with different set of Data
	Given A User navigates to ContactUs Page
	When user fills the form from the given sheetname "<SheetName>" and rownumber = <RowNumber>
	And User Click on Send Button
	Then It Shows a Successful Message as "Your enquiry has been successfully sent to the store owner!"
	
Examples:
|SheetName|RowNumber|
|ContactUs|0|
|ContactUs|1|