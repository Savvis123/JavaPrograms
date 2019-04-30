
Feature: Account LookUp

@Regression_Epwf
Scenario: Validate Account_LookUp_DVAR_EQPOS_True
	Given I have the request XML for "Account_LookUpRequest_DVAR.EQPOS.true" 
	And I trigger it and check the account status
	Then I write account status to excel 
