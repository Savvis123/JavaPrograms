Feature: Consmobile_CRIS_OneTime_ACH


@Sanity_ITv1
Scenario Outline: Validate Consmobile_CRIS_OneTime_ACH_New_DoNotSaveToWallet_ITv1
	Given I have the request XML for "Consmobile_CRIS_OneTime_ACH_New_DoNotSaveToWallet" to be run on "<Environment>"
	And I trigger it and launch the session URL
	Then I make the payment based on payment type
	Then I validate payment status from DB
	Then I write the payment_id and payment status in excel
	
Examples:
|Environment|
	|ITv1|
	
@Sanity_ITv2
Scenario Outline: Validate Consmobile_CRIS_OneTime_ACH_New_DoNotSaveToWallet_ITv2
	Given I have the request XML for "Consmobile_CRIS_OneTime_ACH_New_DoNotSaveToWallet" to be run on "<Environment>"
	And I trigger it and launch the session URL
	Then I make the payment based on payment type
	Then I validate payment status from DB
	Then I write the payment_id and payment status in excel
	
Examples:
|Environment|
	|ITv2|
	
@Sanity_ITv3
Scenario Outline: Validate Consmobile_CRIS_OneTime_ACH_New_DoNotSaveToWallet_ITv3
	Given I have the request XML for "Consmobile_CRIS_OneTime_ACH_New_DoNotSaveToWallet" to be run on "<Environment>"
	And I trigger it and launch the session URL
	Then I make the payment based on payment type
	Then I validate payment status from DB
	Then I write the payment_id and payment status in excel
	
Examples:
|Environment|
	|ITv3|	
	
@Sanity_e2e
Scenario Outline: Validate Consmobile_CRIS_OneTime_ACH_New_DoNotSaveToWallet_e2e
	Given I have the request XML for "Consmobile_CRIS_OneTime_ACH_New_DoNotSaveToWallet" to be run on "<Environment>"
	And I trigger it and launch the session URL
	Then I make the payment based on payment type
	Then I validate payment status from DB
	Then I write the payment_id and payment status in excel
	
Examples:
|Environment|
	|e2e|