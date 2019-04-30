Feature: Submit Payment
@Regression_Epwf
Scenario: Validate MYAccount_CRIS_Autopay_Enrollment_Update_CARD_SaveToWallet 
	Given I have the request XML for "MYAccount_CRIS_Autopay_Enrollment_Update_CARD_SaveToWallet" 
	And I trigger it and launch the session URL
	Then I Choose the method of payment
    Then I Update and validate the account 
     Then I validate payment status from DB
    Then I write the SERVICE ACTION STATUS in excel
    

	