Feature: Submit Payment
@Regression_Epwf
Scenario: Validate QPORTAL_De-enrollAutopay_ENS_CC_BMG_ACH
Given I have the request XML for "QPORTAL_De-enrollAutopay_ENS_CC_BMG_ACH" 
Then I trigger it and check the account status
Then I write account status to excel 

