package com.centurylink.statusmanager.pageFactoryActions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import com.centurylink.statusmanager.utilities.CommonMethods;
import com.centurylink.statusmanager.utilities.SeleniumDriver;
import com.centurylink.statusmanager.utilities.URLConfigs;

public class NotifyServicesPageActions {

	WebDriver driver;
	
	private final static org.slf4j.Logger Log = LoggerFactory.getLogger(NotifyServicesPageActions.class);

	HomePageActions homePageActions = new HomePageActions(driver);
	LogNotesServiceActions logNotesServiceActions = new LogNotesServiceActions(driver);

	FileInputStream notifyServicefile;
	Properties notifyprop = new Properties();

	public NotifyServicesPageActions(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}

	@FindBy(xpath = "//input[@ng-model='NotifyServiceRequest.correlationID']")
	public WebElement correlationid_tbx;

	@FindBy(xpath = ".//*[@ng-model='NotifyServiceRequest.notifyCode']")
	public WebElement notifycode_tbx;

	@FindBy(xpath = ".//*[@ng-model='NotifyServiceRequest.notifyType']")
	public WebElement notifytype_tbx;

	@FindBy(xpath = ".//*[@ng-model='NotifyServiceRequest.notifyDetail']")
	public WebElement notifydetail_tbx;

	@FindBy(xpath = ".//*[@ng-model='NotifyServiceRequest.comments']")
	public WebElement comments_txtarea;

	@FindBy(xpath = ".//*[@ng-model='NotifyServiceRequest.updatedBy']")
	public WebElement updatedBy_tbx;

	@FindBy(xpath = ".//*[@ng-model='NotifyServiceRequest.action']")
	public WebElement action_tbx;

	@FindBy(xpath = ".//*[@ng-show='serviceResponse']/div/pre/p")
	public WebElement responseparagraph;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement Submit_btn;

	@FindBy(xpath = ".//*[@class='btn btn-info btn-lg']")
	public WebElement ViewEditIcon_img;

	@FindBy(xpath = ".//*[contains(@id,'flagGroup')]")
	public WebElement FlagName_lbl;

	@FindBy(xpath = "//tab-heading[span[text()='Notify Service']]/a/img[1]")
	public WebElement Notify_Service_Tab_close_img;

	
	//  **********************  Page method begins from here  *********************
	
	public void fill_notify_service_form() throws InterruptedException, IOException {

		notifyServicefile = new FileInputStream(URLConfigs.TEST_DATA + "\\NotifyServices.properties");
		
		notifyprop.load(notifyServicefile);

		System.out.println("ID = " + notifyprop.getProperty("correlationID"));
		 Log.info("CorrelationID used NotifyService = "+notifyprop.getProperty("correlationID"));
		
		
		homePageActions.TestRest_lnk.click();
		homePageActions.NotifyService_lnk.click();

		Log.info("Launched Notify Service tab.");
		correlationid_tbx.sendKeys(notifyprop.getProperty("correlationID"));
		notifycode_tbx.sendKeys(notifyprop.getProperty("notifyCode"));
		notifytype_tbx.sendKeys(notifyprop.getProperty("notifyType"));
		notifydetail_tbx.sendKeys(notifyprop.getProperty("notifyDetail"));
		comments_txtarea.sendKeys(notifyprop.getProperty("comments"));
		updatedBy_tbx.sendKeys(notifyprop.getProperty("updatedBy"));
		action_tbx.sendKeys(notifyprop.getProperty("action"));
		Thread.sleep(3000);
		Submit_btn.click();
		Log.info("Clicked on Notify Service Submit button..");
		Thread.sleep(4000);

	}

	public void validate_response_notify_service() throws JSONException, InterruptedException {

		CommonMethods.WaitforElement(responseparagraph);

		String NotifyService_response = responseparagraph.getText();
		CommonMethods.captureScreenshot(
				URLConfigs.SCREENSHOT_PATH + "\\Notify_Service_response" + "_" + SeleniumDriver.timestamp() + ".png");

		JSONObject json = new JSONObject(NotifyService_response);

		String Expected_message = "SM Received Notify Flag";
		@SuppressWarnings("unused")
		String Expected_code = "200";

		String actual_message_response = json.getString("message");
		String actual_code_response = json.getString("code");

		if (actual_message_response.contains(Expected_message)) {
			System.out.println("Validation passed");
			System.out.println("Message = " + actual_message_response + "    " + "Code = " + actual_code_response);
			Log.info("Message = " + actual_message_response + "    " + "Code = " + actual_code_response);

		} else if (actual_message_response.contains("SM Notify Flag already exists")) {
			System.out.println("SM Notify Flag already exists with this correlationId");
			Log.info("SM Notify Flag already exists with this correlationId");
			System.err.println("Message = " + actual_message_response + "    " + "Code = " + actual_code_response);
			
		} else {

			System.err.println("Validation failed");
			System.err.println("Message = " + actual_message_response + "    " + "Code = " + actual_code_response);
		}

		Notify_Service_Tab_close_img.click();
	}

	public void validate_newly_added_FLAG_on_UI() throws InterruptedException, IOException {

		homePageActions.SearchSliderIcon_lnk.click();
		
		Thread.sleep(3000);

		notifyServicefile = new FileInputStream(URLConfigs.TEST_DATA + "\\NotifyServices.properties");

		notifyprop.load(notifyServicefile);

		if (homePageActions.SearchSlider_CustomerName_tbx.isDisplayed()) {
			// System.out.println("Corr ID isDisplayed = True" );
			homePageActions.SearchSlider_CorrelationID_tbx.sendKeys(notifyprop.getProperty("correlationID"));

		} else {
			System.err.println("Not able to location Customer Name text box under search type as Request");
			Log.error("Not able to location Customer Name text box under search type as Request");
		}
		homePageActions.SearchSlider__Search_btn.click();
		// Slider_SearchButton.click();
		if (ViewEditIcon_img.isDisplayed()) {
			ViewEditIcon_img.click();
		}
		Thread.sleep(5000);

		CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\Validated newly added flag on request page"
				+ "_" + SeleniumDriver.timestamp() + ".png");

		String flag_details = FlagName_lbl.getText();
		/* System.out.println("Flag info = " + flag_details); */

		if (flag_details.contains(notifyprop.getProperty("notifyCode"))) {

			System.out.println("Successfully validated the newly added FLAG on the Request Page");
			Log.info("Successfully validated the newly added FLAG on the Request Page");
		}

	}

	public void getFlagDetailsfromLogDetailsTab() throws InterruptedException {
	
		logNotesServiceActions.logUserID_tbx.sendKeys(notifyprop.getProperty("LogUserID"));
		
		String actualData = logNotesServiceActions.logDetails_Logcomments_lbl.getText();
		String expected_notifyType = notifyprop.getProperty("notifyType");
		
		System.out.println("actualData = "+ actualData);
		System.out.println("expected_notifyType = "+ expected_notifyType);
		
		if(actualData.contains(expected_notifyType)) {
			
			System.out.println("Information matched successfully");
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH
					+ "\\validated Flag Details in Log Details tab after new FLAG using Notify Service" + "_"
					+ SeleniumDriver.timestamp() + ".png");
		} else {

			System.err.println("Could not find the expected comments in the Log Details tab");
		}

		homePageActions.closeSearchResultTab_img.click();
		homePageActions.closeRequestTab_img.click();
	}

}
