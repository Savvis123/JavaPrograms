Feature: Submit Payment
@Regression_Epwf1
Scenario: Validate CONPORT_EnrollAutopay_PPP_CC_CON_Paypal
Given I have the request XML for "CONPORT_EnrollAutopay_PPP_CC_CON_Paypal" 
And I trigger it and launch the session URL
Then I make the payment based on payment type
Then I validate payment status from DB
Then I write the RECORD_STATUS in excel

