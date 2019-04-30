package com.centurylink.statusmanager.pageFactoryActions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/*import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import com.centurylink.statusmanager.utilities.CommonMethods;
import com.centurylink.statusmanager.utilities.SeleniumDriver;
import com.centurylink.statusmanager.utilities.URLConfigs;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PublishServicePageActions {

	WebDriver driver;
	private final static org.slf4j.Logger Log = LoggerFactory.getLogger(PublishServicePageActions.class);

	FileInputStream publishService;
	Properties publishserviceprop = new Properties();

	public PublishServicePageActions(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.publishCommonInfo.correlationID']")
	public WebElement publishCommonInfo_correlationid_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.publishCommonInfo.sourceSystem']")
	public WebElement publishCommonInfo_sourceSystem_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.publishCommonInfo.serviceIndicator']")
	public WebElement publishCommonInfo_serviceIndicator_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.publishCommonInfo.updatedBy']")
	public WebElement publishCommonInfo_updatedBy_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.publishCommonInfo.publishReason']")
	public WebElement publishCommonInfo_publishReason_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.requestDetails.correlationID']")
	public WebElement requestDetails_correlationid_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.requestDetails.requestStatus']")
	public WebElement requestDetails_requestStatus_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.requestDetails.requestStatusCode']")
	public WebElement requestDetails_requestStatusCode_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.requestDetails.requestStatusMessage']")
	public WebElement requestDetails_requestStatusMessage_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.requestDetails.notBeforeDate']")
	public WebElement requestDetails_notBeforeDate_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.requestDetails.customerCommitmentDate']")
	public WebElement requestDetails_customerCommitmentDate_tbx;

	@FindBy(xpath = "//textarea[@ng-model='StatusPublishServiceRequest.requestDetails.comment']")
	public WebElement requestDetails_comment_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.microServiceDetails.transactionID']")
	public WebElement microServiceDetails_transactionID_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.microServiceDetails.microServiceName']")
	public WebElement microServiceDetails_microServiceName_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.microServiceDetails.microServiceStatus']")
	public WebElement microServiceDetails_microServiceStatus_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.microServiceDetails.microServiceStatusCode']")
	public WebElement microServiceDetails_microServiceStatusCode_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.microServiceDetails.microServiceStatusMessage']")
	public WebElement microServiceDetails_microServiceStatusMessage_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.microServiceDetails.dueDate']")
	public WebElement microServiceDetails_dueDate_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.microServiceDetails.completeDate']")
	public WebElement microServiceDetails_completeDate_tbx;

	@FindBy(xpath = "//textarea[@ng-model='StatusPublishServiceRequest.microServiceDetails.comment']")
	public WebElement microServiceDetails_comment_tbx;

	@FindBy(xpath = "//input[@ng-model='StatusPublishServiceRequest.microServiceDetails.actionResponse']")
	public WebElement microServiceDetails_actionResponse_tbx;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement Submit_btn;

	@FindBy(xpath = ".//*[@ng-show='serviceResponse']/div/pre/p")
	public WebElement responseparagraph;

	@FindBy(xpath = "//tab-heading[span[text()='Publish Service']]/a/img[1]")
	public WebElement Publish_Service_Tab_close_img;

	public void fill_publish_service_form() throws IOException, InterruptedException {

		publishService = new FileInputStream(URLConfigs.TEST_DATA + "\\PublishService.properties");

		publishserviceprop.load(publishService);

		publishCommonInfo_correlationid_tbx.sendKeys(publishserviceprop.getProperty("publishCommonInfo_correlationID"));
		publishCommonInfo_sourceSystem_tbx.sendKeys(publishserviceprop.getProperty("publishCommonInfo_sourceSystem"));
		publishCommonInfo_serviceIndicator_tbx.sendKeys(publishserviceprop.getProperty("publishCommonInfo_serviceIndicator"));
		publishCommonInfo_updatedBy_tbx.sendKeys(publishserviceprop.getProperty("publishCommonInfo_updatedBy"));
		publishCommonInfo_publishReason_tbx.sendKeys(publishserviceprop.getProperty("publishCommonInfo_publishReason"));

		CommonMethods.scrollintoview(requestDetails_correlationid_tbx);
		requestDetails_correlationid_tbx.sendKeys(publishserviceprop.getProperty("requestDetails_correlationID"));
		requestDetails_requestStatus_tbx.sendKeys(publishserviceprop.getProperty("requestDetails_requestStatus"));
		requestDetails_requestStatusCode_tbx.sendKeys(publishserviceprop.getProperty("requestDetails_requestStatusCode"));
		CommonMethods.scrollintoview(requestDetails_requestStatusMessage_tbx);
		requestDetails_requestStatusMessage_tbx.sendKeys(publishserviceprop.getProperty("requestDetails_requestStatusMessage"));
		requestDetails_notBeforeDate_tbx.sendKeys(publishserviceprop.getProperty("requestDetails_notBeforeDate"));
		requestDetails_customerCommitmentDate_tbx.sendKeys(publishserviceprop.getProperty("requestDetails_customerCommitmentDate"));
		requestDetails_comment_tbx.sendKeys(publishserviceprop.getProperty("requestDetails_comment"));

		microServiceDetails_transactionID_tbx.sendKeys(publishserviceprop.getProperty("microServiceDetails_transactionID"));
		microServiceDetails_microServiceName_tbx.sendKeys(publishserviceprop.getProperty("microServiceDetails_microServiceName"));
		microServiceDetails_microServiceStatus_tbx.sendKeys(publishserviceprop.getProperty("microServiceDetails_microServiceStatus"));
		microServiceDetails_microServiceStatusCode_tbx.sendKeys(publishserviceprop.getProperty("microServiceDetails_microServiceStatusCode"));
		microServiceDetails_microServiceStatusMessage_tbx.sendKeys(publishserviceprop.getProperty("microServiceDetails_microServiceStatusMessage"));
		microServiceDetails_dueDate_tbx.sendKeys(publishserviceprop.getProperty("microServiceDetails_dueDate"));
		microServiceDetails_completeDate_tbx.sendKeys(publishserviceprop.getProperty("microServiceDetails_completeDate"));
		microServiceDetails_comment_tbx.sendKeys(publishserviceprop.getProperty("microServiceDetails_comment"));
		microServiceDetails_actionResponse_tbx.sendKeys(publishserviceprop.getProperty("microServiceDetails_actionResponse"));
		
		CommonMethods.captureScreenshot(
				URLConfigs.SCREENSHOT_PATH + "\\Publish Service form" + "_" + SeleniumDriver.timestamp() + ".png");

		clickonSubmitbutton();

	}

	public void clickonSubmitbutton() throws InterruptedException {

		if (Submit_btn.isEnabled()) {
			CommonMethods.scrollintoview(Submit_btn);
			Submit_btn.click();
			Log.info("Clicked on Notify Service Submit button..");
		}

		Thread.sleep(4000);
	}

	public void validateResponse() throws InterruptedException, JSONException {

		CommonMethods.WaitforElement(responseparagraph);

		CommonMethods.scrollintoview(responseparagraph);

		String PublishService_response = responseparagraph.getText();
		Log.info("Publish service Response = " + PublishService_response);
		CommonMethods.captureScreenshot(
				URLConfigs.SCREENSHOT_PATH + "\\Publish Service response" + "_" + SeleniumDriver.timestamp() + ".png");

		JSONObject json = new JSONObject(PublishService_response);

		JSONArray recs = json.getJSONArray("Response");
		int responseListlength = recs.length();

		for (int i = 0; i < responseListlength; i++) {

			JSONObject rec = recs.getJSONObject(i);

			boolean checexception = rec.has("exception");
			System.out.println(checexception);
			
			boolean checkresponse = rec.has("Response") ;
			System.out.println(checkresponse);

			if (checexception == true) {

				String exceptioninResponse = rec.getString("exception");
				System.out.println("Exception Received = " + exceptioninResponse);
				SoftAssert softAssertion= new SoftAssert();
				softAssertion.fail("Exception received = "+ exceptioninResponse);

			} else if (checkresponse==true) {
				
				String responsereceived = rec.getString("Response");
				System.out.println("Response Received = " + responsereceived);
				
				JsonParser parser = new JsonParser();
				
				JsonElement j1 = parser.parse(responsereceived);
				JsonObject jsonObject = j1.getAsJsonObject();	
				System.out.println("Code = "+jsonObject.get("status").getAsJsonObject().get("code"));
				System.out.println("message = "+jsonObject.get("status").getAsJsonObject().get("message"));
				
			}

		}
		
		closePublishServiceTab();

	}
	
	
	public void closePublishServiceTab() {
		
		Publish_Service_Tab_close_img.click();
	}
	

}
