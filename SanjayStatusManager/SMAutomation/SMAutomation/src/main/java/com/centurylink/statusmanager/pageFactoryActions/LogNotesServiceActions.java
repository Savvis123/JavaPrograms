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
import org.testng.Assert;

import com.centurylink.statusmanager.utilities.CommonMethods;
import com.centurylink.statusmanager.utilities.SeleniumDriver;
import com.centurylink.statusmanager.utilities.URLConfigs;

public class LogNotesServiceActions {

	WebDriver driver;

	FileInputStream lognotesdata;

	Properties lognotesprop = new Properties();

	HomePageActions homePageActions = new HomePageActions(driver);
	QueryHstoryPageActions queryHstoryActions = new QueryHstoryPageActions(driver);
	private final static org.slf4j.Logger Log = LoggerFactory.getLogger(LogNotesServiceActions.class);
	

	public LogNotesServiceActions(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}

	@FindBy(xpath = "//input[@ng-model='LogNotesServiceRequest.correlationID']")
	public WebElement correlationid_tbx;

	@FindBy(xpath = ".//textarea[@ng-model='LogNotesServiceRequest.comments']")
	public WebElement comments_txtarea;

	@FindBy(xpath = ".//*[@ng-model='LogNotesServiceRequest.updatedBy']")
	public WebElement updatedBy_tbx;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement Submit_btn;

	@FindBy(xpath = "//div[label[(text()='Response')]]/div/pre/p")
	public WebElement responseparagraph;

	@FindBy(xpath = "//tab-heading[span[text()='Log Notes Service']]/a/img[1]")
	public WebElement LogNotes_Service_Tab_close_btn;

	// **************** to be moved to Request details page *********************

	@FindBy(xpath = ".//textarea[@ng-model='requestComments.latestComments']")
	public WebElement requestDetailsPageComments_txtarea;

	@FindBy(xpath = ".//*[@id='requestDetailsSubTab']//a[contains(text(),'Log Details')]")
	public WebElement LogDetailsTab_lbl;

	@FindBy(xpath = ".//*/button[contains(@ng-click,'refreshRequestLogs')]")
	public WebElement RefreshLogs_btn;

	@FindBy(xpath = ".//*[@ng-model='logDetails']")
	public WebElement logDetails_tbx;

	@FindBy(xpath = "(.//*[contains(@id,'reqDetSubTabContentFrame')]//pre)[position()=1]")
	public WebElement logDetails_Logcomments_lbl;

	@FindBy(xpath = ".//input[@ng-model='logUserId']")
	public WebElement logUserID_tbx;

	@FindBy(xpath = "(.//*[contains(@id,'reqDetSubTabContentFrame')]//div[contains(text(),'NOTES_SERVICE')])[position()=1]")
	public WebElement logDetails_Notes_Service_lbl;

	// *************** Page method's begin from here ****************

	public void fillLogNotesServiceForm() throws InterruptedException, IOException {

		lognotesdata = new FileInputStream(URLConfigs.TEST_DATA + "\\LogNotesService.properties");

		lognotesprop.load(lognotesdata);
		correlationid_tbx.sendKeys(lognotesprop.getProperty("CorrelationID"));
		comments_txtarea.sendKeys(lognotesprop.getProperty("Comments"));
		updatedBy_tbx.sendKeys(lognotesprop.getProperty("UpdatedBy"));
		Thread.sleep(3000);
		Submit_btn.click();
		// Thread.sleep(6000);

	}

	public void validate_log_notes_response() throws JSONException, InterruptedException {

		CommonMethods.WaitforElement(responseparagraph);

		String lognotes_response = responseparagraph.getText();
		CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\Log_notes_form_request_&_response" + "_"
				+ SeleniumDriver.timestamp() + ".png");

		JSONObject json = new JSONObject(lognotes_response);
		String actual_response_message = json.getString("message");
		String actual_response_code = json.getString("code");
		String expected_response_mesage = "Notes Updated  Successfully";
		String expected_response_code = "Notes Updated  Successfully";

		if (actual_response_message.contains(expected_response_mesage)) {

		//	System.out.println("Message = " + actual_response_message + "  " + "Status Code = " + actual_response_code);
			Log.info("Message = " + actual_response_message + " " + "Status Code = " +
			 actual_response_code);
			Assert.assertEquals(actual_response_message, actual_response_message);
		} else {

		//	System.out.println("Message = " + actual_response_message + "  " + "Status Code = " + actual_response_code);
			Log.warn("Message = " + actual_response_message + " " + "Status Code = " +
			 actual_response_code);

		}
		LogNotes_Service_Tab_close_btn.click();
		// Log.info("Closed Log Notes Service tab");

	}
	
	public void searchrequsingCorrID() {
		
		homePageActions.SearchSlider_CorrelationID_tbx.sendKeys(lognotesprop.getProperty("CorrelationID"));
	}

	public String getCommentfromRequestPage() {

		String comments = requestDetailsPageComments_txtarea.getText();
		return comments;
	}

	public void validate_comments_displayed_in_request_page() throws InterruptedException {

		CommonMethods.WaitforElement(queryHstoryActions.requestPageStatusCode_lbl);
		CommonMethods.captureScreenshot(
				URLConfigs.SCREENSHOT_PATH + "\\validated request page after updating comments from Log Notes Service"
						+ "_" + SeleniumDriver.timestamp() + ".png");

	}

	public void clickonLogDetailsTab() throws InterruptedException { 

		LogDetailsTab_lbl.click();
		RefreshLogs_btn.click();

		Thread.sleep(2000);
	}

	public void getcommentsvalidationfromLogstab() throws InterruptedException {
		
		System.out.println("notest = "+ lognotesprop.getProperty("LogUserID"));

	//	logUserID_tbx.sendKeys(lognotesprop.getProperty("LogUserID"));

		String actualComments = logDetails_Logcomments_lbl.getText();
		String expected_comments = lognotesprop.getProperty("Comments");

		logUserID_tbx.sendKeys(lognotesprop.getProperty("LogUserID")); 
		
		if (expected_comments.equals(actualComments)) {

			System.out.println("Information matched successfully");
				CommonMethods.highlightUIElement(logDetails_Logcomments_lbl);
			
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH
					+ "\\validated comments in Log Details tab after updating comments from Log Notes Service" + "_"
					+ SeleniumDriver.timestamp() + ".png");
		} else {

			System.err.println("Could not find the expected comments in the Log Details tab");
			Log.error("Could not find the expected comments in the Log Details tab");
		}

		homePageActions.closeSearchResultTab_img.click();
		homePageActions.closeRequestTab_img.click();

	}

}
