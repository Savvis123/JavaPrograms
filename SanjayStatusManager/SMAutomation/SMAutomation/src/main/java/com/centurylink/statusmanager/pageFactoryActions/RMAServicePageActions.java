package com.centurylink.statusmanager.pageFactoryActions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import com.centurylink.statusmanager.utilities.CommonMethods;
import com.centurylink.statusmanager.utilities.SeleniumDriver;
import com.centurylink.statusmanager.utilities.URLConfigs;

public class RMAServicePageActions {

	WebDriver driver;
	
	boolean RMAinRequestStatus ;
	String requestStatuswhenRMA ;

	FileInputStream rmaServicefile;

	Properties rmaprop = new Properties();

	private final static org.slf4j.Logger Log = LoggerFactory.getLogger(RMAServicePageActions.class);
	HomePageActions homePageActions = new HomePageActions(driver);

	public RMAServicePageActions(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}

	@FindBy(xpath = ".//input[@ng-model='RMAServiceRequest.correlationID']")
	public WebElement CorrelationID_tbx;

	@FindBy(xpath = ".//input[@ng-model='RMAServiceRequest.transactionID']")
	public WebElement TransactionID_tbx;

	@FindBy(xpath = ".//input[@ng-model='RMAServiceRequest.rmaId']")
	public WebElement rmaID_tbx;

	@FindBy(xpath = ".//input[@ng-model='RMAServiceRequest.rmaType']")
	public WebElement rmaType_tbx;

	@FindBy(xpath = ".//input[@ng-model='RMAServiceRequest.rmaDescription']")
	public WebElement rmaDescription_tbx;

	@FindBy(xpath = ".//input[@ng-model='RMAServiceRequest.rmaActionType']")
	public WebElement rmaActionType_tbx;

	@FindBy(xpath = ".//input[@ng-model='RMAServiceRequest.sourceOfRMA']")
	public WebElement sourceOfRMA_tbx;

	@FindBy(xpath = ".//input[@ng-model='RMAServiceRequest.rmaEventDate']")
	public WebElement rmaEventDate_tbx;

	@FindBy(xpath = ".//input[@ng-model='RMAServiceRequest.createdBy']")
	public WebElement createdBy_tbx;

	@FindBy(xpath = ".//input[@ng-model='RMAServiceRequest.comments']")
	public WebElement comments_tbx;

	@FindBy(xpath = ".//button[@alt='add RMAServiceRequest']")
	public WebElement Submit_btn;

	@FindBy(xpath = ".//*[@ng-show='serviceResponse']/div/pre/p")
	public WebElement responseparagraph;

	@FindBy(xpath = "//tab-heading[span[text()='RMA Service']]/a/img[1]")
	public WebElement RMAServiceTabCloseicon_img;

	@FindBy(xpath = "//tab-heading[span[text()='RMA Service']]")
	public WebElement RMAServiceTab_lbl;

	@FindBy(xpath = ".//*[@class='btn btn-info btn-lg']")
	public WebElement ViewEditicon_img;

	@FindBy(xpath = "//ng-include[@id='sidemenu']/div[2]//button[@type='submit']")
	private WebElement search_btn;

	@FindBy(xpath = ".//*[@id='statusDetails']/ul/li[3]/div[2]")
	public WebElement CorrelationIDStatusDetails_lbl;

	@FindBy(xpath = ".//*[contains(@id,'microServiceList')]//i[@class='fa fa-bell' and @tooltip='Active RMA']")
	public WebElement ActiveRMA_icon;

	@FindBy(xpath = "//tab-heading[span[text()='RMA Service']]/a/img[1]")
	private WebElement CloseRMAServiceTabicon_img;
	
	@FindBy(how=How.XPATH, using =".//span[contains(@ng-bind,'getRequestStatus')]")
	private WebElement RequestStatus_lbl;
	
	@FindBy(how=How.XPATH, using = "//button[@ng-click='setRmaCompleteComment()']")
	private WebElement RMAComplete_btn;
	
	// *********************  Active RMA check *************
	
	@FindBy(how=How.XPATH, using = "//ul[contains(@id,'microServiceList')]")
	private WebElement microserviceList;
	
	@FindBy(how=How.XPATH, using = "//ul[contains(@id,'microServiceList')]//i[@tooltip='Active RMA' and @class='fa fa-bell']")
	private WebElement activeRMAIcon_img;
	
	@FindBy(how=How.XPATH, using = "//ul[contains(@id,'microServiceList')]//i[@tooltip='Active RMA' and @class='fa fa-bell']/../h1")
	private WebElement microServicewithActiveRMA_lbl;
	
	@FindBy(how=How.XPATH, using = "//textarea[@ng-model='rmaCompletePopUp.completeComment']")
	private WebElement rmaCompleteComment_txtarea;
	
	@FindBy(how=How.XPATH, using = " .//*[contains(@id,'RMACompleteConfirmation')]//button[contains(text(),'Yes')]")
	private WebElement rmaCompleteYes_btn;
	
	@FindBy(how=How.XPATH, using = " .//*[contains(@id,'RMACompleteConfirmation')]//button[contains(text(),'Cancel')]")
	private WebElement rmaCompleteCancel_btn;
	
	@FindBy(how=How.XPATH, using = " .//*[@id='toast-container']/div//div[@class='toast-title']")
	private WebElement toastermessagestatus_lbl;
	
	@FindBy(how=How.XPATH, using = " .//*[@id='toast-container']/div//div[@class='toast-message']")
	private WebElement toastermessage_lbl;
	
	@FindBy(how=How.XPATH, using = ".//*[@id='toast-container' and @role='alert']")
	private WebElement toastermessagecontainer_lbl;
	
/*	@FindBy(how=How.XPATH, using = " .//*[contains(@id,'RMACompleteConfirmation')]//button[contains(text(),'Cancel')]")
	private WebElement errortoastermessagestatus_lbl;*/
	
	// ********************** Page method begins from here *********************

	// ********************** New method begins from here *********************

	
	public void AddRMAtoMicroServiceUisngRMAService(String RMAActionType) throws FileNotFoundException {

		rmaServicefile = new FileInputStream(URLConfigs.TEST_DATA + "\\RMAService.properties");
		rmaprop = new Properties();

		try {
			rmaprop.load(rmaServicefile);
		} catch (IOException e) {

			e.printStackTrace();
			// Log.error("Error = ", e);
		}
		CommonMethods.WaitforElement(RMAServiceTab_lbl);

		loadDatafrompropertyfile(RMAActionType);

		CommonMethods.WaitforElementtobeClickable(Submit_btn);
		Submit_btn.click();

	}

	public void validatingResponseforRMAscenario(String ActionType) throws JSONException, InterruptedException {

		String Expected_message = "RMA request " + ActionType + " completed successfully";

		CommonMethods.WaitforElement(responseparagraph);

		String RMAService_response = responseparagraph.getText();
		Log.info("RMA Response = " + RMAService_response);

		CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\" + ActionType + "_" + "RMA_Service_response"
				+ "_" + SeleniumDriver.timestamp() + ".png");

		JSONObject json = new JSONObject(RMAService_response);
		String Actual_message = json.getString("message");
		json.getString("code");

		if (Actual_message.contains(Expected_message)) {

			Log.info("RMA Added to the CorrelationID =" + rmaprop.getProperty("correlationID") + " "
					+ "having TransactionID = " + rmaprop.getProperty("transactionID"));

		} else {

			System.out.println(Actual_message);
			Log.error(Actual_message);
		}

		CloseRMAServiceTabicon_img.click();
	}

	public void validatingRequestPageforRMAScenario(String ActionType) throws InterruptedException {

		homePageActions.SearchSliderIcon_lnk.click();

		CommonMethods.WaitforElement(homePageActions.SearchSlider_CorrelationID_tbx);
		homePageActions.SearchSlider_CorrelationID_tbx.sendKeys(rmaprop.getProperty("correlationID"));
		search_btn.click();

		CommonMethods.WaitforElement(ViewEditicon_img);
		ViewEditicon_img.click();

		CommonMethods.WaitforElement(CorrelationIDStatusDetails_lbl);
		String RequestPage_CorrelationID = CorrelationIDStatusDetails_lbl.getText();
		System.out.println("CorrelationID in Request Page = " + RequestPage_CorrelationID);

		checkForRMAFlag(ActionType);
		validateRMAtableinMicroServiceSection(ActionType);

	}

	// ********** Common Code related to RMA scenario ************

	/**
	 * @author AB42590
	 * @Description - Reads the data from the property file and fills the RMA
	 *              Service form
	 */
	public void loadDatafrompropertyfile(String rmaActionType) {

		CorrelationID_tbx.sendKeys(rmaprop.getProperty("correlationID"));
		TransactionID_tbx.sendKeys(rmaprop.getProperty("transactionID"));
		rmaID_tbx.sendKeys(rmaprop.getProperty("rmaId"));
		rmaType_tbx.sendKeys(rmaprop.getProperty("rmaType"));
		rmaActionType_tbx.sendKeys(rmaActionType);
		sourceOfRMA_tbx.sendKeys(rmaprop.getProperty("sourceOfRMA"));
		rmaEventDate_tbx.sendKeys(rmaprop.getProperty("rmaEventDate"));
		createdBy_tbx.sendKeys(rmaprop.getProperty("createdBy"));

		if ("ADD".equalsIgnoreCase(rmaActionType)) {

			rmaDescription_tbx.sendKeys(rmaprop.getProperty("ADDScenario_rmaDescription"));
			comments_tbx.sendKeys(rmaprop.getProperty("ADDScenario_comments"));

		} else if ("UPDATE".equalsIgnoreCase(rmaActionType)) {

			rmaDescription_tbx.sendKeys(rmaprop.getProperty("UpdateScenario_rmaDescription"));
			comments_tbx.sendKeys(rmaprop.getProperty("UpdateScenario_comments"));

		} else if ("DELETE".equalsIgnoreCase(rmaActionType)) {

			rmaDescription_tbx.sendKeys(rmaprop.getProperty("DeleteScenario_rmaDescription"));
			comments_tbx.sendKeys(rmaprop.getProperty("DeleteScenario_comments"));
		}

	}

	/**
	 * @author AB42590
	 * @throws InterruptedException
	 * @Description - Verifies the RMA flag is present under the FLAGGED Request
	 *              section
	 */
	public void checkForRMAFlag(String rmaActionType) throws InterruptedException {

		int flagSize = SeleniumDriver.getDriver().findElements(By.xpath(".//div[contains(@id,'flagGroup')]/div"))
				.size();
		if (flagSize == 0) {

			System.err.println("Request is not FLAGGED.");
			// Log.error("Request is not FLAGGED.");

			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\FLAG_not_present_in_the_request_page" + "_"
					+ SeleniumDriver.timestamp() + ".png");

		} else {

			rmaflagCheck(rmaActionType, flagSize);

		}

	}

	public void rmaflagCheck(String rmaActionType, int flagSize) throws InterruptedException {

		if ("ADD".equalsIgnoreCase(rmaActionType)) {

			verifyRMAflaginrequestFlagged(flagSize, rmaActionType);

		} else if ("UPDATE".equalsIgnoreCase(rmaActionType)) {

			verifyRMAflaginrequestFlagged(flagSize, rmaActionType);

		} else if ("DELETE".equalsIgnoreCase(rmaActionType)) {

			deleteRMAflagcheck(flagSize);
		}

	}

	/**
	 * @author AB42590
	 * @param flagSize
	 * @throws InterruptedException
	 * @Description - This method will check if the RMA flag is added to the flagged
	 *              request section. If found then expands the flag and captures the
	 *              different attributes and values of the flag.
	 * 
	 */
	public void verifyRMAflaginrequestFlagged(int flagSize, String rmaActionType) throws InterruptedException {

		Log.info("Total number of FLAG's tagged to request = " + flagSize);

		for (int i = 1; i <= flagSize; i++) {

			WebElement flagName = SeleniumDriver.getDriver()
					.findElement(By.xpath(".//div[contains(@id,'flagGroup')]/div[" + i + "]"));
			// System.out.println("Flag associated " + i + "= " + flagName.getText());

			String FlagName = flagName.getText().trim();
			FlagName = FlagName.substring(0, FlagName.length() - 6);
			System.out.println("Newly associated Flag = " + FlagName);

			if (FlagName.contains(rmaprop.getProperty("rmaType"))) {

				Log.info("Newly added FLAG is present under FLAGGED Request section.");

				flagName.click();

				List<WebElement> flagdetails = SeleniumDriver.getDriver()
						.findElements(By.xpath(".//div[contains(@id,'flagGroup')]/div[" + i + "]/div[2]/ul/li"));
				int flagdetailsSize = flagdetails.size();

				ArrayList<String> flaglabel = new ArrayList<String>();
				ArrayList<String> flagdata = new ArrayList<String>();

				int j;

				for (j = 1; j <= flagdetailsSize; j++) {

					String a = SeleniumDriver.getDriver()
							.findElement(By.xpath(
									".//div[contains(@id,'flagGroup')]/div[" + i + "]/div[2]/ul/li[" + j + "]/div[1]"))
							.getText();
					String b = SeleniumDriver.getDriver()
							.findElement(By.xpath(
									".//div[contains(@id,'flagGroup')]/div[" + i + "]/div[2]/ul/li[" + j + "]/div[2]"))
							.getText();

					flaglabel.add(a);
					flagdata.add(b);
				}

				Log.info("RMA FLAG details are listed below");
				Log.info("row 1 -> " + flaglabel.get(0) + " = " + flagdata.get(0));
				Log.info("row 2 -> " + flaglabel.get(1) + " = " + flagdata.get(1));
				Log.info("row 3 -> " + flaglabel.get(2) + " = " + flagdata.get(2));
				Log.info("row 4 -> " + flaglabel.get(3) + " = " + flagdata.get(3));
				Log.info("row 5 -> " + flaglabel.get(4) + " = " + flagdata.get(4));

				CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\" + rmaActionType
						+ "_RMA_FLAG_in_the_request_page" + "_" + SeleniumDriver.timestamp() + ".png");
			}
			break;
		}

	}

	/**
	 * @author AB42590
	 * @param flagSize
	 * @Description - This method will check if the FLAG is removed from Request
	 *              page after executing DELETE RMA Service
	 */
	public void deleteRMAflagcheck(int flagSize) {

		// Log.info("Total number of FLAG's tagged to request = " + flagSize);

		for (int i = 1; i <= flagSize; i++) {

			WebElement flagName = SeleniumDriver.getDriver()
					.findElement(By.xpath(".//div[contains(@id,'flagGroup')]/div[" + i + "]"));
			// System.out.println("Flag associated " + i + "= " + flagName.getText());
			String FlagName = flagName.getText().trim();
			FlagName = FlagName.substring(0, FlagName.length() - 6);
			// System.out.println("Newly associated Flag = " + FlagName);

			if (FlagName.contains(rmaprop.getProperty("rmaType"))) {

				System.err.println("Flag was not removed from Request Page");
				Log.error("Flag was not removed from Request Page");

			} else {

				System.out.println("Flag was removed from Request Page after running the Delete RMA Service call");
				Log.info("Flag was not removed from Request Page");
			}
		}

	}


	// ***************************** End of Common Code related to RMA scenario
	// ************************************

	/**
	 * @param ActionType
	 * @throws InterruptedException
	 * @Description - This method will check the Active RMA icon on the microservice
	 * 					and if microservice has Active RMA then validate the RMA table and log entries
	 */
	public void validateRMAtableinMicroServiceSection(String ActionType) throws InterruptedException {

		String msID = rmaprop.getProperty("transactionID");
		
		WebElement MicroServiceName = SeleniumDriver.getDriver()
				.findElement(By.xpath(".//*[contains(@id,'microServiceList')]//h1[@tooltip='Transaction ID:"+ msID + "']"));

		if ("ADD".equalsIgnoreCase(ActionType)) {

			
			
			if (MicroServiceName.isDisplayed()) {
				
				if (CommonMethods.iselementcurrentlyvisible(ActiveRMA_icon)) {

					ActiveRMA_icon.getText();

					System.out.println("Active RMA ICON = " + ActiveRMA_icon.getText());

					Log.info("Active RMA ICON = " + ActiveRMA_icon.getText());
				}

				MicroServiceName.click();

				WebElement RMASubTab = SeleniumDriver.getDriver()
						.findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+msID+"') and @class='collapse in']/div/ul/li[a[contains(text(),'RMA')]]"));

				boolean RMATabCheck = RMASubTab.isDisplayed();

				CommonMethods.scrollintoview(RMASubTab);

				Log.info("RMA tab is displayed in the MS section = " + RMATabCheck);

				RMASubTab.click();

				List<WebElement> RMAType_entries_in_table = SeleniumDriver.getDriver()
						.findElements(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+msID+"')]//tr[@ng-repeat='row in microService.rmaList']/td[2]"));

				int countRMAType = RMAType_entries_in_table.size();

				Log.info("Total Number of RMA's in the table = " + countRMAType);

				int i;
				for (i = 0; i <= countRMAType-1 ; i++) {

					String RMAT = RMAType_entries_in_table.get(i).getText();
					System.out.println("RMA Types = " + i+ " = " + RMAT);
					Log.info("RMA Types = " + i+ " = " + RMAT);

					Map<String,String> datamap = new HashMap<String,String>();
					if (RMAT.equals(rmaprop.getProperty("rmaType"))) {

						Log.info("RMAType is present in the  = " + RMAType_entries_in_table.get(i).getText());

						int j= i+1;
						WebElement rmaID = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+msID +"')]//tr[position()="+j+"]/td[1]"));
						WebElement rmaType = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+msID +"')]//tr[position()="+j+"]/td[2]"));
						WebElement rmaDesc = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[3]"));
						WebElement rmaSource = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[4]"));
						WebElement rmaEventDate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[5]"));
						WebElement rmaComments = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[6]"));
						WebElement rmaCreatedBy = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[7]"));
						WebElement rmaCreatedDate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[8]"));
						WebElement rmaModifiedBy = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[9]"));
						WebElement rmaModifiedDate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[10]"));
						WebElement rmaClearedDate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[11]"));
						WebElement rmaClearRMA = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[12]/span[2]"));
						
						
						
						datamap.put("RMA ID", rmaID.getText()) ;
						datamap.put("RMA Type", rmaType.getText()) ;
						datamap.put("RMA DESCRIPTION", rmaDesc.getText()) ;
						datamap.put("SOURCE OF RMA", rmaSource.getText()) ;
						datamap.put("RMA EVENT DATETIME", rmaEventDate.getText()) ;
						datamap.put("COMMENTS", rmaComments.getText()) ;
						datamap.put("CREATED BY", rmaCreatedBy.getText()) ;
						datamap.put("CREATED DATE",rmaCreatedDate.getText()) ;
						datamap.put("MODIFIED BY",rmaModifiedBy.getText()) ;
						datamap.put("MODIFIED DATE",rmaModifiedDate.getText()) ;
						datamap.put("CLEARED DATE", rmaClearedDate.getText()) ;
					//	datamap.put("CLEAR RMA",rmaClearRMA.getText()) ;
						
						Log.info("RMA table details = "+ datamap);
						
						boolean isDeleteElementCurrentlyEnable = CommonMethods.iselementcurrentlyenable(rmaClearRMA) ;
						
						Log.info(" For ActionType = " + ActionType + " ====== " + "Is RMA clear icon enabled = "+ isDeleteElementCurrentlyEnable );
						CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH+"\\Verified RMA table in request page after "+ActionType+" RMA Action" + "_" + SeleniumDriver.timestamp() + ".png");
						
					}
					break ;
				}
			}

		} if ("UPDATE".equalsIgnoreCase(ActionType)) {

			if (MicroServiceName.isDisplayed()) {

				if (CommonMethods.iselementcurrentlyvisible(ActiveRMA_icon)) {

					ActiveRMA_icon.getText();

					System.out.println("Active RMA ICON = " + ActiveRMA_icon.getText());

					Log.info("Active RMA ICON = " + ActiveRMA_icon.getText());
				}

				MicroServiceName.click();

				WebElement RMASubTab = SeleniumDriver.getDriver()
						.findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID + "') and @class='collapse in']/div/ul/li[a[contains(text(),'RMA')]]"));

				boolean RMATabCheck = RMASubTab.isDisplayed();

				CommonMethods.scrollintoview(RMASubTab);

				Log.info("RMA tab is displayed in the MS section = " + RMATabCheck);
				
				RMASubTab.click();
				List<WebElement> RMAType_entries_in_table = SeleniumDriver.getDriver()
						.findElements(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID + "')]//tr[@ng-repeat='row in microService.rmaList']/td[2]"));

				int countRMAType = RMAType_entries_in_table.size();

				Log.info("Total Number of RMA's = " + countRMAType);

				for (int i = 0; i < countRMAType - 1; i++) {

					String RMAT = RMAType_entries_in_table.get(i).getText();
					System.out.println("RMA Types = " + RMAT);

					Map<String,String> datamap = new HashMap<String,String>();
					if (RMAT.equals(rmaprop.getProperty("rmaType"))) {

						Log.info("RMAType is present in the  = " + RMAType_entries_in_table.get(i).getText());

						int j= i+1;
						WebElement rmaID = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+msID+"')]//tr[position()="+j+"]/td[1]"));
						WebElement rmaType = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[2]"));
						WebElement rmaDesc = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[3]"));
						WebElement rmaSource = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[4]"));
						WebElement rmaEventDate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[5]"));
						WebElement rmaComments = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[6]"));
						WebElement rmaCreatedBy = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID+"')]//tr[position()="+j+"]/td[7]"));
						WebElement rmaCreatedDate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[8]"));
						WebElement rmaModifiedBy = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[9]"));
						WebElement rmaModifiedDate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[10]"));
						WebElement rmaClearedDate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[11]"));
						WebElement rmaClearRMA = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID+"')]//tr[position()="+j+"]/td[12]/span[2]"));
						
						
						
						datamap.put("RMA ID", rmaID.getText()) ;
						datamap.put("RMA Type", rmaType.getText()) ;
						datamap.put("RMA DESCRIPTION", rmaDesc.getText()) ;
						datamap.put("SOURCE OF RMA", rmaSource.getText()) ;
						datamap.put("RMA EVENT DATETIME", rmaEventDate.getText()) ;
						datamap.put("COMMENTS", rmaComments.getText()) ;
						datamap.put("CREATED BY", rmaCreatedBy.getText()) ;
						datamap.put("CREATED DATE",rmaCreatedDate.getText()) ;
						datamap.put("MODIFIED BY",rmaModifiedBy.getText()) ;
						datamap.put("MODIFIED DATE",rmaModifiedDate.getText()) ;
						datamap.put("CLEARED DATE", rmaClearedDate.getText()) ;
					//	datamap.put("CLEAR RMA",rmaClearRMA.getText()) ;
						
						Log.info("RMA table details = "+ datamap);

						// System.out.println("RMAType = " + RMATypefromRequestPage.get(i).getText());
						
						boolean isDeleteElementCurrentlyEnable = CommonMethods.iselementcurrentlyenable(rmaClearRMA) ;
						
						Log.info(" For ActionType = " + ActionType + " ====== " + "Is RMA clear icon enabled = "+ isDeleteElementCurrentlyEnable );

						CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH+"\\Verified RMA table in request page after "+ActionType+" RMA Action" + "_" + SeleniumDriver.timestamp() + ".png");
					
					}
				}

			}

		} if ("DELETE".equalsIgnoreCase(ActionType)) {

			boolean getCurrentVisibilityofActiveRMAIcon = CommonMethods.iselementcurrentlyvisible(MicroServiceName);
			System.out.println("Is Microservice listed in the table = " + getCurrentVisibilityofActiveRMAIcon);

			if (MicroServiceName.isDisplayed()) {

				if (CommonMethods.iselementcurrentlyvisible(ActiveRMA_icon)) {

					ActiveRMA_icon.getText();

					System.out.println("Active RMA ICON = " + ActiveRMA_icon.getText());

					Log.info("Active RMA ICON = " + ActiveRMA_icon.getText());
				}

				MicroServiceName.click();

				WebElement RMASubTab = SeleniumDriver.getDriver()
						.findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID + "') and @class='collapse in']/div/ul/li[a[contains(text(),'RMA')]]"));

				boolean RMATabCheck = RMASubTab.isDisplayed();

				CommonMethods.scrollintoview(RMASubTab);

				Log.info("RMA tab is displayed in the MS section = " + RMATabCheck);
				RMASubTab.click();
				List<WebElement> RMAType_entries_in_table = SeleniumDriver.getDriver()
						.findElements(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"
								+ rmaprop.getProperty("transactionID")
								+ "') and @class='collapse in']/div/div//ng-include[@id='reqDetSubTabContentFrame2']//tbody/tr/td[2]"));

				int countRMAType = RMAType_entries_in_table.size();

				Log.info("Total Number of RMA's = " + countRMAType);
 
				for (int i = 0; i <= countRMAType; i++) {

					String RMAT = RMAType_entries_in_table.get(i).getText();
					System.out.println("RMA Types = " + RMAT);

					Map<String,String> datamap = new HashMap<String,String>();
					
					if (RMAT.equals(rmaprop.getProperty("rmaType"))) {

						Log.info("RMAType is present in the  = " + RMAType_entries_in_table.get(i).getText());

						int j= i+1;
						WebElement rmaID = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+msID+"')]//tr[position()="+j+"]/td[1]"));
						WebElement rmaType = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[2]"));
						WebElement rmaDesc = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[3]"));
						WebElement rmaSource = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[4]"));
						WebElement rmaEventDate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[5]"));
						WebElement rmaComments = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[6]"));
						WebElement rmaCreatedBy = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID+"')]//tr[position()="+j+"]/td[7]"));
						WebElement rmaCreatedDate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[8]"));
						WebElement rmaModifiedBy = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[9]"));
						WebElement rmaModifiedDate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[10]"));
						WebElement rmaClearedDate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID +"')]//tr[position()="+j+"]/td[11]"));
						WebElement rmaClearRMA = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]//div[contains(@id,'"+ msID+"')]//tr[position()="+j+"]/td[12]/span[2]"));
						
						
						datamap.put("RMA ID", rmaID.getText()) ;
						datamap.put("RMA Type", rmaType.getText()) ;
						datamap.put("RMA DESCRIPTION", rmaDesc.getText()) ;
						datamap.put("SOURCE OF RMA", rmaSource.getText()) ;
						datamap.put("RMA EVENT DATETIME", rmaEventDate.getText()) ;
						datamap.put("COMMENTS", rmaComments.getText()) ;
						datamap.put("CREATED BY", rmaCreatedBy.getText()) ;
						datamap.put("CREATED DATE",rmaCreatedDate.getText()) ;
						datamap.put("MODIFIED BY",rmaModifiedBy.getText()) ;
						datamap.put("MODIFIED DATE",rmaModifiedDate.getText()) ;
						datamap.put("CLEARED DATE", rmaClearedDate.getText()) ;
					//	datamap.put("CLEAR RMA",rmaClearRMA.getText()) ;
						
						Log.info("RMA table details = "+ datamap);

					
						boolean isDeleteElementCurrentlyVisible = CommonMethods.iselementcurrentlyvisible(rmaClearRMA);
						Log.info("Is clear RMA icon visible for the deleted RMA entry ? = "+ isDeleteElementCurrentlyVisible);
					
						boolean isDeleteElementCurrentlyEnable = CommonMethods.iselementcurrentlyenable(rmaClearRMA) ;
						Log.info("Is clear RMA icon enabled for the deleted RMA entry ? = "+ isDeleteElementCurrentlyEnable);
						
						if (isDeleteElementCurrentlyEnable == false && isDeleteElementCurrentlyVisible == false) {
						
							Log.info("Delete RMA icon is currently Disabled & not Visible on UI");
							CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH+"\\Verified RMA table in request page after "+ActionType+" RMA Action" + "_" + SeleniumDriver.timestamp() + ".png");
							
						}else {
							
							Log.info("isElementCurrentlyEnable = " + isDeleteElementCurrentlyEnable + "   "
									+ "isElementCurrentlyVisible = " + isDeleteElementCurrentlyVisible);
						}
					}
					break;
				}

			}

		}

	}
	
	
	public boolean verifyRequestStatus() {
		
		CommonMethods.WaitforElement(RequestStatus_lbl);
		String statusmessage = RequestStatus_lbl.getText() ;
		String [] s = statusmessage.split("-") ;
		String actionType = s[0].trim();
		requestStatuswhenRMA = s[1].trim();
		 System.out.println(s[1]);
		 
		if(actionType.equals("RMA")) {
			
			Log.info("RequestActionType = "+ actionType);
			RMAinRequestStatus = true ;
			return RMAinRequestStatus ;
			
		}else {
			
			RMAinRequestStatus = false ;
			Log.error("Action Type of the request is not RMA = "+ actionType);
			SoftAssert sf = new SoftAssert();
			sf.fail("Action Type of the request is not RMA = "+ actionType);
			return RMAinRequestStatus;
			
			
		}
		
	}
	
	public boolean checkRMACompleteButtonVisibility() throws Exception {
		
		boolean status = false ;
		boolean actionTypeValueHasRMA = RMAinRequestStatus;
	//	requestStatuswhenRMA
		
		boolean isRMACompleteButtonVisible = CommonMethods.iselementcurrentlyvisible(RMAComplete_btn) ;
		boolean isRMACompleteButtonEnabled = CommonMethods.iselementcurrentlyenable(RMAComplete_btn) ;
		
		Log.info("Is RMA Complete Button currently visible = " + isRMACompleteButtonVisible);
		Log.info("Is RMA Complete Button currently enabled = " + isRMACompleteButtonEnabled);
		
		if(actionTypeValueHasRMA == true) {
			
			if(requestStatuswhenRMA.contains("Completed")) {
				
				if(isRMACompleteButtonVisible==true) {
					
					if(isRMACompleteButtonEnabled==false) {
						
						Log.info("RMA Complete button matches Expected behavior => RMA Complete button should be disabled when request is in Completed status.");
						
					}else if(isRMACompleteButtonEnabled==true) {
						
						throw new Exception("RMA Complete button does not match Expected behavior => RMA Complete button should be disabled when request is in Completed status.") ;
					}
				}
			
			}else {
				
				if(isRMACompleteButtonVisible==true && isRMACompleteButtonEnabled==true) {
					
					Log.info("RMA Complete button is enabled and displayed in the request page");
					status = true ;
					return status ;
				
				}else if(isRMACompleteButtonVisible==true && isRMACompleteButtonEnabled==false){
					
					System.err.println("Is RMA Complete Button visible = " + isRMACompleteButtonVisible +"\n" +"Is RMA Complete button enabled = "+ isRMACompleteButtonEnabled);
					Log.debug("Is RMA Complete Button visible = " + isRMACompleteButtonVisible +"\n" +"Is RMA Complete button enabled = "+ isRMACompleteButtonEnabled);
					throw new Exception("RMA Complete button is not enabled");
					
					
				}else if (isRMACompleteButtonVisible==false && isRMACompleteButtonEnabled==true) {
					
					System.err.println("Is RMA Complete Button visible = " + isRMACompleteButtonVisible +"\n" +"Is RMA Complete button enabled = "+ isRMACompleteButtonEnabled);
					Log.debug("Is RMA Complete Button visible = " + isRMACompleteButtonVisible +"\n" +"Is RMA Complete button enabled = "+ isRMACompleteButtonEnabled);
					throw new Exception("RMA Complete button is not visible");
					
				
				}else if(isRMACompleteButtonVisible==false && isRMACompleteButtonEnabled==false){
					
					System.err.println("Is RMA Complete Button visible = " + isRMACompleteButtonVisible +"\n" +"Is RMA Complete button enabled = "+ isRMACompleteButtonEnabled);
					Log.error("Is RMA Complete Button visible = " + isRMACompleteButtonVisible +"\n" +"Is RMA Complete button enabled = "+ isRMACompleteButtonEnabled);				
					throw new Error("RMA Complete button is neither visible nor enabled ");
					
				} 
				
			}
			
		}else {
			

			status = false ;
			return status;
			
		}
		
		return status;
		
	}
	
	public void rMAComplete_checkForActiveRMA() throws Exception {
		
		boolean RMACompleteButtonVisibility = checkRMACompleteButtonVisibility();
		System.out.println("status of RMA Complete button visibility = "+ RMACompleteButtonVisibility);
		Log.info("status of RMA Complete button visibility = "+ RMACompleteButtonVisibility);
		
		if(RMACompleteButtonVisibility == true) {
			
			checkforActiveRMA();
		
		}else {
			
			throw new Exception("caught exception - ") ;
		}
		
	}
	
	
	public boolean checkforActiveRMA() {
		
		CommonMethods.WaitforElement(microserviceList);
		
		int count = SeleniumDriver.getDriver().findElements(By.xpath("//ul[contains(@id,'microServiceList')]/li")).size() ;
		System.out.println("number of services attached to request = "+ count);
		boolean status = false ;
		
		
		boolean checkActiveRMAonMS = CommonMethods.iselementcurrentlyvisible(activeRMAIcon_img) ;
		
		System.out.println("checkActiveRMAonMS = " + checkActiveRMAonMS) ;
		
		if(checkActiveRMAonMS==true) {		
		
		for (int i=1; i<=count ; i++) {
			
			boolean checkActiveRMAonMS1 = SeleniumDriver.getDriver().findElement(By.xpath("//ul[contains(@id,'microServiceList')]/li["+(i+1)+"]//i[@tooltip='Active RMA' and @class='fa fa-bell']")).isDisplayed();
			
			if(checkActiveRMAonMS1 == true) {
				Map<String,String> datamap = new HashMap<String,String>();
				String msName = microServicewithActiveRMA_lbl.getText() ;
				String msTransID = microServicewithActiveRMA_lbl.getAttribute("title") ;
				
				datamap.put("msName", msName);
				datamap.put("msTransID", msTransID);
				
			/*	datamap.put(msName, msTransID);*/
				Log.info("Active RMA is present on " + datamap.get("msName") + " having "+ datamap.get("msTransID"));
				 status = true ;
				return status;
			}/*else {
				
				Log.debug("No Active RMA found... !!!");
				 status = false ;
				return status ;
			}*/
			
			}
		
		}else {
		
			Log.debug("No Active RMA found... !!!");
			status = false ;
			return status ;
		
		}
		return status;
		
		
		
	/*	
		
		boolean checkActiveRMAonMS = activeRMAIcon_img.isDisplayed() ;
		
		if(checkActiveRMAonMS == true) {
			
			String msName = microServicewithActiveRMA_lbl.getText() ;
			String msTransID = microServicewithActiveRMA_lbl.getAttribute("title") ;
			Log.info("Active RMA is present on " + msName + " having "+ msTransID);
		
			return true;
		}else {
			
			Log.debug("No Active RMA found... !!!");
			return false ;
		}
		
		*/
		
	}
	
	
	public void verifyErrorMessageonRMAComplete() throws InterruptedException {
		
		clickonRMACompleteButton();
		fillRMACompletePopUp();
		verifyRMACompleteToasterMessageforError();
	}
	
	
	
	public void clickonRMACompleteButton() {
		
		RMAComplete_btn.click();
		Log.info("Clicked on RMA Complete button");
	}
	
	public void fillRMACompletePopUp() throws InterruptedException {
		
		boolean rmaCompleteYesBtnEnabled = CommonMethods.iselementcurrentlyenable(rmaCompleteYes_btn);
		
		if(rmaCompleteYesBtnEnabled== true) {
			
			SoftAssert sf = new SoftAssert();
			sf.assertNotEquals(rmaCompleteYesBtnEnabled, false);
		}
		
		CommonMethods.WaitforElement(rmaCompleteComment_txtarea);
		rmaCompleteComment_txtarea.sendKeys("test comments");
		Log.info("Entered RMA Complete comments in comments section.");
		rmaCompleteYes_btn.click();
		
		//verifyRMACompleteToasterMessage();

	}
	
	public void verifyRMACompleteToasterMessageforError() throws InterruptedException {
		
		Log.info("started with validation of taoster message...");
		CommonMethods.WaitforElement(toastermessagecontainer_lbl);
		String toastermessagestatus = toastermessagestatus_lbl.getText() ;
		String message = toastermessage_lbl.getText();

		if(toastermessagestatus.equalsIgnoreCase("success")) {
			
			String successmessage = toastermessage_lbl.getText();
			System.out.println("successmessage = "+ successmessage);
			Log.error("Actual message did not match the expected behavior.");
			System.out.println("message = "+ message);
			
		}else if(toastermessagestatus.equalsIgnoreCase("fail")) {
			
			String errormessage = toastermessage_lbl.getText();
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\RMA Complete action returned Fail when active RMA is present" + "_" + SeleniumDriver.timestamp() + ".png");
			System.out.println("errormessage = "+ errormessage);
			Log.info("Actual message matches the expected behavior.");
			System.out.println("message = "+ message);
			
		}
		
		Thread.sleep(3000);
	}

	
	public void verifySuccessMessageonRMAComplete() throws InterruptedException {
		
		clickonRMACompleteButton();
		fillRMACompletePopUp();
		verifyRMACompleteToasterMessageforSuccess();
	}
	
	
	public void verifyRMACompleteToasterMessageforSuccess() throws InterruptedException {
		
		Log.info("started with validation of taoster message...");
		CommonMethods.WaitforElement(toastermessagecontainer_lbl);
		String toastermessagestatus = toastermessagestatus_lbl.getText() ;
		String message = toastermessage_lbl.getText();

		if(toastermessagestatus.equalsIgnoreCase("success")) {
			
			String successmessage = toastermessage_lbl.getText();
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\RMA Complete action returned success" + "_" + SeleniumDriver.timestamp() + ".png");
			System.out.println("successmessage = "+ successmessage);
			Log.info("Actual ");
			System.out.println("message = "+ message);
			
		}
		
		if(toastermessagestatus.equalsIgnoreCase("fail")) {
			
			String errormessage = toastermessage_lbl.getText();
		//	CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\RMA Complete action returned failure when no active RMA exists" + "_" + SeleniumDriver.timestamp() + ".png");
			System.out.println("errormessage = "+ errormessage);
			Log.info("Actual message matches the expected behavior.");
			System.out.println("message = "+ message);
			
		}
		
		Thread.sleep(3000);
	}
}
