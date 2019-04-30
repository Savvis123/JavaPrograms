Feature: Submit Payment
@Regression_Epwf
Scenario: Validate Qportal_autopay_Enrollment_ENS_CC_BMG_ACH
	Given I have the request XML for "Qportal_autopay_Enrollment_ENS_CC_BMG_ACH"
	And I trigger it and launch the session URL
	Then I make the payment based on payment type
	Then I validate payment status from DB
    Then I write the RECORD_STATUS in excel
	
