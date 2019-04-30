Feature: Submit Payment 

  @Regression_Epwf
  Scenario: validate NETWORX_LATIS_OneTime_CARD_New_DoNotSaveToWallet_NWX
    Given I have the request XML for "NETWORX_LATIS_OneTime_CARD_New_DoNotSaveToWallet_NWX" 
    And I trigger it and launch the session URL 
    Then I make the payment based on payment type
	  Then I validate payment status from DB
	  Then I write the payment_id and payment status in excel
