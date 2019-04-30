package com.centurylink.statusmanager.pageFactoryActions;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.centurylink.statusmanager.utilities.CommonMethods;
import com.centurylink.statusmanager.utilities.SeleniumDriver;
import com.centurylink.statusmanager.utilities.URLConfigs;

public class GetRequestDetailsByCorrelationIDPageActions {

	WebDriver driver;
	HomePageActions homePageActions = new HomePageActions(driver);
	private final static org.slf4j.Logger Log = LoggerFactory.getLogger(GetRequestDetailsByCorrelationIDPageActions.class);

	public GetRequestDetailsByCorrelationIDPageActions(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}

	@FindBy(xpath = ".//*[@ng-model='GetRequestDetails.correlationID']")
	public WebElement CorrelationIDTextbox;

	@FindBy(xpath = ".//*[contains(@id,'GetRequestDetails')]//button[contains(@ng-click,'submitRequest')]")
	public WebElement SubmitButton;

	@FindBy(xpath = ".//*[@ng-show='serviceResponse']/div/pre/p")
	public WebElement responseparagraph;

	@FindBy(xpath = "//tab-heading[span[text()='Get Request Details (Correlation ID)']]/a/img[1]")
	public WebElement Closetab_GetrequestbyCorrelationID_Icon;

	// ************************* Method begins from here **********************

	public void launchGetReqByCorrIDtab() {

		homePageActions.GetRequestByCorrelationID_lnk.click();
	}

	public void validateGetRequestByCorrelationIDResponse(String CorrID) throws JSONException, InterruptedException {

		CommonMethods.WaitforElement(responseparagraph);
		String GetRequestByCorrelationID_response = responseparagraph.getText();

		JSONObject json = new JSONObject(GetRequestByCorrelationID_response);

		// String ErrorMessage = "Get Status Info FAILED" ;
		String ErrorinResponse = null;

		boolean checkErrorMessageExists = json.has("message");

		boolean checkCommonInfoExists = json.has("commonInfo");
		

		if (checkErrorMessageExists == true) {
			ErrorinResponse = json.getString("message");

			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH +"\\GetRequestByCorrelationID_response_Invalid_CorrelationID" + "_" + SeleniumDriver.timestamp()  + ".png");
			
			System.err.println("Error Message returned = " + json.getString("message") + "   " + "Code = "+ json.getString("code"));
			 Log.error("Error message = " + ErrorinResponse);
			 

		} else if (checkCommonInfoExists == true) {
			String ResponseinCorrelationID = json.getJSONObject("commonInfo").getString("correlationID");
			if (ResponseinCorrelationID.equals(CorrID)) {
				System.out.println("CorrelationID in response = " + ResponseinCorrelationID + "  "
						+ "CorrelationID matched successfully !!");
				
				  Log.info("CorrelationID in response = " + ResponseinCorrelationID + "  " +"CorrelationID matched successfully !!");
				 
				CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\GetRequestByCorrelationID_response_Valid_CorrelationID" + "_" + SeleniumDriver.timestamp() + ".png");
				
				Assert.assertEquals(ResponseinCorrelationID, CorrID);

			}
		}
	}
	
	public void closeReqByCorrIDTab() {
		
		Closetab_GetrequestbyCorrelationID_Icon.click();
		Log.info("Closed the GetrequestbyCorrelationID tab.");
	}
}
