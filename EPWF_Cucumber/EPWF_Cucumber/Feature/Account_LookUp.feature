Feature: Account LookUp_OOR_LATIS

@Sanity_ITv1
Scenario Outline: Validate Account_LookUp_ITv1
	Given I have the request XML for "Account_LookUp" to be run on "<Environment>"
	And I trigger it and check the account status
	Then I write account status to excel 
	
	Examples:
|Environment|
	|ITv1|
	
@Sanity_ITv2
Scenario Outline: Validate Account_LookUp_ITv2
	Given I have the request XML for "Account_LookUp" to be run on "<Environment>"
	And I trigger it and check the account status
	Then I write account status to excel 
	
	Examples:
|Environment|
	|ITv2|
	
@Sanity_ITv3
Scenario Outline: Validate Account_LookUp_ITv3
	Given I have the request XML for "Account_LookUp" to be run on "<Environment>"
	And I trigger it and check the account status
	Then I write account status to excel 
	
	Examples:
|Environment|
	|ITv3|
	
@Sanity_e2e
Scenario Outline: Validate Account_LookUp_e2e
	Given I have the request XML for "Account_LookUp" to be run on "<Environment>"
	And I trigger it and check the account status
	Then I write account status to excel 
	
	Examples:
|Environment|
	|e2e|
	