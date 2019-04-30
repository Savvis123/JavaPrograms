Feature: Submit Payment

@Regression_Epwf12
Scenario: Validate Consmobile_Ensemble_OneTime_ACH_Existing
	Given I have the request XML for "Consmobile_Ensemble_OneTime_ACH_Existing" 
	And I trigger it and launch the session URL
	Then I make the payment based on payment type
	Then I validate payment status from DB
	Then I write the payment_id and payment status in excel
	