package com.centurylink.statusmanager.pageFactoryActions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.centurylink.statusmanager.stepDefinitions.HomePage;
import com.centurylink.statusmanager.stepDefinitions.RequestDetailsPage;
import com.centurylink.statusmanager.utilities.CommonMethods;
import com.centurylink.statusmanager.utilities.SeleniumDriver;
import com.centurylink.statusmanager.utilities.URLConfigs;

import junit.framework.Assert;

public class RequestDetailsPageActions {
	
	WebDriver driver ;
	String FLAGType1 = null ;
	
	
	public String wrkgrp_assign = null;
	public String wrkgrp_remove = null ;
	public String actualcomments = null;
	
	public String RetryCommentsByUsers ;
	
	String assignCuid = null ;
	
	int numberofServiceinTable  ;
	
	private final static org.slf4j.Logger Log = LoggerFactory.getLogger(RequestDetailsPageActions.class);
	LogNotesServiceActions logNotesServiceActions = new LogNotesServiceActions(driver);

	
	public RequestDetailsPageActions(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}
	
	
	@FindBy(xpath = ".//*[@id='statusDetails']/ul/li[4]/div[2]")
	public WebElement cuid_value_lbl;
	
	// ------- Add Work group scenario xpath's ---------
	
	
	@FindBy(xpath = ".//*[@id='requestDetailsSubTab']//button[@ng-click='openAssignModal();']")
	public WebElement Assign_btn;
	
	@FindBy(xpath = "//form[contains(@name,'assignForm')]//input[@name='isWrkGrp' and @ng-value='true']")
	public WebElement workgroup_rbtn;

	@FindBy(xpath = ".//input[@placeholder='CUID']")
	public WebElement CUID_tbx;
	
	@FindBy(xpath = ".//*[@class='tab-pane ng-scope active']//.[@ng-model='assign.WORKGROUP_NM']")
	public WebElement dropdownelement_Select_Workgroup;

	@FindBy(xpath = ".//select[@ng-reqiured='assign.isWrkGrp']")
	public WebElement ddl_wrkgp;

	@FindBy(xpath = ".//div[@ng-controller='AssignUserCtrl']//button[contains(text(),'Assign')]")
	public WebElement Assign_Workgroup_btn;

	@FindBy(xpath = ".//div[@ng-controller='AssignUserCtrl']//button[contains(text(),'Cancel')]")
	public WebElement Cancel_Workgroup_btn;

	// ------- Remove Work group scenario xpath's ---------
	
	@FindBy(xpath=".//*[contains(@id,'workGroupPanel')]/div")
	public List<WebElement> workgroupList_lbl ;
	
	// ------- Assign User scenario xpath's ---------
	
	@FindBy(xpath = ".//form[contains(@name,'assignForm')]//input[@name='isWrkGrp' and @ng-value='false']")
	public WebElement user_rbtn;
	
	@FindBy(xpath=".//*[@ng-model='assign.ASSIGNED_TO_ID']")
	public WebElement cuid_tbx ;
	
	// ------- Add Flag scenario xpath's ---------
	
	
	@FindBy(xpath = ".//*[@id='flagDetails']//h4")
	public WebElement requestedFlag_lbl;
	
	@FindBy(xpath = ".//*[@id='flagDetails']//h4")
	public WebElement FLAG_Status_lbl;
	
	@FindBy(xpath = ".//*[@id='requestDetailsSubTab']//button[@ng-disabled='!flagUpdateAccess']")
	public WebElement FLAG_btn;
	
	// ------- Add Flag pop up ---------
	
	@FindBy(xpath = ".//*[@ng-model='selectedFlag' and @name='selectedFlag' ]")
	public WebElement dropdownelement_Select_FLAG_Type;
	
	@FindBy(xpath = ".//input[@name='notify' and @value='TRUE']")
	public WebElement Yes_Notify_rbtn;

	@FindBy(xpath = ".//input[@name='notify' and @value='FALSE']")
	public WebElement No_Notify_rbtn;

	@FindBy(xpath = ".//*[contains(@name,'flagForm')]//textarea[@name='flagComments']")
	public WebElement FLAG_comments_txtarea;

	@FindBy(xpath = ".//*[contains(@name,'flagForm')]//textarea[@name='flagDetails']")
	public WebElement FLAG_Details_txtarea;

	@FindBy(xpath = ".//div[@class='modal modal-centered fade in']//button[contains(@ng-click,'setFlag')]")
	public WebElement Add_FLAG_btn;
	
	// ---------------------------------------------
	
	// ----------- MS Action buttons ----------
	
	@FindBy(how = How.XPATH, using = ".//*[contains(@id,'trueForceCompleteConfirmation') and @class = 'modal fade in']//textarea")
	public WebElement trueFCComments_txtarea ;
	
	@FindBy(how=How.XPATH, using = ".//*[contains(@id,'trueForceCompleteConfirmation') and @class = 'modal fade in']//button[contains(text(),'Yes')]")
	public WebElement trueFCYes_btn ;
	
	@FindBy(how=How.XPATH, using = ".//*[contains(@id,'trueForceCompleteConfirmation') and @class = 'modal fade in']//button[contains(text(),'No')]")
	public WebElement trueFCNo_btn ;
	
	@FindBy(how = How.XPATH, using = ".//*[contains(@id,'forceCompleteConfirmation') and @class = 'modal fade in']//textarea")
	public WebElement verifyFCComments_txtarea ;
	
	@FindBy(how=How.XPATH, using = ".//*[contains(@id,'forceCompleteConfirmation') and @class = 'modal fade in']//button[contains(text(),'Yes')]")
	public WebElement verifyFCYes_btn ;
	
	@FindBy(how=How.XPATH, using = ".//*[contains(@id,'forceCompleteConfirmation') and @class = 'modal fade in']//button[contains(text(),'No')]")
	public WebElement verifyFCNo_btn ;
	
	@FindBy(how=How.XPATH, using= ".//*[contains(@id,'editRetryConfirmation') and @class = 'modal fade in']//textarea")
	public WebElement RetryComments_txtarea ;
	
	@FindBy(how=How.XPATH, using = ".//*[contains(@id,'editRetryConfirmation') and @class = 'modal fade in']//button[contains(text(),'Yes')]")
	public WebElement retryYes_btn ;
	
	@FindBy(how=How.XPATH, using = ".//*[contains(@id,'editRetryConfirmation') and @class = 'modal fade in']//button[contains(text(),'No')]")
	public WebElement retryNo_btn ;
	
	// -------------------------------------
	
	@FindBy(xpath=".//*[@id='toast-container']/div/div[3]")
	public WebElement toasterMessage_lbl; 
	
	@FindBy(xpath = ".//*[contains(@id,'assignUserWrkgrp')]//div[@ng-show='showAssignAlert']")
	public WebElement warningMessage_lbl; 
	
	//***************  Log details tab  **********************
	
	@FindBy(xpath = ".//input[@ng-model='logAction']")
	public WebElement logAction_tbx;
	
	
	//***************  Service summary section  **********************
	
	@FindBy(how=How.XPATH, using=".//*[@ng-if='microserviceSumStatusData']")
	public WebElement microserviceSumStatusData_lbl ;
	
	@FindBy(how=How.XPATH, using=".//*[@ng-if='microserviceSumStatusData']/div/div/span")
	public WebElement serviceSummary_lbl ;
	
	@FindBy(how=How.XPATH, using=".//*[@ng-if='microserviceSumStatusData']/div/div[2]/div/canvas")
	public WebElement serviceSummarychart_img ;
	
	
	
//  **********************  Page method begins from here  *********************
	
	
	public void waitForRequestPageToLoad() {
		
		CommonMethods.WaitforElement(requestedFlag_lbl);
	}
	
	public void verifAndRemoveFlag(String Flag_code) throws InterruptedException {
		

		List<WebElement> FlagList = SeleniumDriver.getDriver().findElements(By.xpath(".//div[@ng-repeat='flag in flagList']"));
		CommonMethods.WaitforElements(FlagList);
		
	//	int flag_size = SeleniumDriver.getDriver().findElements(By.xpath(".//div[@ng-repeat='flag in flagList']")).size();
		int flag_size = FlagList.size();
		
		System.out.println("No of Flags : " + flag_size);
		Log.info("Number of FLAGs tagged to request = " + flag_size);

		for (int i = 1; i <= flag_size; i++) {

			Thread.sleep(3000);
			SeleniumDriver.getDriver().findElement(By.xpath("//div[starts-with(@id, 'flagGroup')]/div[" + i + "]")).click();
			Thread.sleep(3000);
			String flagname = SeleniumDriver.getDriver().findElement(By.xpath("//div[starts-with(@id, 'flagGroup')]/div[" + i + "]")).getText().trim();
			Log.info("flag name = "+ flagname);																																																								Thread.sleep(4000);
			SeleniumDriver.getDriver().findElement(By.xpath("//div[starts-with(@id, 'flagGroup')]/div[" + i + "]/div/h5")).click();

			if (flagname.contains(Flag_code)) {
				System.out.println("Entering flag removal loop");
				SeleniumDriver.getDriver().findElement(By.xpath("//div[starts-with(@id, 'flagGroup')]/div[" + i + "]//button/i")).click();
				
				Thread.sleep(1000);
				
				SeleniumDriver.getDriver().findElement(By.xpath("//div[starts-with(@id, 'flagGroup')]/div[" + i	+ "]//button[@class='yes btn btn-danger btn-primary']")).click();
				Log.info("Clicked on remove Flag icon");
			//	Thread.sleep(2000);
				break;
				
			}
			
		}
	}
	
	public void verifySuccessMessageToaster(String type) throws InterruptedException {
		
		
			if(type.equalsIgnoreCase("FLAG Code")) {
			
				System.out.println("FLAG code ======> "+type);
				System.out.println("Toast Message : "+ toasterMessage_lbl.getText());
				CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH +"\\Search by "+type+" & Success message" +"_"+SeleniumDriver.timestamp()+".png");
				System.out.println("Toaster message is displayed after successfully removing the FLAG...");
				Log.info("Toaster message is displayed after successfully removing the FLAG...");	
			
			}else if(type.equalsIgnoreCase("FLAG Type")) {
			
					System.out.println("FLAG type ======> "+type);
					System.out.println("Toast Message : "+ toasterMessage_lbl.getText());
					CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH +"\\Search by "+type+" & Success message" +"_"+SeleniumDriver.timestamp()+".png");
					System.out.println("Toaster message is displayed after successfully removing the FLAG...");
					Log.debug("Toaster message is displayed after successfully removing the FLAG...");	
		}
		
			Thread.sleep(6000);
	}

	
	
	
	public void validateLogsinLogDetailstab(String logActionType) throws InterruptedException, FileNotFoundException {
		
		logAction_tbx.sendKeys(logActionType);
		 actualcomments = logNotesServiceActions.logDetails_Logcomments_lbl.getText();
		
		if("DELETE FLAG".equals(logActionType)) {
			
			verifyLogTableAfterDeletingFlag(logActionType);
			
		}else if("ASSIGN WORKGROUP".equals(logActionType)) {
			
			verifyLogTableAfterAssigningWorkgroup(logActionType);
			
		}else if("DELETE WORKGROUP".equals(logActionType)) {
			
			verifyLogTableAfterRemovingWorkgroup(logActionType);
			
		}else if("ASSIGN USER/WORKGROUP".equals(logActionType)) {
			
			verifyLogTableAfterAssigningUser(logActionType);
			
		}else if ("ADD".equals(logActionType)) {
			
			validateADDRMALogDetails(logActionType);
			
		}else if ("UPDATE".equals(logActionType)) {
			
			validateADDRMALogDetails(logActionType);
			
		}else if ("DELETE".equals(logActionType)) {
			
			validateADDRMALogDetails(logActionType);
			
		}else if ("SET FLAG".equals(logActionType)) {
			
			verifyLogTableAfterAssigningFlag(logActionType);
			
		}else if ("FORCE_COMPLETE".equals(logActionType)) {
			
			verifyLogTableAfterperformingTrueForceComplete(logActionType);
			
		}else if ("RETRY".equals(logActionType)) {
			
			verifyLogTableAfterperformingRetry(logActionType);
			
		}
		
	}
	
	public void verifyLogTableAfterDeletingFlag(String logActionType) throws InterruptedException {
		
		
		String expectedcomment = HomePage.flagName ;
			if(actualcomments.contains(expectedcomment)) {
			
			System.out.println("DELETE FLAG action is tracked in the Log details table");
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH+"\\Log Details after removing FLAG" +"_"+SeleniumDriver.timestamp()+".png");
		}else {
			
			System.err.println("Could not find entry in the logs ");
		}
		
	}
	
	public void verifyLogTableAfterAssigningWorkgroup(String logActionType) throws InterruptedException {
		
		String expectedcomment = wrkgrp_assign ;
		if(actualcomments.contains(expectedcomment)) {
			
			Log.info("ASSIGN WORKGROUP action is tracked in the Log details table");
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH+"\\Log Details after assigning work-group" +"_"+SeleniumDriver.timestamp()+".png");
		}else {
			
			Log.error("Could not find entry in the logs ");
		}
		
	}
	
	public void verifyLogTableAfterRemovingWorkgroup(String logActionType) throws InterruptedException {
		
		String expectedcomment = wrkgrp_remove ;
		if(actualcomments.contains(expectedcomment)) {
			
			Log.info("DELETE WORKGROUP action is tracked in the Log details table");
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH+"\\Log Details after removing work-group" +"_"+SeleniumDriver.timestamp()+".png");
		}else {
			
			Log.error("Could not find entry in the logs ");
		}
		
		
	}
	
	public void verifyLogTableAfterAssigningUser(String logActionType) throws InterruptedException {
		
		String expectedcomment = assignCuid ;
		if(actualcomments.contains(expectedcomment)) {
			
			Log.info("ASSIGN USER action is tracked in the Log details table");
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH+"\\Log Details after assigning user to request" +"_"+SeleniumDriver.timestamp()+".png");
			
		}else {
			
			Log.error("Could not find entry in the logs ");
		}
		
	}
	
	
	public void verifyLogTableAfterAssigningFlag(String logActionType) throws InterruptedException {
		
		String expectedcomment = RequestDetailsPage.addflagName ;
		if(actualcomments.contains(expectedcomment)) {
			
			Log.info(""+logActionType +" action is tracked in the Log details table");
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH+"\\Log Details after assigning flag to request" +"_"+SeleniumDriver.timestamp()+".png");
			
		}else {
			
			Log.error("Could not find entry in the logs ");
		}
		
	}
	
	
	public void verifyLogTableAfterperformingTrueForceComplete(String logActionType) throws InterruptedException {
		
		String expectedcomment = logActionType ;
		
			if(actualcomments.contains(expectedcomment)) {
				
				Log.info(""+logActionType +" action is tracked in the Log details table");
			
				String statuscode = "CODE:200" ;
				
				if(actualcomments.contains(statuscode)) {
				
					CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH+"\\Log Details after performing True Force Complete on microservice" +"_"+SeleniumDriver.timestamp()+".png");
					Log.info(""+logActionType +" action on MS received "+statuscode +"");
					Log.debug("True FC response = "+actualcomments);
				
				}else {
					
					Log.debug("different True FC response = "+actualcomments);
					CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH+"\\Log Details after performing True Force Complete on microservice but received different status code" +"_"+SeleniumDriver.timestamp()+".png");
				}
		
			}
		
	}
	
	
	public void verifyLogTableAfterperformingRetry(String logActionType) throws InterruptedException {
		
		String expectedcomment = logActionType ;
		
			if(actualcomments.contains(expectedcomment)) {
				
				Log.info(""+logActionType +" action is tracked in the Log details table");
			
				String statuscode = "CODE:202" ;
				
				if(actualcomments.contains(statuscode)) {
				
					CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH+"\\Log Details after performing Retry on microservice" +"_"+SeleniumDriver.timestamp()+".png");
					Log.info(""+logActionType +" action on MS received "+statuscode +"");
					Log.info("True FC response = "+actualcomments);
				
				}else {
					
					Log.debug("different Retry response = "+actualcomments);
					CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH+"\\Log Details after performing Retry on microservice but received different status code" +"_"+SeleniumDriver.timestamp()+".png");
				}
		
			}
		
	}
	
	
	public void verifyMSisDsiplayedinMSTable(String MicroService_Name) throws InterruptedException {
		
		numberofServiceinTable = SeleniumDriver.getDriver().findElements(By.xpath(".//*[contains(@id,'microServiceList')]/li[@ng-repeat='microService in microServicesList']")).size();
		System.out.println("Number of MS's tagged to CorrelationID - " + numberofServiceinTable);
		Log.info("Number of MicroServices tagged to CorrelationID = " + numberofServiceinTable);
		ArrayList<String> ls = new ArrayList<String>();
		int j =0 ;
		for (int i = 1; i <= numberofServiceinTable; i++) {
			 j = i + 1;
			String Ms_name = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1")).getText();

			ls.add(Ms_name);
		}
		System.out.println("List of all MicroService associated = " + ls);
		Log.info("List of all MicroService associated = " + ls);
		if (ls.contains(MicroService_Name)) {

			Log.info(MicroService_Name + "  " + "Microservice found...");
			System.out.println(MicroService_Name + "  " + "Microservice found...");
			
		} else {

			Log.error("Could not find " + MicroService_Name);
			System.err.println("Could not find " + MicroService_Name);
			SoftAssert softassert = new SoftAssert();
			softassert.fail("Could not find " + MicroService_Name);
			
		}
		CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\search_by_microservice" + "_" + SeleniumDriver.timestamp() + ".png");
				
	}
	
	
	public void checkFlagstatusinRequestPage(String FLAGType) throws InterruptedException {
		
		FLAGType1 = FLAGType;

		String check_existing_FLAG = FLAG_Status_lbl.getText();

		if ("No Flags Found".equals(check_existing_FLAG)) {

			System.out.println("Request Status = " + check_existing_FLAG);
			System.out.println("No FLAGs are assigned to this Request !!!!");
		} else {

			System.out.println("Request Status = " + check_existing_FLAG);
			System.out.println("Checking for Existing FLAG(s) info");
		//	get_FLAG_info(FLAGType);

			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\Before assigning FLAG to a request from request Page" + "_" + SeleniumDriver.timestamp() + ".png");

		}
		
	}
	
	
	public void addFlagtoRequest(String flagname) throws InterruptedException {
		
		System.out.println("Entering");
		CommonMethods.WaitforElement(FLAG_btn);
		Thread.sleep(6000);
		FLAG_btn.click();
		System.out.println("Clicked on FLAG button..");

		CommonMethods.WaitforElement(dropdownelement_Select_FLAG_Type);

		Select selectFlagtype = new Select(dropdownelement_Select_FLAG_Type);
		selectFlagtype.selectByVisibleText(flagname);

		String flagtypeselected = selectFlagtype.getFirstSelectedOption().getText();
		Log.info("FLAG Name selected from dropdown = " + flagtypeselected);

		System.out.println("Is Yes radio button for Notify selected = " + Yes_Notify_rbtn.isSelected());
		Log.info("Is Yes radio button for Notify selected = " + Yes_Notify_rbtn.isSelected());
		
		System.out.println(	"Is ADD FLAG button enabled before entering comments & Flag details = " + Add_FLAG_btn.isEnabled());
		Log.info("Is ADD FLAG button enabled before entering comments & Flag details = " + Add_FLAG_btn.isEnabled());
		
		FLAG_comments_txtarea.sendKeys("Test Automation comments !!");
		FLAG_Details_txtarea.sendKeys("Test Automation comments !!");

		Thread.sleep(2000);
		Add_FLAG_btn.click();
	//	Log.info("Clicked on Add FLAG button");
		CommonMethods.WaitforElement(toasterMessage_lbl);

		String success_message = toasterMessage_lbl.getText();
		System.out.println("Success message captured = " + success_message);
	//	Log.info("Success message captured = " + success_message);

		Thread.sleep(7000);
		CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\After assign FLAG to a request from request Page" + "_" + SeleniumDriver.timestamp() + ".png");
		
		
	}
	
	
	public void get_FLAG_info(String FLAGType) throws InterruptedException {

		int flag_size = SeleniumDriver.getDriver().findElements(By.xpath(".//div[@ng-repeat='flag in flagList']")).size();
		System.out.println("Number of Flags tagged to Current Request : " + flag_size);

		for (int i = 1; i <= flag_size; i++) {

			String flagname = SeleniumDriver.getDriver().findElement(By.xpath("//div[starts-with(@id, 'flagGroup')]/div[" + i + "]//h5"))
					.getText();

			if (flagname.equals(FLAGType)) {
				SeleniumDriver.getDriver().findElement(By.xpath("//div[starts-with(@id, 'flagGroup')]/div[" + i + "]//button/i")).click();
				Thread.sleep(1000);
				SeleniumDriver.getDriver().findElement(By.xpath("//div[starts-with(@id, 'flagGroup')]/div[" + i	+ "]//button[@class='yes btn btn-danger btn-primary']")).click();
				Thread.sleep(2000);
				System.out.println("Toast Message : "+ toasterMessage_lbl.getText());

				Thread.sleep(5000);
				break;
			}

		}
	}
	

	public void clickonAssignButton() {
		
		Assign_btn.click();
		CommonMethods.WaitforElement(workgroup_rbtn);
	}
	
	public void assignWorkgrouptoRequest(String wrkgrpName) throws InterruptedException {
		
		wrkgrp_assign = wrkgrpName ; 
		
		workgroup_rbtn.click();
		Thread.sleep(2000);

		SeleniumDriver.getDriver().findElement(By.xpath(
				".//*[starts-with(@id,'assignUserWrkgrp')]//label[starts-with(@for,'s2id_autogen')]/following-sibling::input"))
				.sendKeys(wrkgrpName);
		Thread.sleep(2000);
		SeleniumDriver.getDriver().findElement(By.xpath(".//span[text()='" + wrkgrpName + "']")).click();
		Thread.sleep(2000);

		Assign_Workgroup_btn.click();
		Log.info("Clicked on Assign workgroup button displayed in the Assign workgroup window.");
		CommonMethods.WaitforElement(toasterMessage_lbl);

		String toaster_message = toasterMessage_lbl.getText();
		System.out.println("toaster_message = " + toaster_message);
		Log.info("Toaster Message is after successfully assigning workgroup to request. ====>" + toaster_message);

		CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\Assign WorkGroup to a Request" + "_" + SeleniumDriver.timestamp() + ".png");

	}
	
	public void removeWorkgroupfromRequest(String wrkgrpname) throws InterruptedException {
		
		wrkgrp_remove = wrkgrpname ;
		
		int wrkgrpList_size = workgroupList_lbl.size();
		Log.info("Total workgroup's associated = " + wrkgrpList_size);
		
		for (int i = 1; i <= wrkgrpList_size; i++) {

			String workgrpname = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'workGroupPanel')]/div[" + i + "]")).getText();
			System.out.println("Name = " + workgrpname);
			String trimmedName = workgrpname.substring(0, workgrpname.length() - 7);

			if (trimmedName.equals(wrkgrpname)) {
				SeleniumDriver.getDriver().findElement(By.xpath("//div[contains(@id,'workGroupPanel')]/div[" + i + "]/div/div/div/button/i")).click();
				Thread.sleep(1000);
				SeleniumDriver.getDriver().findElement(By.xpath("//div[starts-with(@id, 'workGroupPanel')]/div[" + i + "]//button[@class='yes btn btn-danger btn-primary']")).click();
				Thread.sleep(2000);
				System.out.println("Toast Message : "+ toasterMessage_lbl.getText());

				Thread.sleep(5000);
				break;
			}

		}
		
	}
	
	public void selectAssignToOptions(String option) throws InterruptedException {
		
		
		if("User".equals(option)) {
			user_rbtn.click();
			
		}else if("WorkGroup".equals(option)) {
			
			workgroup_rbtn.click();
			Thread.sleep(2000);
			
		}
		
	}
	
	
	public void assignCUIDtoRequest(String id) throws InterruptedException {
		
		 assignCuid = id ;
		cuid_tbx.sendKeys(id);
		Assign_Workgroup_btn.click();
		
		CommonMethods.WaitforElement(cuid_value_lbl);
		
		String actualcuid = cuid_value_lbl.getText() ;
		
		if(actualcuid.equals(id)) {
			
			Log.info("User assigned to request");
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\Assign CUID to a Request" + "_" + SeleniumDriver.timestamp() + ".png");
			
		}else{
			
			Log.debug("CUID did not match");
		}

	}
	
	public void assignUserWarningMessage() throws InterruptedException {
		
		Assign_Workgroup_btn.click();
		CommonMethods.WaitforElement(warningMessage_lbl);
		String actualusermsg = warningMessage_lbl.getText() ;
		String expectedmsg = "Please enter CUID" ;
		
		if(actualusermsg.contains(expectedmsg)) {
			
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\Select user warning message" + "_" + SeleniumDriver.timestamp() + ".png");
		}
		Cancel_Workgroup_btn.click();
		
	}
	
	
	public void assignWorkGroupWarningMessage() throws InterruptedException {
		
		Assign_Workgroup_btn.click();
		CommonMethods.WaitforElement(warningMessage_lbl);
		String actualwrkgrpmsg = warningMessage_lbl.getText() ;
		String expectedmsg = "Please select Workgroup" ;
		
		if(actualwrkgrpmsg.contains(expectedmsg)) {
			
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH + "\\Select workgroup warning message" + "_" + SeleniumDriver.timestamp() + ".png");
		}
		Cancel_Workgroup_btn.click();
	}
	
	public void validateADDRMALogDetails(String RMAAction) throws InterruptedException, FileNotFoundException {
		
		FileInputStream rmaServicefile = new FileInputStream(URLConfigs.TEST_DATA + "\\RMAService.properties");
		Properties rmaprop = new Properties();

		try {
			rmaprop.load(rmaServicefile);
		} catch (IOException e) {

			e.printStackTrace();
			Log.error("Error = ", e);
		}
		
		String expected_RMAActionType = RMAAction ;
		String expected_MSID = rmaprop.getProperty("transactionID");

		if(actualcomments.contains(expected_MSID) && actualcomments.contains(expected_RMAActionType)) {
			
			Log.info(""+expected_RMAActionType+" RMA action is tracked in the Log details table");
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH+"\\Log Details for "+expected_RMAActionType+" RMA Action" +"_"+SeleniumDriver.timestamp()+".png");
			
		}else {
			
			Log.error("Could not find entry in the logs ");
		}
	}
	
	
	public void checkandexpandServicesection() throws InterruptedException {
		
		String serviceName = RequestDetailsPage.MSname ;

		int j =0 ;
		for (int i = 1; i <= numberofServiceinTable; i++) {
			 j = i + 1;
			String Ms_name = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1")).getText().trim();

			if(Ms_name.equals(serviceName)) {
				
				SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1")).click();
			}
			
		//	SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Force Complete')]")).isDisplayed() ;
			
			boolean isFCcurrentlyEnabled = CommonMethods.iselementcurrentlyenable(SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Force Complete')]"))) ;
			boolean isFCcurrentlyDsiplayed = CommonMethods.iselementcurrentlyvisible(SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Force Complete')]"))) ;
			
			if (isFCcurrentlyEnabled == true && isFCcurrentlyDsiplayed == true) {
				
				SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Force Complete')]")).click();
				trueFCComments_txtarea.sendKeys(serviceName);
				CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\True Force Complete - popup confirmation" + "_" + SeleniumDriver.timestamp() + ".png");
				trueFCYes_btn.click();
				
			}else {
				
				Assert.fail("Something went wrong here.. please check !!!");
			}
			
			CommonMethods.WaitforElement(toasterMessage_lbl);
			System.out.println("message = " + toasterMessage_lbl.getText());
			Thread.sleep(7000);
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\True Force Complete - success" + "_" + SeleniumDriver.timestamp() + ".png");
		}
		
		
	}
	
	public void performActiononMicroService(String Action, String microservice ) throws InterruptedException {
		String verifyComplete= "Verify Complete";
		
		if ("FORCE COMPLETE".equals(Action)) {
			
			performTrueForceCompleteAction(microservice);
			
		}else if ("RETRY".equals(Action)) {
			
			if("AINProvisioningService".equals(microservice)) {
				
				performRetryActiononAINProvisioningService(microservice);
				
			}else if ("Porting".equals(microservice) || "Portster".equals(microservice)){
				
				performEditandRetryActiononPortingService(microservice);
				
			}else if ("E911".equals(microservice)) {
				
				performEditandRetryActiononPortingService(microservice);
			}
			
		}else if (verifyComplete.equalsIgnoreCase(Action)) {
			
			performVerifyCompleteAction(microservice);
			
		}
		
		
	}
	
	
	/**
	 * @param microservice
	 * @throws InterruptedException
	 * Description - performs validations related to True Force complete scenario
	 */
	public void performTrueForceCompleteAction(String microservice) throws InterruptedException {
	
		int j =0 ; 
		for (int i = 1; i <= numberofServiceinTable; i++) {
			 j = i + 1;
			String Ms_name = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1")).getText().trim();

			if(Ms_name.equals(microservice)) {
			
				CommonMethods.scrollintoview(SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1")));
			 	SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1")).click();
			
				boolean isFCcurrentlyEnabled = CommonMethods.iselementcurrentlyenable(SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Force Complete')]"))) ;
				boolean isFCcurrentlyDsiplayed = CommonMethods.iselementcurrentlyvisible(SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Force Complete')]"))) ;
				
				if (isFCcurrentlyEnabled == true && isFCcurrentlyDsiplayed == true) {
					
					SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Force Complete')]")).click();
					trueFCComments_txtarea.sendKeys("Testing true force complete on "+microservice+"");
					CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\True Force Complete - popup confirmation" + "_" + SeleniumDriver.timestamp() + ".png");
					trueFCYes_btn.click();		
					
					
					CommonMethods.WaitforElement(toasterMessage_lbl);
					System.out.println("message = " + toasterMessage_lbl.getText());
					
					CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\True Force Complete - success" + "_" + SeleniumDriver.timestamp() + ".png");
					Thread.sleep(7000);
						int count=2;
					
						for(count =2 ;count < numberofServiceinTable; count++) {
						
							Ms_name = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + count + "]/div[1]/div[1]//h1")).getText().trim();
								if(Ms_name.equals(microservice)) {
									j=count;
									break;
						}
						
					}
					
					String servicestatus = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[3]")).getText() ;
					
					String statusdetails = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[4]")).getText() ;
					
					String statuscode = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[5]")).getText() ;
					
					String cmpdate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[8]")).getText() ;
					
					System.out.println("Service status = "+ servicestatus + " ,   Status details = "+ statusdetails + "  ,  Status code = " + statuscode + "  ,   Completion date = "+ cmpdate );
					Log.info("Service status = "+ servicestatus + " ,   Status details = "+ statusdetails + "  ,  Status code = " + statuscode + "  ,   Completion date = "+ cmpdate );

					
					
				}else {
					
					Assert.fail("Something went wrong here.. please check !!!");
				}
				
				break ;
			}
		
		}
			
	}
	
	
	
	public void performVerifyCompleteAction(String microservice) throws InterruptedException {
		
	System.out.println("Sanjay------------------------------------------------------------------------------------");
		int j =0 ;
		for (int i = 1; i <= numberofServiceinTable; i++) {
			 j = i + 1;
			
			 String Ms_name = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1")).getText().trim();

			if(Ms_name.equals(microservice)) {
				
			 	SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1")).click();
			
			
				boolean isVCcurrentlyEnabled = CommonMethods.iselementcurrentlyenable(SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Verify Complete')]"))) ;
				boolean isVCcurrentlyDsiplayed = CommonMethods.iselementcurrentlyvisible(SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Verify Complete')]"))) ;
				
				if (isVCcurrentlyEnabled == true && isVCcurrentlyDsiplayed == true) {
					
					SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Verify Complete')]")).click();
					
					verifyFCComments_txtarea.sendKeys("Testing Edit & Retry on "+microservice+"");
					
					CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\Edit & Retry Complete - popup confirmation" + "_" + SeleniumDriver.timestamp() + ".png");
					
					verifyFCYes_btn.click();		
					
					CommonMethods.WaitforElement(toasterMessage_lbl);
					
					System.out.println("message = " + toasterMessage_lbl.getText());
					
					CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\Edit & Retry on "+microservice + "received  - success" + "_" + SeleniumDriver.timestamp() + ".png");
					
					Thread.sleep(7000);
					int count=2;
					
					for(count =2 ;count < numberofServiceinTable; count++) {
						
						Ms_name = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + count + "]/div[1]/div[1]//h1")).getText().trim();
						if(Ms_name.equals(microservice)) {
							j=count;
							break;
						}
						
					}
					
					String servicestatus = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[3]")).getText() ;
					
					String statusdetails = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[4]")).getText() ;
					
					String statuscode = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[5]")).getText() ;
					
					String cmpdate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[8]")).getText() ;
					
					System.out.println("Service status = "+ servicestatus + " ,   Status details = "+ statusdetails + "  ,  Status code = " + statuscode + "  ,   Completion date = "+ cmpdate );
					Log.info("Service status = "+ servicestatus + " ,   Status details = "+ statusdetails + "  ,  Status code = " + statuscode + "  ,   Completion date = "+ cmpdate );

						if("200".equals(statuscode)) {
							
							Log.info(""+microservice +"Verify complete action completed successfully from Status Manager.");
							
						}else {
							
							Log.error(""+statuscode +" is returned when Verify Complete Action is performed on "+ microservice +"");
						}
					
				}else {
					
					Assert.fail("Verify complete button is displayed = "+isVCcurrentlyDsiplayed +"    Verify complete button is displayed =  "+isVCcurrentlyEnabled);
					
				}
				
				break;
			}
			
	
		}
		
		
		
	}
	
	
	
	
	@Test(description="This method will perform Retry action on AINProvisioningService Microservice")
	public void performRetryActiononAINProvisioningService(String microservice) throws InterruptedException{
		
	//	WebElement servicepath = null ;
		int j =0 ;
		for (int i = 1; i <= numberofServiceinTable; i++) {
			 j = i + 1;
			
			 String Ms_name = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1")).getText().trim();

			if(Ms_name.equals(microservice)) {
				
			 	SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1")).click();
			
			
				boolean isFCcurrentlyEnabled = CommonMethods.iselementcurrentlyenable(SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Edit & Retry')]"))) ;
				boolean isFCcurrentlyDsiplayed = CommonMethods.iselementcurrentlyvisible(SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Edit & Retry')]"))) ;
				
				if (isFCcurrentlyEnabled == true && isFCcurrentlyDsiplayed == true) {
					
					SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Edit & Retry')]")).click();
					
					SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Retry Service')]")).click();
					
					RetryComments_txtarea.sendKeys("Testing Edit & Retry on "+microservice+"");
					
					CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\Edit & Retry Complete - popup confirmation" + "_" + SeleniumDriver.timestamp() + ".png");
					
					retryYes_btn.click();		
					
					CommonMethods.WaitforElement(toasterMessage_lbl);
					
					System.out.println("message = " + toasterMessage_lbl.getText());
					
					CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\Edit & Retry on "+microservice + "received  - success" + "_" + SeleniumDriver.timestamp() + ".png");
					
					Thread.sleep(7000);
					int count=2;
					
					while(count < numberofServiceinTable) {
						
						Ms_name = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + count + "]/div[1]/div[1]//h1")).getText().trim();
						if(Ms_name.equals(microservice)) {
							j=count;
							break;
						}
						
					}
					
					String servicestatus = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[3]")).getText() ;
					
					String statusdetails = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[4]")).getText() ;
					
					String statuscode = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[5]")).getText() ;
					
					String cmpdate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[8]")).getText() ;
					
					System.out.println("Service status = "+ servicestatus + " ,   Status details = "+ statusdetails + "  ,  Status code = " + statuscode + "  ,   Completion date = "+ cmpdate );
					Log.info("Service status = "+ servicestatus + " ,   Status details = "+ statusdetails + "  ,  Status code = " + statuscode + "  ,   Completion date = "+ cmpdate );

						if("202".equals(statuscode)) {
							
							Log.info(""+microservice +"retried successfully from Status Manager.");
							
						}else {
							
							Log.error(""+statuscode +" is returned when "+microservice +" is retried");
						}
					
				}else {
					
					Assert.fail("Something went wrong while Retrying the service.. please check !!!");
				}
			}
			break ;
	
		}
		
	}
	
	

	public void performEditandRetryActiononPortingService(String microservice) throws InterruptedException {
		
	//	WebElement servicepath = null ;
		String newduedate = RequestDetailsPage.datatoupdate ;
		 RetryCommentsByUsers = "Testing Edit & Retry on "+microservice+" by updating the desired due to "+newduedate+"" ;
		int j =0 ;
		for (int i = 1; i <= numberofServiceinTable; i++) {
			 j = i + 1;
			
			 String Ms_name = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1")).getText().trim();

			if(Ms_name.equals(microservice)) {
				
			 	SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1")).click();
			
			
				boolean isFCcurrentlyEnabled = CommonMethods.iselementcurrentlyenable(SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Edit & Retry')]"))) ;
				boolean isFCcurrentlyDsiplayed = CommonMethods.iselementcurrentlyvisible(SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Edit & Retry')]"))) ;
				
				if (isFCcurrentlyEnabled == true && isFCcurrentlyDsiplayed == true) {
					
					SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Edit & Retry')]")).click();
					
					SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]//input[@name='desiredDueDate']")).click();

					String oldduedate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]//input[@name='desiredDueDate']")).getText() ;
					
					Log.info("Existing desired due date value = "+ oldduedate);
					
					SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]//input[@name='desiredDueDate']")).clear();
					
					SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]//input[@name='desiredDueDate']")).sendKeys(newduedate);
					
					Log.info("New desired due date value = "+ newduedate);
					
					
					SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Retry Service')]")).click();
					
					RetryComments_txtarea.sendKeys(RetryCommentsByUsers);
					
					CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\Edit & Retry Complete - popup confirmation" + "_" + SeleniumDriver.timestamp() + ".png");
					
					retryYes_btn.click();		
					
					CommonMethods.WaitforElement(toasterMessage_lbl);
					
					String toastermessage =  toasterMessage_lbl.getText() ;
					
					System.out.println("toastermessage = "+toastermessage);
					Log.info("toastermessage = "+toastermessage);
					
				//	Thread.sleep(7000);
					
					if(toastermessage.contains("Bad Request")) {
						
						CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\Edit & Retry on "+microservice + "received - Bad Request" + "_" + SeleniumDriver.timestamp() + ".png");
					}else {
						
						CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\Edit & Retry on "+microservice +"received - success" + "_" + SeleniumDriver.timestamp() + ".png");
					}
					
					Thread.sleep(7000);
				//	CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\Edit & Retry Complete - success" + "_" + SeleniumDriver.timestamp() + ".png");
					
					int count=2;
					
					for(count =2 ;count < numberofServiceinTable; count++) {
						
						Ms_name = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + count + "]/div[1]/div[1]//h1")).getText().trim();
						if(Ms_name.equals(microservice)) {
							j=count;
							break;
						}
						
					}
					
					String servicename = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[1]")).getText() ;
					
					String serviceaction = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[2]")).getText() ;
					
					String servicestatus = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[3]")).getText() ;
					
					String statusdetails = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[4]")).getText() ;
					
					String statuscode = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[5]")).getText() ;
					
					String cmpdate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[8]")).getText() ;
					
					System.out.println("Service name = "+servicename +" , Service Action = "+serviceaction +" , Service status = "+ servicestatus + " ,   Status details = "+ statusdetails + "  ,  Status code = " + statuscode + "  ,   Completion date = "+ cmpdate );
					Log.info("Service name = "+servicename +" , Service Action = "+serviceaction +" , Service status = "+ servicestatus + " ,   Status details = "+ statusdetails + "  ,  Status code = " + statuscode + "  ,   Completion date = "+ cmpdate );

						if("202".equals(statuscode) || "***".equals(statuscode) ) {
							
							Log.info(""+microservice +"retried successfully from Status Manager.");
							
								if(statusdetails.contains("Service Restarted")) {
									
									Log.info("Status details of "+microservice +" is updated to "+statusdetails+"");
								
								}else {
									Log.debug("Service Restarted message is not updated in the Status Details section");
								}
							
						}else {
							
							Log.error(""+statuscode +" is returned when "+microservice +" is retried");
						}
						
						if (statusdetails.contains("Service Restarted")) {
							
							Log.info("Status details contains message - "+ statusdetails);
						}
					
				}else {
					
					Assert.fail("Something went wrong while Retrying the service.. please check !!!");
				}
			}
		
		//	break ;
	
		}	
			
		
	}
	
	
	
	
	public void performEditandRetryActiononE911Service(String microservice) throws InterruptedException {
		
		
		
		String newstreetname = RequestDetailsPage.datatoupdate ;
		 RetryCommentsByUsers = "Testing Edit & Retry on "+microservice+" by updating the StreetName to "+newstreetname+"" ;
		 
		int j =0 ;
		for (int i = 1; i <= numberofServiceinTable; i++) {
			 j = i + 1;
			
			 String Ms_name = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1")).getText().trim();

			if(Ms_name.equals(microservice)) {
				
			 	SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1")).click();
			
			
				boolean isFCcurrentlyEnabled = CommonMethods.iselementcurrentlyenable(SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Edit & Retry')]"))) ;
				boolean isFCcurrentlyDsiplayed = CommonMethods.iselementcurrentlyvisible(SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Edit & Retry')]"))) ;
				
				if (isFCcurrentlyEnabled == true && isFCcurrentlyDsiplayed == true) {
					
					SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Edit & Retry')]")).click();
					
					SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]//input[@name='desiredDueDate']")).click();
					
					String oldstreetname = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]//input[@name='streetName']")).getText() ;
					
					Log.info("Existing street name value = "+ oldstreetname);
					
					SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]//input[@name='streetName']")).clear();
					
					SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]//input[@name='streetName']")).sendKeys(newstreetname);
					
					Log.info("New street name value = "+ newstreetname);
					
					
					SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Retry Service')]")).click();
					
					RetryComments_txtarea.sendKeys(RetryCommentsByUsers);
					
					CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\Edit & Retry Complete - popup confirmation" + "_" + SeleniumDriver.timestamp() + ".png");
					
					retryYes_btn.click();		
					
					CommonMethods.WaitforElement(toasterMessage_lbl);
					
					String toastermessage =  toasterMessage_lbl.getText() ;
					
					System.out.println("toastermessage = "+toastermessage);
					Log.info("toastermessage = "+toastermessage);
					
				//	Thread.sleep(7000);
					
					if(toastermessage.contains("Bad Request")) {
						
						CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\Edit & Retry on "+microservice + "received - Bad Request" + "_" + SeleniumDriver.timestamp() + ".png");
					}else {
						
						CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\Edit & Retry on "+microservice +"received - success" + "_" + SeleniumDriver.timestamp() + ".png");
					}
					
					Thread.sleep(7000);
				//	CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\Edit & Retry Complete - success" + "_" + SeleniumDriver.timestamp() + ".png");
					
					int count=2;
					
					for(count =2 ;count < numberofServiceinTable; count++) {
						
						Ms_name = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + count + "]/div[1]/div[1]//h1")).getText().trim();
						if(Ms_name.equals(microservice)) {
							j=count;
							break;
						}
						
					}
					
					String servicestatus = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[3]")).getText() ;
					
					String statusdetails = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[4]")).getText() ;
					
					String statuscode = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[5]")).getText() ;
					
					String cmpdate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[8]")).getText() ;
					
					System.out.println("Service status = "+ servicestatus + " ,   Status details = "+ statusdetails + "  ,  Status code = " + statuscode + "  ,   Completion date = "+ cmpdate );
					Log.info("Service status = "+ servicestatus + " ,   Status details = "+ statusdetails + "  ,  Status code = " + statuscode + "  ,   Completion date = "+ cmpdate );

						if("202".equals(statuscode)) {
							
							Log.info(""+microservice +"retried successfully from Status Manager.");
							
						}else {
							
							Log.error(""+statuscode +" is returned when "+microservice +" is retried");
						}
					
				}else {
					
					Assert.fail("Something went wrong while Retrying the service.. please check !!!");
				}
			}
		
		//	break ;
	
		}
		
	}
	
	public void performEditandRetryAction(String microservice) throws InterruptedException {
		
		WebElement servicepath = null ;


		int j =0 ;
		for (int i = 1; i <= numberofServiceinTable; i++) {
			 j = i + 1;
			String Ms_name = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1")).getText().trim();

			if(Ms_name.equals(microservice)) {
				
			 servicepath =	SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[1]/div[1]//h1"));
			servicepath.click();
			
			
			}
			
			boolean isFCcurrentlyEnabled = CommonMethods.iselementcurrentlyenable(SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Edit & Retry')]"))) ;
			boolean isFCcurrentlyDsiplayed = CommonMethods.iselementcurrentlyvisible(SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Edit & Retry')]"))) ;
			
			if (isFCcurrentlyEnabled == true && isFCcurrentlyDsiplayed == true) {
				
				SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li[" + j + "]/div[2]//button[contains(text(),'Edit & Retry')]")).click();
				
				trueFCComments_txtarea.sendKeys("Testing Edit & Retry on "+microservice+"");
				CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\Edit & Retry - popup confirmation" + "_" + SeleniumDriver.timestamp() + ".png");
				trueFCYes_btn.click();
				
			}else {
				
				Assert.fail("Something went wrong here.. please check !!!");
			}
			
			CommonMethods.WaitforElement(toasterMessage_lbl);
			System.out.println("message = " + toasterMessage_lbl.getText());
			Thread.sleep(7000);
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH	+ "\\Edit & Retry Complete - success" + "_" + SeleniumDriver.timestamp() + ".png");
			
			//servicepath.click();
			
			String servicestatus = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[3]")).getText() ;
			
			String statusdetails = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[4]")).getText() ;
			
			String statuscode = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[5]")).getText() ;
			
			String cmpdate = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]/li["+j+"]/div[1]/div[8]")).getText() ;
			
			System.out.println("Service status = "+ servicestatus + " ,   Status details = "+ statusdetails + "  ,  Status code = " + statuscode + "  ,   Completion date = "+ cmpdate );
			Log.info("Service status = "+ servicestatus + " ,   Status details = "+ statusdetails + "  ,  Status code = " + statuscode + "  ,   Completion date = "+ cmpdate );

			
		}
	
	}

	
	
	
	public void verifyServiceSummarysection() {
		
		if(checkMSexists()==true) {
			
			verifyServiceSummaryChartandLabel();
			getSersumData() ;
		
		}else {
			String errormessage = "Service Summary section is not displayed in request Page.";
			SoftAssert sf= new SoftAssert();
			sf.fail(errormessage);
			Log.error(errormessage);
		}
		
	}
	
	public String verifyServiceSummaryChartandLabel() {
		
	//	serviceSummary_lbl.isDisplayed() ;
		String message = null ;
		
		if(serviceSummary_lbl.isDisplayed() && serviceSummarychart_img.isDisplayed()) {
			
			message = "Service Summary chart and label are displayed" ;
			return message ;
			
		}else {
			
			if(serviceSummary_lbl.isDisplayed()) {
				
				message = "Only Service Summary label is displayed" ;
				SoftAssert sf= new SoftAssert();
				sf.fail(message);
				
				return message ;
				
			}else if(serviceSummarychart_img.isDisplayed()) {
				
				message = "Only Service Summary chart is displayed" ;
				SoftAssert sf= new SoftAssert();
				sf.fail(message);
				return message ;
				
			}
			//return message ;
		}
		return message;
		
	}
	
	
	/**
	 * @return the service summary data
	 */
	public Map<String, String> getSersumData() {
		
		Map<String,String> data = new HashMap<String,String> ();
		
		int count = SeleniumDriver.getDriver().findElements(By.xpath(".//*[@ng-if='microserviceSumStatusData']/div/div[3]/div")).size();
		
		for (int i=1; i<=count;i++) {
			String msStatus = SeleniumDriver.getDriver().findElement(By.xpath(".//*[@ng-if='microserviceSumStatusData']/div/div[3]/div["+i+"]//span")).getText() ;
			String msStatuscount = SeleniumDriver.getDriver().findElement(By.xpath(".//*[@ng-if='microserviceSumStatusData']/div/div[3]/div["+i+"]/h4")).getText() ;
			msStatuscount = msStatuscount.trim().substring(msStatuscount.length() - 1) ;
			data.put(msStatus, msStatuscount);
		}
		
		System.out.println(data);
		Log.info("Service Summary data{}", data);
		
		return data ;
		
	}
	
	/**
	 * @return true if MS table exists in the request details page
	 */
	public boolean checkMSexists() {
		
		boolean numberofServiceinTable1 = SeleniumDriver.getDriver().findElement(By.xpath(".//*[contains(@id,'microServiceList')]")).isDisplayed();
		if (numberofServiceinTable1==true) {
			
			return true ;
			
		}else {
			
			return false ;
		}
	}
	
	
	
	
	
}
