Feature: Submit Payment

@Regression_Epwf
Scenario: Validate TCAT_SBP_CRIS_CON_CARD
	Given I have the request XML for "TCAT_SBP_CRIS_CON_CARD" 
	And I trigger it and launch the session URL
	Then I make the payment based on payment type
	Then I Extract the TokenId from the Url and write it in Excel
	Then I have the request XML for "TCAT_Token_SBP_CRIS_CON_CARD"
	And I trigger it and launch the session URL

