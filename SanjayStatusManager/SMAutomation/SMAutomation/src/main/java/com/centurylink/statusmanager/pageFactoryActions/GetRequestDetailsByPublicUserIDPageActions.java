package com.centurylink.statusmanager.pageFactoryActions;

import org.json.JSONArray;
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

public class GetRequestDetailsByPublicUserIDPageActions {

	WebDriver driver;
	
	private final static org.slf4j.Logger Log = LoggerFactory.getLogger(GetRequestDetailsByPublicUserIDPageActions.class);

	public GetRequestDetailsByPublicUserIDPageActions(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(SeleniumDriver.getDriver(), this);

	}

	@FindBy(xpath = ".//*[@ng-model='GetRequestDetailsByPublicUserID.publicUserID']")
	public WebElement PublicUserIDTextbox;

	@FindBy(xpath = ".//*[contains(@id,'GetRequestDetails')]//button[contains(@ng-click,'submitRequest')]")
	public WebElement SubmitButton;

	@FindBy(xpath = ".//*[@ng-show='serviceResponse']/div/pre/p")
	public WebElement responseparagraph;

	@FindBy(xpath = "//tab-heading[span[text()='Get Request Details (Public User ID)']]/a/img[1]")
	public WebElement Closetab_GetrequestbyPublicUserID_Icon;

	public void validateGetRequestByTNResponse(String TN) throws JSONException, InterruptedException {

		CommonMethods.WaitforElement(responseparagraph);

		String GetRequestByPublicUserID_response = responseparagraph.getText();

		JSONObject json = new JSONObject(GetRequestByPublicUserID_response);

		@SuppressWarnings("unused")
		String ErrorinResponse = null;
		boolean checkErrorMessageExists = json.has("message");

		if (checkErrorMessageExists == true) {
			
			ErrorinResponse = json.getString("message");
			
			  CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH +
			  "\\getRequestDetailsByPublicUserID_response_Invalid_PublicUserID" + "_" +
			  SeleniumDriver.timestamp() + ".png");
			 
			System.err.println("Error Message returned = " + json.getString("message") + "   Code = " + json.getString("code"));
			
			  Log.error("Error Message returned = " + json.getString("message") + "  " + "Code = " + json.getString("code"));
			 
			
		} else {

			JSONArray recs = json.getJSONArray("statusServiceResponseList");

			int responseListlength = recs.length();
			// System.out.println("Length of ResponseList = "+ responseListlength);
			
			  Log.info("Length of ResponseList = " + responseListlength);
			  Log.info("Total number of Requests associated to TN = " + responseListlength);
			 
			for (int i = 0; i < responseListlength; i++) {

				JSONObject rec = recs.getJSONObject(i);
				String testTN = rec.getJSONObject("commonInfo").getString("publicUserID");
				// System.out.println(testTN);
				if (TN.equals(testTN)) {
					System.out.println("PublicUserID = " + rec.getJSONObject("commonInfo").getString("publicUserID")
							+ "  CorrelationID = " + rec.getJSONObject("commonInfo").getString("correlationID"));
					
					  Log.info("PublicUserID = " + rec.getJSONObject("commonInfo").getString("publicUserID") +  "  CorrelationID = " +
					  rec.getJSONObject("commonInfo").getString("correlationID"));
					 

					Assert.assertEquals(testTN, TN);

					
					  CommonMethods.captureScreenshot( URLConfigs.SCREENSHOT_PATH +
					  "\\getRequestDetailsByPublicUserID_response_Valid_PublicUserID" + "_" +
					  SeleniumDriver.timestamp() + ".png");
					 
				}
			}
		}

	}
	
	public void closeReqByPublicuserIDTab() {
		
		Closetab_GetrequestbyPublicUserID_Icon.click();
		Log.info("Closed the GetrequestbyPublicUserID tab.");
	}
}
