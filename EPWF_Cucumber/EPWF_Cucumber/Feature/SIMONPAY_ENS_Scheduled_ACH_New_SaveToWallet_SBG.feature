Feature: Submit Payment 

@Regression_Epwf
  Scenario: validate SIMONPAY_ENS_Scheduled_ACH_New_SaveToWallet_SBG
    Given I have the request XML for "SIMONPAY_ENS_Scheduled_ACH_New_SaveToWallet_SBG" 
    And I trigger it and launch the session URL 
    Then I make the payment based on payment type
	  Then I validate payment status from DB
	  Then I write the payment_id and payment status in excel

