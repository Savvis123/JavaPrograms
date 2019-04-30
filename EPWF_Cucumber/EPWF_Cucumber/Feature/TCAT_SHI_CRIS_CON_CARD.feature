Feature: TCAT_SHI_CHASE

@Sanity_ITv1
Scenario Outline: Validate TCAT_SHI_CRIS_CON_CARD_ITv1
Given I have the request XML for "TCAT_SHI_CRIS_CON_CARD" to be run on "<Environment>"
And I trigger it and launch the session URL
Then I make the payment based on payment type
Then I validate payment status from DB
Then I write the payment_id and payment status in excel

Examples:
|Environment|
	|ITv|

@Sanity_ITv2
Scenario Outline: Validate TCAT_SHI_CRIS_CON_CARD_ITv2
Given I have the request XML for "TCAT_SHI_CRIS_CON_CARD" to be run on "<Environment>"
And I trigger it and launch the session URL
Then I make the payment based on payment type
Then I validate payment status from DB
Then I write the payment_id and payment status in excel

Examples:
|Environment|
	|ITv2|
	
@Sanity_ITv3
Scenario Outline: Validate TCAT_SHI_CRIS_CON_CARD_ITv3
Given I have the request XML for "TCAT_SHI_CRIS_CON_CARD" to be run on "<Environment>"
And I trigger it and launch the session URL
Then I make the payment based on payment type
Then I validate payment status from DB
Then I write the payment_id and payment status in excel

Examples:
|Environment|
	|ITv3|
	
@Sanity_e2e
Scenario Outline: Validate TCAT_SHI_CRIS_CON_CARD_e2e
Given I have the request XML for "TCAT_SHI_CRIS_CON_CARD" to be run on "<Environment>"
And I trigger it and launch the session URL
Then I make the payment based on payment type
Then I validate payment status from DB
Then I write the payment_id and payment status in excel

Examples:
|Environment|
	|e2e|