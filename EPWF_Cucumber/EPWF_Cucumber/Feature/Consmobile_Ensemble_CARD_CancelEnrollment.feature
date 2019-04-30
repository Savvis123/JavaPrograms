Feature: Submit Payment
@Regression_Epwf
Scenario: Validate Consmobile_Ensemble_CARD_Cancelenrollment
	Given I have the request XML for "Consmobile_Ensemble_CARD_Cancelenrollment"
	And I trigger it and launch the session URL
	Then I make the payment based on payment type and cancel the payment
