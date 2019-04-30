package genericUtilities;




import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import pageFactory.HCDEReceiveConfirmationPage;

import dataOperations.ExcelOperations;
import junit.framework.Assert;
import pageFactory.HCDEChooseMethodPaymentPage;
import pageFactory.HCDEPaymentInformationPage;
import pageFactory.HCDEVerifyInformationPage;
import pageFactory.HCDEWelcomeToSpeedpayPage;
import pageFactory.PaypalCardPaymentPage;
import pageFactory.PaypalChoosePaymentMethodPage;
import pageFactory.PaypalLoginPage;
import pageFactory.PaypalPaymentPage;
import pageFactory.PaypalVerificationPage;
import restassured.RestMethods;



public class IFrameNavigation extends GlobalVariables {
	
	DataFromDB dataFromDB = new DataFromDB();
	ExcelOperations excelOperations = new ExcelOperations();
	CommonMethods commonMethods = new CommonMethods();
	private boolean WebElement;
	public boolean payFromHCDEIframe() throws Exception {
		
		
		if(sessionURL.contains("/Internal/UI/payment/") && scenarioName.contains("TCAT_SHI")){
			InitHCDEPages(driver);
			
			if(paymentType.contains("CARD"))
			{
				payByCardForTcatSHI();			
			}
		}
		
		 if(sessionURL.contains("Internal/UI/autopay/")){
				InitHCDEPages(driver);
				if(paymentType.contains("ACH"))
				{
					AutopayEnrollBankAccount();
					
				}
				
				else if(paymentType.contains("CARD"))
				{
					AutopayEnrollCard();
				}
			}

		if(sessionURL.contains("Internal/UI/token/") && scenarioName.contains("TCAT_SHP")){
			InitHCDEPages(driver);
			if(paymentType.contains("CARD"))
			{
				payByCardForTcatSHP();
			}
		}
		if(sessionURL.contains("/Internal/UI/payment/") && scenarioName.contains("TCAT_SBI")){
			InitHCDEPages(driver);
			if(paymentType.contains("CARD"))
			{
				payByCardForTcatSBI();
			}
		}

		
		if(sessionURL.contains("Internal/UI/token/")&& scenarioName.contains("TCAT_SBP")){
			InitHCDEPages(driver);
			if(paymentType.contains("CARD"))
			{
				payByCardForTcatSHP_SBP();
			}
		}
		if(sessionURL.contains("Internal/UI/prepaid/autopay/")&& scenarioName.contains("CONPORT_EnrollAutopay")){
			InitHCDEPages(driver);
			
			Conport_EnrollAutopay();
			
		}
		
		if(sessionURL.contains("multipayment")){
			InitHCDEPages(driver);
			
			ruleAppliedInd = dataFromDB.checkRuleAppliedStatus(ex_InputChannel);
	        ruleText = dataFromDB.checkRuleText(ex_InputChannel);
	      
			if (paymentType.equalsIgnoreCase("ACH")) {
				
				if (ruleText.equalsIgnoreCase("B")||ruleText.equalsIgnoreCase(""))
					elementsFound = payByCoBrandedBankPages();
				else
					elementsFound = payByBankHCDE();
			} else if(paymentType.equalsIgnoreCase("CARD")) {
				if (ruleText.equalsIgnoreCase("B")||ruleText.equalsIgnoreCase(""))
					elementsFound = payByCoBrandedCardPages();
				else
					elementsFound = payByCardHCDE();
			}
		}
		
		if(sessionURL.contains("/payment/")){
			InitHCDEPages(driver);
			
			ruleAppliedInd = dataFromDB.checkRuleAppliedStatus(ex_InputChannel);
	        ruleText = dataFromDB.checkRuleText(ex_InputChannel);
	      
			if (paymentType.equalsIgnoreCase("ACH")) {
				
				if (ruleText.equalsIgnoreCase("B")||ruleText.equalsIgnoreCase(""))
					elementsFound = payByCoBrandedBankPages();
				else
					elementsFound = payByBankHCDE();
			} else if(paymentType.equalsIgnoreCase("CARD")) {
				if (ruleText.equalsIgnoreCase("B")||ruleText.equalsIgnoreCase(""))
					elementsFound = payByCoBrandedCardPages();
				else
					elementsFound = payByCardHCDE();
			}
		}else if(sessionURL.contains("prepaidpayment")){
			
			InitPaypalPages(driver);
			if(paymentType.contains("Paypal")){
				payFromPaypal();
			}else if(paymentType.contains("CARD")){
				payByCard();
			}
			
		}
		
		/*if (elementsFound) {
			if (driver.getCurrentUrl()
					.contains(GlobalVariables.successNotificationUrl)) {
				System.out.println("payment made successfully");
			} else {
				System.out.println("Payment was not successful.Navigated to:"
						+ driver.getCurrentUrl());
				elementsFound = false;
				 excelOperations.writeDataIntoExcel("FAIL", GlobalVariables.tcStatusName);
	             excelOperations.writeDataIntoExcel("Payment was not successful.Navigated to:"
							+ driver.getCurrentUrl()
							+ " and Session ID is:"
							+ GlobalVariables.sessionIDValue,GlobalVariables.tcCommentsName);               
			}
		}*/

		
		return elementsFound;
	}
	
	// CoBraded pages
	private boolean payByCoBrandedBankPages() throws Exception {
		if (HCDEChooseMethodPaymentPage
						.getPayWithBankBtn().isDisplayed()) {
				HCDEChooseMethodPaymentPage.getPayWithBankBtn().click();
					if (payByBankHCDE())
						return true;
					else
						return false;
		} else {
			/*excelOperations.writeDataIntoExcel("FAIL", colStatus);
			excelOperations.writeDataIntoExcel(GlobalVariables.elementNotFound
					+ " not found in HCDEChooseMethodPaymentPage", colComments);*/
			return false;
		}
	}
	// Pay for the BTN with Bank Details using HCDE
	private boolean payByBankHCDE() throws Exception {
		if (commonMethods.CheckElementVisibility(HCDEPaymentInformationPage.getPaymentMethodComboBox())) {
			    
				Select methodpaymentDropdown = new Select(HCDEPaymentInformationPage.getPaymentMethodComboBox());
				List<WebElement> methodOfCardPayments=methodpaymentDropdown.getOptions();
				for(int q=0;q<methodOfCardPayments.size();q++){
				
			if((methodOfCardPayments.get(q).getText()).contains(ex_InstrumentType)){
				
				methodpaymentDropdown.selectByVisibleText(methodOfCardPayments.get(q).getText());
				break;
			}
		}
		
		if (verifyHCDEBankPaymentPage()) {
				
			if(scenarioName.contains("New")){
				
//				methodpaymentDropdown
//				.selectByVisibleText(ex_InstrumentType);
				HCDEPaymentInformationPage.getRoutingNumberTextBox().sendKeys(
						ex_RoutingNumber);
				HCDEPaymentInformationPage.getAccountNumberTextBox().sendKeys(
						commonMethods.getRandomNumber(9));
					
					
				if(HCDEPaymentInformationPage.getSaveCheckbox().isDisplayed()){
					if(scenarioName.contains("DoNotSaveToWallet")){
									;
					}else if(scenarioName.contains("SaveToWallet")){
						HCDEPaymentInformationPage.getSaveCheckbox().click();
					}
				}
			}else{
				
				List<WebElement> methodOfPayments=methodpaymentDropdown.getOptions();
				
				for(int p=0;p<methodOfPayments.size();p++){
					
					if((methodOfPayments.get(p).getText()).contains(ex_InstrumentType)){
						methodpaymentDropdown.selectByVisibleText(methodOfPayments.get(p).getText());
						break;
					}
					
				}
			}
				
			if (HCDEPaymentInformationPage.getAmountPaidTextBox().isDisplayed())
			{
				if (HCDEPaymentInformationPage.getAmountPaidTextBox()
						.getAttribute("readonly") == null) {
					HCDEPaymentInformationPage.getAmountPaidTextBox().clear();
					HCDEPaymentInformationPage.getAmountPaidTextBox().sendKeys(
								commonMethods.getAmountToBePaid());
				}
			}	
			if(scenarioName.contains("Scheduled") && (scenarioName.contains("Ensemble"))==false){
					try{
					HCDEPaymentInformationPage.getDateOfPaymentTextbox().click();
					HCDEPaymentInformationPage.getDateOfPaymentTextbox().clear();
					HCDEPaymentInformationPage.getDateOfPaymentTextbox().sendKeys(ex_ScheduledDate);	
					}catch(Exception e){
						System.out.println("ScheduledDate IS NOT EDITABLE, Please change the BTN");
					}
			}
				
			HCDEPaymentInformationPage.getIAgreeCheckbox().click();
			CommonMethods.captureScreenshot(scenarioName +"1");
			HCDEPaymentInformationPage.getNextButton().click();
			CommonMethods.captureScreenshot(scenarioName +"2");
			//commonMethods.explicitWait(20, HCDEVerifyInformationPage.getSubmitPaymentButton());
			if (commonMethods
					.CheckElementVisibility(HCDEVerifyInformationPage
							.getSubmitPaymentButton())) {
				HCDEVerifyInformationPage.getSubmitPaymentButton().click();
				CommonMethods.captureScreenshot(scenarioName +"3");
				
				return true;
			} else {
					/*excelOperations
							.writeDataIntoExcel(
									"FAIL",
									colStatus);*/
					return false;
				}
			} else {
				/*excelOperations.writeDataIntoExcel("FAIL",
						colStatus);*/
				return false;
			}
		} else {
			/*excelOperations.writeDataIntoExcel("FAIL",
					colStatus);*/
			return false;
		}
	}
		
	// pay from co branded pages card
	private boolean payByCoBrandedCardPages() throws Exception {
		
		if (commonMethods.CheckElementVisibility(HCDEChooseMethodPaymentPage.getPayWithCardBtn())) 
		{
			HCDEChooseMethodPaymentPage.getPayWithCardBtn().click();
				if (commonMethods.CheckElementVisibility(HCDEWelcomeToSpeedpayPage.getAgreeButton()))
				{
					HCDEWelcomeToSpeedpayPage.getAgreeButton().click();
				if (payByCardHCDE())
					return true;
				else
					return false;
			} else {
				excelOperations.writeDataIntoExcel("FAIL", colTransactionStatus);
				return false;
			}
		} else {
			excelOperations.writeDataIntoExcel("FAIL", colTransactionStatus);
			return false;

		}
	}
		
	//Pay for the BTN using CARD details using IBM
	private boolean payByCardHCDE() throws Exception {
		
		if(verifyHCDECardPaymentPage()){ 
		
				Select methodpaymentDropdown= new Select(HCDEPaymentInformationPage.getExpiryYearComboBox());
		
		if(scenarioName.contains("New")){
			
			try{
			if(commonMethods
					.CheckElementVisibility(HCDEPaymentInformationPage
					.getPaymentMethodComboBox())) {
				//methodpaymentDropdown.selectByVisibleText(ex_InstrumentType);				
				HCDEPaymentInformationPage.getPaymentMethodComboBox().click();
				HCDEPaymentInformationPage.getPaymentMethodComboBox().sendKeys(ex_CardNumber);
				HCDEPaymentInformationPage.getPaymentMethodComboBox().click();
			}
		    	}
		    catch(Exception e){
		    	
		    }
			if(commonMethods
					.CheckElementVisibility(HCDEPaymentInformationPage.getCardNumberTextBox())){
				HCDEPaymentInformationPage.getCardNumberTextBox().sendKeys(ex_CardNumber);	
			}
			if(HCDEPaymentInformationPage.getExpiryMonthComboBox().isDisplayed()){
				Select monthDropdown = new Select(HCDEPaymentInformationPage.getExpiryMonthComboBox());
				monthDropdown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
			}
			if(HCDEPaymentInformationPage.getExpiryYearComboBox().isDisplayed()){
				Select yearDropDown = new Select(HCDEPaymentInformationPage.getExpiryYearComboBox());
				yearDropDown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
			}
			if(HCDEPaymentInformationPage.getZipcodeTextBox().isDisplayed()){
				HCDEPaymentInformationPage.getZipcodeTextBox().clear();
				HCDEPaymentInformationPage.getZipcodeTextBox().sendKeys(commonMethods.getRandomNumber(5));
			}
			if(HCDEPaymentInformationPage.getSaveCheckbox().isDisplayed()){
				if(scenarioName.contains("_SaveToWallet")){
					HCDEPaymentInformationPage.getSaveCheckbox().click();
				}else if(scenarioName.contains("DoNotSaveToWallet")){
					;
				}
			}
			
		}else {
			
			List<WebElement> methodOfCardPayments=methodpaymentDropdown.getOptions();
			
			for(int q=0;q<methodOfCardPayments.size();q++){
				
				if((methodOfCardPayments.get(q).getText()).contains(ex_InstrumentType)){
					methodpaymentDropdown.selectByVisibleText(methodOfCardPayments.get(q).getText());
					break;
				}
				
			}
			
		}
			
			if(scenarioName.contains("Scheduled") && (scenarioName.contains("Ensemble"))==false){
				HCDEPaymentInformationPage.getDateOfPaymentTextbox().click();
				HCDEPaymentInformationPage.getDateOfPaymentTextbox().clear();
				HCDEPaymentInformationPage.getDateOfPaymentTextbox().sendKeys(ex_ScheduledDate);
			}
		
		if(HCDEPaymentInformationPage.getAmountPaidTextBox().isDisplayed())
		{
		if(HCDEPaymentInformationPage.getAmountPaidTextBox()
				.getAttribute("readonly") == null && (ruleAppliedInd.equalsIgnoreCase("N") || ruleAppliedInd.equalsIgnoreCase(""))){
			HCDEPaymentInformationPage.getAmountPaidTextBox().clear();
			HCDEPaymentInformationPage.getAmountPaidTextBox().sendKeys(
					commonMethods.getAmountToBePaid());
		}	
		}		
										
		HCDEPaymentInformationPage.getIAgreeCheckbox().click();
		HCDEPaymentInformationPage.getNextButton().click();
		}
		
		if (commonMethods
				.CheckElementVisibility(HCDEVerifyInformationPage
						.getSubmitPaymentButton())) {
			HCDEVerifyInformationPage.getSubmitPaymentButton().click();
			return true;
		} 
		excelOperations.writeDataIntoExcel("FAIL", colTransactionStatus);
		return false;
	}
				
	// verify all elements exist in HCDE bank payment Page
	private boolean verifyHCDEBankPaymentPage() {
		if (commonMethods
				.CheckElementVisibility(HCDEPaymentInformationPage
						.getAmountPaidTextBox())
				&& commonMethods
				.CheckElementVisibility(HCDEPaymentInformationPage
						.getRoutingNumberTextBox())
				&& commonMethods
				.CheckElementVisibility(HCDEPaymentInformationPage
						.getAccountNumberTextBox())
				&& commonMethods
				.CheckElementVisibility(HCDEPaymentInformationPage
						.getNextButton())
				&& commonMethods
				.CheckElementVisibility(HCDEPaymentInformationPage
						.getIAgreeCheckbox()))
			return true;
		else
			return false;
	}
				
	// verify if all elements exist in HCDE card payment page
	private boolean verifyHCDECardPaymentPage() {
		if (commonMethods
				.CheckElementVisibility(HCDEPaymentInformationPage
						.getCardNumberTextBox())
				&& commonMethods
				.CheckElementVisibility(HCDEPaymentInformationPage
						.getExpiryMonthComboBox())
				&& commonMethods
				.CheckElementVisibility(HCDEPaymentInformationPage
						.getExpiryYearComboBox())
				&& commonMethods
				.CheckElementVisibility(HCDEPaymentInformationPage
						.getNextButton())
				&& commonMethods
				.CheckElementVisibility(HCDEPaymentInformationPage
						.getIAgreeCheckbox())
				&& commonMethods
				.CheckElementVisibility(HCDEPaymentInformationPage
						.getZipcodeTextBox()))
				return true;
		else
				return false;
		
	}
	
		public void payFromPaypal(){
		
		PaypalChoosePaymentMethodPage.getPaypalButton().click();
		PaypalChoosePaymentMethodPage.getAgreeTermsAndConditionCheckbox().click();
		commonMethods.JavaScriptExecutorClick(PaypalChoosePaymentMethodPage.getContinueToPaypalButton());
		String firstWindowHandle=driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
            driver.manage().window().maximize();
        }
        commonMethods.implicitWait(5000);
		driver.switchTo().frame(driver.findElement(By.name("injectedUl")));
		PaypalLoginPage.getPaypalUsernameTextbox().sendKeys(ex_PaypalUsername);
		commonMethods.explicitWait(100, PaypalLoginPage.getPaypalPasswordTextbox());
		PaypalLoginPage.getPaypalPasswordTextbox().sendKeys(ex_PaypalPassword);
		PaypalLoginPage.getLogInButton().click();
		driver.switchTo().defaultContent();
		WebElement agreeAndContinue=driver.findElement(By.id("confirmButtonTop"));
		commonMethods.JavaScriptExecutorClick(agreeAndContinue);
		commonMethods.implicitWait(10000);
		driver.switchTo().window(firstWindowHandle);
		commonMethods.implicitWait(10000);
		if(commonMethods.CheckElementVisibility(PaypalVerificationPage.getPlaceMyOrderSecurelyButton()))
		{
			commonMethods.explicitWait(100, PaypalVerificationPage.getPlaceMyOrderSecurelyButton());
			commonMethods.JavaScriptExecutorClick(PaypalVerificationPage.getPlaceMyOrderSecurelyButton());
		}
	}
	
	public void payByCard(){
		
		try {
			PaypalChoosePaymentMethodPage.getCardButton().click();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		if(commonMethods.CheckElementVisibility(PaypalCardPaymentPage.getCardNumber()))
		{
			PaypalCardPaymentPage.getCardNumber().sendKeys(ex_CardNumber);
		}
		if(commonMethods.CheckElementVisibility(PaypalCardPaymentPage.getNameOnCard()))
		{
			PaypalCardPaymentPage.getNameOnCard().sendKeys(ex_CardName);
			
		}
		if(commonMethods.CheckElementVisibility(PaypalCardPaymentPage.getExpirationMonth()))
		{
			Select s11 = new Select(PaypalCardPaymentPage.getExpirationMonth());
		    s11.selectByIndex(1);
		}
		if(commonMethods.CheckElementVisibility(PaypalCardPaymentPage.getExpirationYear()))
		{
			Select s12 =new Select(PaypalCardPaymentPage.getExpirationYear());
			s12.selectByIndex(2);
		}
		if(commonMethods.CheckElementVisibility(PaypalCardPaymentPage.getBillingZipCode()))
		{
			PaypalCardPaymentPage.getBillingZipCode().clear();
			PaypalCardPaymentPage.getBillingZipCode().sendKeys(commonMethods.getRandomNumber(5));
		}
		PaypalCardPaymentPage.getAgreeTermsAndConditionCheckbox().click();
		if(commonMethods.CheckElementVisibility(PaypalCardPaymentPage.getPlaceMyOrderSecurelyButton()))
		{
			commonMethods.explicitWait(100, PaypalCardPaymentPage.getPlaceMyOrderSecurelyButton());
			commonMethods.JavaScriptExecutorClick(PaypalCardPaymentPage.getPlaceMyOrderSecurelyButton());
		}
	}
	
	public void payByCardForTcatSHP_SBP(){
		if(HCDEPaymentInformationPage.getCardNameTextBox().isDisplayed())
		{
			HCDEPaymentInformationPage.getCardNameTextBox().sendKeys(ex_CardName);
			
		}
		if(HCDEPaymentInformationPage.getCardNumberTextBox().isDisplayed()){
			HCDEPaymentInformationPage.getCardNumberTextBox().sendKeys(ex_CardNumber);	
		}
		if(HCDEPaymentInformationPage.getExpiryMonthComboBox().isDisplayed()){
			Select monthDropdown = new Select(HCDEPaymentInformationPage.getExpiryMonthComboBox());
			monthDropdown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
		}
		if(HCDEPaymentInformationPage.getExpiryYearComboBox().isDisplayed()){
			Select yearDropDown = new Select(HCDEPaymentInformationPage.getExpiryYearComboBox());
			yearDropDown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
		}
		
		if(HCDEPaymentInformationPage.getContinue().isDisplayed()){
			HCDEPaymentInformationPage.getContinue().click();
		}
		currentpageurl = driver.getCurrentUrl();
	}

	
	public void payByCardForTcatSHI()
	{
		if(HCDEPaymentInformationPage.getCardNumberTextBox().isDisplayed()){
			HCDEPaymentInformationPage.getCardNumberTextBox().sendKeys(ex_CardNumber);	
		}
		if(HCDEPaymentInformationPage.getExpiryMonthComboBox().isDisplayed()){
			Select monthDropdown = new Select(HCDEPaymentInformationPage.getExpiryMonthComboBox());
			monthDropdown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
		}
		if(HCDEPaymentInformationPage.getExpiryYearComboBox().isDisplayed()){
			Select yearDropDown = new Select(HCDEPaymentInformationPage.getExpiryYearComboBox());
			yearDropDown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
		}
		if(HCDEPaymentInformationPage.getZipcodeTextBox().isDisplayed()){
			HCDEPaymentInformationPage.getZipcodeTextBox().clear();
			HCDEPaymentInformationPage.getZipcodeTextBox().sendKeys(commonMethods.getRandomNumber(5));
		}
		
		if(HCDEPaymentInformationPage.getIAgreeCheckbox().isDisplayed()){
			HCDEPaymentInformationPage.getIAgreeCheckbox().click();	
			commonMethods.captureScreenshot(scenarioName +"1");
		}
		if(HCDEPaymentInformationPage.getNextButton().isDisplayed()){
			HCDEPaymentInformationPage.getNextButton().click();	
			commonMethods.captureScreenshot(scenarioName +"2");
		}
		if(commonMethods.CheckElementVisibility(HCDEVerifyInformationPage.getSubmitPaymentButton()))
		{
			commonMethods.explicitWait(150, HCDEVerifyInformationPage.getSubmitPaymentButton());
			commonMethods.JavaScriptExecutorClick(HCDEVerifyInformationPage.getSubmitPaymentButton());
			commonMethods.captureScreenshot(scenarioName +"3");
		}
		
		if(commonMethods.CheckElementVisibility(HCDEVerifyInformationPage.getpaymentConfirmationText()))
		{
			commonMethods.explicitWait(100, HCDEVerifyInformationPage.getpaymentConfirmationText());
			System.out.println("payment is success");
		}
		currentpageurl = driver.getCurrentUrl();
	}
	public void payByCardForTcatSHP(){
		if(HCDEPaymentInformationPage.getCardNameTextBox().isDisplayed())
		{
			HCDEPaymentInformationPage.getCardNameTextBox().sendKeys(ex_CardName);
		}
		if(HCDEPaymentInformationPage.getCardNumberTextBox().isDisplayed()){
			HCDEPaymentInformationPage.getCardNumberTextBox().sendKeys(ex_CardNumber);	
		}
		if(HCDEPaymentInformationPage.getExpiryMonthComboBox().isDisplayed()){
			Select monthDropdown = new Select(HCDEPaymentInformationPage.getExpiryMonthComboBox());
			monthDropdown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
		}
		if(HCDEPaymentInformationPage.getExpiryYearComboBox().isDisplayed()){
			Select yearDropDown = new Select(HCDEPaymentInformationPage.getExpiryYearComboBox());
			yearDropDown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
		}
		if(HCDEPaymentInformationPage.getzipTextBox().isDisplayed()){
			HCDEPaymentInformationPage.getzipTextBox().clear();
			HCDEPaymentInformationPage.getzipTextBox().sendKeys(commonMethods.getRandomNumber(5));
		}
		
		if(HCDEPaymentInformationPage.getPlaceMyOrderSecurelyBtn().isDisplayed()){
			HCDEPaymentInformationPage.getPlaceMyOrderSecurelyBtn().click();
		}
		
		currentpageurl = driver.getCurrentUrl();
	}
	
	public void payByCardForTcatSBI(){
		
		if(HCDEPaymentInformationPage.getCardNumberTextBox().isDisplayed()){
			HCDEPaymentInformationPage.getCardNumberTextBox().sendKeys(ex_CardNumber);	
		}
		if(HCDEPaymentInformationPage.getExpiryMonthComboBox().isDisplayed()){
			Select monthDropdown = new Select(HCDEPaymentInformationPage.getExpiryMonthComboBox());
			monthDropdown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
		}
		if(HCDEPaymentInformationPage.getExpiryYearComboBox().isDisplayed()){
			Select yearDropDown = new Select(HCDEPaymentInformationPage.getExpiryYearComboBox());
			yearDropDown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
		}
		
		HCDEPaymentInformationPage.getIAgreeCheckbox().click();
		HCDEPaymentInformationPage.getNextButton().click();
		HCDEPaymentInformationPage.getSubmitPaymentButton().click();
		currentpageurl = driver.getCurrentUrl();
	}
	
	// Initiate page factory for HCDE pages (why we are using these methods)
	private static void InitHCDEPages(WebDriver driver) {
		
		PageFactory.initElements(driver, HCDEPaymentInformationPage.class);
		PageFactory.initElements(driver, HCDEReceiveConfirmationPage.class);
		PageFactory.initElements(driver, HCDEVerifyInformationPage.class);
		PageFactory.initElements(driver, HCDEChooseMethodPaymentPage.class);
		PageFactory.initElements(driver, HCDEWelcomeToSpeedpayPage.class);
					
	}
	
	 //for trigger Token API to get the TOKEN ID.
    public void verifyResponse() throws EncryptedDocumentException, InvalidFormatException, IOException {
	        RestMethods rMethods = new RestMethods();
	        rMethods.postRequest();
    } 
	
	private static void InitPaypalPages(WebDriver driver){
		PageFactory.initElements(driver, PaypalChoosePaymentMethodPage.class);
		PageFactory.initElements(driver, PaypalLoginPage.class);
		PageFactory.initElements(driver, PaypalVerificationPage.class);
	}

	public boolean AutopayEnrollBankAccount() throws Exception
	{
		if(sessionURL.contains("autopay")){
	     InitHCDEPages(driver);
	        HCDEPaymentInformationPage.getAccountNumberTextBox().sendKeys(commonMethods.getRandomNumber(9));
			HCDEPaymentInformationPage.getRoutingNumberTextBox().sendKeys(ex_RoutingNumber);
			HCDEPaymentInformationPage.getIAgreeCheckbox().click();
			HCDEPaymentInformationPage.getNextButton().click();
			
			if(scenarioName.contains("Enrollment"))
			{
			   HCDEPaymentInformationPage.getSaveButton().click();
			if(HCDEPaymentInformationPage.getDoneButton().isDisplayed() && (HCDEPaymentInformationPage.getDoneButton().isEnabled()))
					{
				HCDEPaymentInformationPage.getDoneButton().click();
					}	
			}
			else if(scenarioName.contains("Cancelenrollment"))
			{
			HCDEPaymentInformationPage.getCancelButton().click();
			}
			
			
	}
		return false;

	}

public boolean AutopayEnrollCard() throws Exception
{
	if(sessionURL.contains("autopay")){
     InitHCDEPages(driver);
		
		HCDEPaymentInformationPage.getPaymentbyCardLink().click();
		HCDEPaymentInformationPage.getCardNumberTextBox().sendKeys(ex_CardNumber);
		HCDEPaymentInformationPage.getIAgreeCheckbox().click();
		HCDEPaymentInformationPage.getNextButton().click();
		
		if(HCDEPaymentInformationPage.getExpiryMonthComboBox().isDisplayed()){
			Select monthDropdown = new Select(HCDEPaymentInformationPage.getExpiryMonthComboBox());
			monthDropdown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
		}
		if(HCDEPaymentInformationPage.getExpiryYearComboBox().isDisplayed()){
			Select yearDropDown = new Select(HCDEPaymentInformationPage.getExpiryYearComboBox());
			yearDropDown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
		}
		
		if(HCDEPaymentInformationPage.getZipcodeTextBox().isDisplayed()){
		   HCDEPaymentInformationPage.getZipcodeTextBox().sendKeys(commonMethods.getRandomNumber(5));
		}
		
		if(scenarioName.contains("Enrollment"))
		{
		HCDEPaymentInformationPage.getSaveButton().click();
		}
		else if(scenarioName.contains("Cancelenrollment"))
		{
		HCDEPaymentInformationPage.getCancelButton().click();
		}
		
		
}
	return false;

}
public boolean Autopay_Enrollment_Update_Remove()
{
	if(sessionURL.contains("Internal/UI/payment/")){
	     InitHCDEPages(driver);
	
	     if(scenarioName.contains("ACH"))
			{
	    	 
			HCDEPaymentInformationPage.getPaymentMethod_ACH().click();
			}
	     
	     if(scenarioName.contains("CARD"))
			{
	    	 
			HCDEPaymentInformationPage.getPaymentMethod_CARD().click();
			HCDEPaymentInformationPage.getI_Agree_Button().click();
			}
	}
	return false;
		
}
static String strCurrentValue;
public boolean Remove_Delete_Account() throws Throwable
{
	if(sessionURL.contains("Internal/UI/payment/")){
	     InitHCDEPages(driver);
	
	     if(scenarioName.contains("ACH")||scenarioName.contains("CARD"))
			{
			Select s=new Select(HCDEPaymentInformationPage.getMethodOfPayment());
			s.selectByIndex(1);
			  
			Select sel=new Select(HCDEPaymentInformationPage.getMethodOfPayment());
			strCurrentValue = sel.getFirstSelectedOption().getText();
			System.out.println(strCurrentValue);
			
			HCDEPaymentInformationPage.getDeleteButton().click();
			driver.switchTo().frame(2);
		    Actions builder = new Actions(driver);
		    builder.moveToElement(HCDEPaymentInformationPage.getYesDeleteButton()).click( HCDEPaymentInformationPage.getYesDeleteButton() );
		    builder.perform();
			
		    HCDEPaymentInformationPage.getYesDeleteButton().sendKeys(Keys.ENTER);
			HCDEPaymentInformationPage.getCloseButton().click();
			//HCDEPaymentInformationPage.getCloseButton().sendKeys(Keys.ENTER);;
			driver.switchTo().defaultContent();
			}
	
	}
	return false;
		
}

public boolean Update_Account() throws Throwable
{
	if(sessionURL.contains("Internal/UI/payment/")){
	     InitHCDEPages(driver);
	
	     if(scenarioName.contains("ACH")||scenarioName.contains("CARD"))
			{
	    	 
	    	 int flag=0;
			Select s=new Select(HCDEPaymentInformationPage.getMethodOfPayment());
			s.selectByIndex(1);
			  
			Select sel=new Select(HCDEPaymentInformationPage.getMethodOfPayment());
			strCurrentValue = sel.getFirstSelectedOption().getText();
			System.out.println(strCurrentValue);
			commonMethods.captureScreenshot(scenarioName +"1");
			Thread.sleep(100);
			HCDEPaymentInformationPage.getEditButton().click();
			driver.switchTo().frame(2);
			String Random_month = null;
			String Random_Year = null;
			if(HCDEPaymentInformationPage.getExpiryMonthComboBox().isDisplayed()){
				Select monthDropdown = new Select(HCDEPaymentInformationPage.getExpiryMonthComboBox());
			   monthDropdown.selectByIndex(4);
			   Random_month = monthDropdown.getFirstSelectedOption().getAttribute("value");
			   
			}
			if(HCDEPaymentInformationPage.getExpiryYearComboBox().isDisplayed()){
				Select yearDropDown = new Select(HCDEPaymentInformationPage.getExpiryYearComboBox());
				yearDropDown.selectByIndex(5);
				Random_Year=yearDropDown.getFirstSelectedOption().getAttribute("value");
				
				
			}
			
			Actions builder = new Actions(driver);
		    builder.moveToElement(HCDEPaymentInformationPage.getSaveChangesButton()).click( HCDEPaymentInformationPage.getSaveChangesButton() );
		    builder.perform();
		    HCDEPaymentInformationPage.getSaveChangesButton().sendKeys(Keys.ENTER);
			
		    String Expiry_date_year="Expiration date "+Random_month+"/"+Random_Year;
		
		    String Upadted_Expiry_date_year=HCDEPaymentInformationPage.getUpdatedDate().getText();
		    
		    Assert.assertEquals(Expiry_date_year, Upadted_Expiry_date_year);
		    {
		    	flag=1;
				System.out.println(Expiry_date_year+" is Updated");	    	
		    }
			
		    commonMethods.captureScreenshot(scenarioName +"2");
			HCDEPaymentInformationPage.getCloseButton().submit();
			driver.switchTo().defaultContent();
			
		    
			}
	
	}
	return false;
		
}
public boolean Validate_Remove_Delete_Account()
{
	if(sessionURL.contains("Internal/UI/payment/")){
	     InitHCDEPages(driver);
	
	     if(scenarioName.contains("ACH")||scenarioName.contains("CARD"))
			{
	    	 int flag=0;
	    	 
	    	 Select DrpDwnSel=new Select(HCDEPaymentInformationPage.getMethodOfPayment());
	    	 List<WebElement> DrpDwnList=DrpDwnSel.getOptions();
	    	  
			  for(WebElement option  : DrpDwnList)
	    	   {
	    	       if (option.getText().contains(strCurrentValue)){
	    	          flag=1;
	    	          System.out.println(strCurrentValue+" is deleted");	    	          
	    	          break;
	    	          }
	    	   }
			}
	
	}
	return false;
		
}
public boolean Conport_EnrollAutopay() 
{
			  if(sessionURL.contains("Internal/UI/prepaid/autopay/")){
			InitHCDEPages(driver);
			
			try{        
						commonMethods.captureScreenshot(scenarioName +"1");
						HCDEPaymentInformationPage.getUpdateMyPaymentMethod().click();
						commonMethods.captureScreenshot(scenarioName +"2");
			            HCDEPaymentInformationPage.getReplaceThisPaymentAccount().click();
			}
			        catch(Exception e){
			     
			}
			                   
            try{          
            HCDEPaymentInformationPage.getCreditDebit().click(); 
            }
            catch(Exception e){
            }

          if(scenarioName.contains("CreditDebit"))
			{
        	  
        	 HCDEPaymentInformationPage.getCreditDebit().click();
	    	 HCDEPaymentInformationPage.getnameOnCard().sendKeys(ex_CardName);
	    	 HCDEPaymentInformationPage.getcardNum().sendKeys(ex_CardNumber);
	    	 
	    	 if(HCDEPaymentInformationPage.getexpiryYear().isDisplayed()){
	 			Select YearDropdown = new Select(HCDEPaymentInformationPage.getexpiryYear());
	 			YearDropdown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
	 		}
	 		if(HCDEPaymentInformationPage.getexpiryMonth().isDisplayed()){
	 			Select MonthDropDown = new Select(HCDEPaymentInformationPage.getexpiryMonth());
	 			MonthDropDown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
	 		}
	 		if(HCDEPaymentInformationPage.getcardZip().isDisplayed()){
				HCDEPaymentInformationPage.getcardZip().clear();
				HCDEPaymentInformationPage.getcardZip().sendKeys(commonMethods.getRandomNumber(5));
			}
	 		commonMethods.captureScreenshot(scenarioName +"3");
	 		HCDEPaymentInformationPage.getNext().click();
	 		commonMethods.captureScreenshot(scenarioName +"4");
	 		HCDEPaymentInformationPage.getSubmit().click();
			}
	     if(scenarioName.contains("Paypal"))
	     {
	    	 if(HCDEPaymentInformationPage.getReplaceThisPaymentAccount().isDisplayed() && HCDEPaymentInformationPage.getReplaceThisPaymentAccount().isEnabled()){
					HCDEPaymentInformationPage.getReplaceThisPaymentAccount().click();
	    	 }
	    		InitPaypalPages(driver);
	    		payFromPaypal();
	    		
	    	 
	}
	
		
}
	return false;
}

/*public boolean Adding_Account() throws Throwable
{
	if(sessionURL.contains("Internal/UI/payment/")){
	     InitHCDEPages(driver);
	
	     if(scenarioName.contains("ACH"))
			{
			Select s=new Select(HCDEPaymentInformationPage.getMethodOfPayment());
			s.selectByVisibleText("New Savings Account')]");
			  
			HCDEPaymentInformationPage.getRoutingNumberTextBox().sendKeys(
					ex_RoutingNumber);
			HCDEPaymentInformationPage.getAccountNumberTextBox().sendKeys(
					commonMethods.getRandomNumber(9));
			
			HCDEPaymentInformationPage.getAmountPaidTextBox().sendKeys("$10.00");
	    	 
	 		HCDEPaymentInformationPage.getSavethePaymentMethodCheckbox().click();
	 		HCDEPaymentInformationPage.getIAgreeCheckboxSpeedPay().click();
	 		HCDEPaymentInformationPage.getNextButton().click();
	 		
	 		HCDEPaymentInformationPage.getSubmitPaymentButton().click();
			}
	     if(scenarioName.contains("CARD"))
			{
			Select s=new Select(HCDEPaymentInformationPage.getMethodOfPayment());
			s.selectByVisibleText("New Credit or Debit Account')]");
			  
			HCDEPaymentInformationPage.getcardNum().sendKeys(ex_CardNumber);
	    	 
	    	 if(HCDEPaymentInformationPage.getexpiryYear().isDisplayed()){
	 			Select YearDropdown = new Select(HCDEPaymentInformationPage.getexpiryYear());
	 			YearDropdown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
	 		}
	 		if(HCDEPaymentInformationPage.getexpiryMonth().isDisplayed()){
	 			Select MonthDropDown = new Select(HCDEPaymentInformationPage.getexpiryMonth());
	 			MonthDropDown.selectByIndex(Integer.parseInt(commonMethods.getRandomNumber(1))+2);
	 		}
	 		if(HCDEPaymentInformationPage.getcardZip().isDisplayed()){
				HCDEPaymentInformationPage.getcardZip().clear();
				HCDEPaymentInformationPage.getcardZip().sendKeys(commonMethods.getRandomNumber(5));
			}
			
			HCDEPaymentInformationPage.getAmountPaidTextBox().sendKeys("$10.00");
	    	 
	 		HCDEPaymentInformationPage.getSavethePaymentMethodCheckbox().click();
	 		HCDEPaymentInformationPage.getIAgreeCheckboxSpeedPay().click();
	 		HCDEPaymentInformationPage.getNextButton().click();
	 		
	 		HCDEPaymentInformationPage.getSubmitPaymentButton().click();
			}
	
	}
	return false;
		
}*/
}


