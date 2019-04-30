Feature: Account LookUp

@Regression_Epwf
Scenario: Validate Account_Lookup_CMT
	Given I have the request XML for "Account_LookUpRequest_CMT" 
	And I trigger it and check the account status
	Then I write account status to excel 
	
	
	