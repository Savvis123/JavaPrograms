Feature: Submit Payment

@Regression_Epwf
Scenario: Validate SubmitPayment_MARLIE_CRIS_OneTime_MAR_PAY_CARD_Business(SBG WBG BGS)
	Given I have the request XML for "SubmitPayment_MARLIE_CRIS_OneTime_MAR_PAY_CARD_Business(SBG WBG BGS)" 
	And I trigger it and get the payment Id
	Then I validate payment status from DB
	Then I write the payment_id and payment status in excel
	
