Feature: QPORTAL_CRIS_LATIS_LATIS_MULTIPAYMENT

@Sanity_ITv1
Scenario Outline: Validate QPORTAL_CRIS_LATIS_LATIS_OneTime_ACH_New_DoNotSaveToWallet_CON_ITv1
	Given I have the request XML for "QPORTAL_CRIS_LATIS_LATIS_OneTime_ACH_New_DoNotSaveToWallet_CON" to be run on "<Environment>"
	And I trigger it for Qportal and launch the session URL
	Then I make the payment based on payment type
	Then I validate payment status from DB 
	
Examples:
|Environment|
	|ITv1|
	
@Sanity_ITv2 
Scenario Outline: Validate QPORTAL_CRIS_LATIS_LATIS_OneTime_ACH_New_DoNotSaveToWallet_CON_ITv2
	Given I have the request XML for "QPORTAL_CRIS_LATIS_LATIS_OneTime_ACH_New_DoNotSaveToWallet_CON" to be run on "<Environment>"
	And I trigger it for Qportal and launch the session URL
	Then I make the payment based on payment type
	Then I validate payment status from DB 
	
Examples:
|Environment|
	|ITv2|

@Sanity_ITv3 
Scenario Outline: Validate QPORTAL_CRIS_LATIS_LATIS_OneTime_ACH_New_DoNotSaveToWallet_CON_ITv3
	Given I have the request XML for "QPORTAL_CRIS_LATIS_LATIS_OneTime_ACH_New_DoNotSaveToWallet_CON" to be run on "<Environment>"
	And I trigger it for Qportal and launch the session URL
	Then I make the payment based on payment type
	Then I validate payment status from DB 
	
Examples:
|Environment|
	|ITv3|

@Sanity_e2e 
Scenario Outline: Validate QPORTAL_CRIS_LATIS_LATIS_OneTime_ACH_New_DoNotSaveToWallet_CON_e2e
	Given I have the request XML for "QPORTAL_CRIS_LATIS_LATIS_OneTime_ACH_New_DoNotSaveToWallet_CON" to be run on "<Environment>"
	And I trigger it for Qportal and launch the session URL
	Then I make the payment based on payment type
	Then I validate payment status from DB 
	
Examples:
|Environment|
	|e2e|
	
