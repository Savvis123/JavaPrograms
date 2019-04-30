Feature: Submit Payment 

  @Regression_Epwf
  Scenario: validate IREPPAY_ENS_OneTime_CARD_Existing_WBG
    Given I have the request XML for "IREPPAY_ENS_OneTime_CARD_Existing_WBG"
    And I trigger it and launch the session URL 
    Then I make the payment based on payment type
	  Then I validate payment status from DB
	  Then I write the payment_id and payment status in excel
