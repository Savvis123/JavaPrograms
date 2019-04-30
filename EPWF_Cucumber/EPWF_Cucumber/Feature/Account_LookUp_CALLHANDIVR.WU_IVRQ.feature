Feature: Account LookUp

@Regression_Epwf
Scenario: Validate Account_LookUp_CALLHANDIVR.WU_IVRQ
	Given I have the request XML for "Account_LookUpRequest_CALLHANDIVR.CALLHANDIVR.WU_IVRQ"
	And I trigger it and check the account status
	Then I write account status to excel 
	
	