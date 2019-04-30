Feature: Refund Payment

@Regression_Epwf
Scenario: Validate Refund_MARLIE_EPP_OneTime_MAR_PAY_ACTUATED
	Given I have the request XML for "SubmitPayment_MARLIE_CRIS_OneTime_MAR_PAY_CARD_CON" 
	And I trigger it and get the payment Id
	Then I validate payment status from DB
	Then I write the payment_id and payment status in excel
	Given I have the request XML for "Refund_MARLIE_EPP_OneTime_MAR_PAY_ACTUATED" 
	And I trigger it and get the payment Id
    Then I validate payment status from DB
	Then I write the payment_id and payment status in excel
	
	
