Feature: Refund Payment

@Regression_Epwf
Scenario: Validate RRefund_MARLIE_EPP_OneTime_MAR_SCH
	Given I have the request XML for "SubmitPayment_MARLIE_CRIS_OneTime_MAR_SCH_CARD_CON" 
	And I trigger it and get the payment Id
	Then I validate payment status from DB
	Then I write the payment_id and payment status in excel
	Given I have the request XML for "Refund_MARLIE_EPP_OneTime_MAR_SCH" 
	And I trigger it and get the payment Id
	Then I validate payment status from DB
	Then I write the payment_id and payment status in excel
