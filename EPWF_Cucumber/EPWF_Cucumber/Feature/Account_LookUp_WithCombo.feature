Feature: Account LookUp

@Regression_Epwf
Scenario: Validate Account_LookUp_WithCombo
	Given I have the request XML for "Account_LookUp_WithCombo" 
	And I trigger it and check the account status
	Then I write account status to excel 
	