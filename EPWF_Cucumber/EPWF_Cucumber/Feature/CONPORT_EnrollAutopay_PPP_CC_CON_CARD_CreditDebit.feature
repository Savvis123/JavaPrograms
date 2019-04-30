Feature: Submit Payment
@Regression_Epwf121
Scenario: Validate CONPORT_EnrollAutopay_PPP_CC_CON_CARD_CreditDebit
Given I have the request XML for "CONPORT_EnrollAutopay_PPP_CC_CON_CARD_CreditDebit" 
And I trigger it and launch the session URL
Then I make the payment based on payment type
Then I validate payment status from DB
Then I write the RECORD_STATUS in excel


	