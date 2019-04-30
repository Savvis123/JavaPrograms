Feature: Submit Payment
@Regression_Epwf
Scenario: Validate MYAccount_CRIS_ACH_Cancelenrollment
	Given I have the request XML for "MYAccount_CRIS_ACH_Cancelenrollment" 
	And I trigger it and launch the session URL
	Then I make the payment based on payment type and cancel the payment
