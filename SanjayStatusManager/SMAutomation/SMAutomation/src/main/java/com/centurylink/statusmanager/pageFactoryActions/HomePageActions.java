package com.centurylink.statusmanager.pageFactoryActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.centurylink.statusmanager.utilities.CommonMethods;
import com.centurylink.statusmanager.utilities.SeleniumDriver;

public class HomePageActions {

	WebDriver driver;
	private final static org.slf4j.Logger Log = LoggerFactory.getLogger(HomePageActions.class);

	public HomePageActions(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}

	// ********************** Page xpath's begins from here *********************

	@FindBy(partialLinkText = "Status Manager")
	public WebElement StatusManager_lbl;

	@FindBy(xpath = ".//a[@role='button']")
	public WebElement role_btn;
	
	@FindBy(xpath=".//*[contains(@id,'navbar')]")
	public WebElement Navbar_lnk;
	
	@FindBy(xpath = ".//a[contains(text(),'Profile')]")
	public WebElement Profile_lnk;
	
	@FindBy(xpath=".//a[contains(text(),'App Version')]")
	public WebElement AppVersion_lbl;

	// ************** Test Rest & Sub modules xpath's *****************

	@FindBy(xpath = "(//span[contains(text(),'Test REST')])[position()=last()]")
	public WebElement TestRest_lnk;

	@FindBy(xpath = "//ng-include[@id='sidemenu']/div[2]//li[@id='menu-history']")
	public WebElement QueryHistory_lnk;

	@FindBy(xpath = "//li/button[contains(text(),'View More')]")
	public WebElement QueryHistoryViewMore_lnk;
	
	@FindBy(xpath = "(//span[contains(text(),'Status Submit Service')])[position()=last()]")
	public WebElement statusSubmitService_lnk;

	@FindBy(xpath = "(//span[contains(text(),'Log Notes Service')])[position()=last()]")
	public WebElement LogNotesService_lnk;

	@FindBy(xpath = "(//span[contains(text(),'Notify Service')])[position()=last()]")
	public WebElement NotifyService_lnk;

	@FindBy(xpath = "(//span[contains(text(),'RMA Service')])[position()=last()]")
	public WebElement RMAService_lnk;
	
	@FindBy(xpath = "(//span[contains(text(),'Publish Service')])[position()=last()]")
	public WebElement PublishService_lnk;

	@FindBy(xpath = "(//span[contains(text(),'Get Request Details (Correlation ID)')])[position()=last()]")
	public WebElement GetRequestByCorrelationID_lnk;

	@FindBy(xpath = "(//span[contains(text(),'Get Request Details (Public User ID')])[position()=last()]")
	public WebElement GetRequestByPublicUserID_lnk;

	@FindBy(xpath = "//ng-include[@id='sidemenu']/div[2]//button[@type='submit']")
	private WebElement searchButton;

	@FindBy(xpath = ".//*[@class='btn btn-info btn-lg']")
	public WebElement ViewEditIcon_img;
	
	@FindBy(how = How.XPATH, using = ".//div[@ng-controller='searchResultCtrl']//div[@ng-show='showNoDataMess']/div")
	public WebElement SearchResultsError_lbl;

	// ************** Search using Request related info - page xpath's
	// *****************

	@FindBy(xpath = "//div[@class='sidebar-menu sidebar-menu-lg visible-lg ng-scope']//span[contains(text(),'Search')]")
	public WebElement SearchSliderIcon_lnk;

	@FindBy(xpath = "//ng-include[@id='sidemenu']/div[2]//select[@id='searchType']")
	public WebElement dropdownparentelement_search;

	@FindBy(xpath = "(//div[label[contains(text(),'Customer Name')]]/input)[position()=last()]")
	public WebElement SearchSlider_CustomerName_tbx;
	
	@FindBy(how = How.XPATH, using="(//div[label[contains(text(),'Public User Id')]]/input)[position()=last()]")
	public WebElement SearchSlider_PublicUserID_tbx ;
	
	@FindBy(xpath = "//ul[@id='menu-comunicacao-sub-lg']//select[@placeholder='Select Workgroup']")
	public WebElement dropdownparentelement_workgroups;
	
	@FindBy(how = How.XPATH, using ="//ul[@id='menu-comunicacao-sub-lg']//select[@placeholder='Select Status']")
	public WebElement dropdownparentelement_Status;
	
	@FindBy(xpath = "//ul[@id='menu-comunicacao-sub-lg']//input[@placeholder='Assigned To']")
	public WebElement SearchSlider_AssignedTo_tbx;


	@FindBy(xpath = "(//div[label[contains(text(),'Correlation Id')]]/input)[position()=last()]")
	public WebElement SearchSlider_CorrelationID_tbx;
	
	@FindBy(how = How.XPATH, using = "//ul[@id='menu-comunicacao-sub-lg']//select[@placeholder='Select Offering Type']")
	public WebElement dropdownparentelement_OfferingType;
	
	@FindBy(how = How.XPATH, using = "//ul[@id='menu-comunicacao-sub-lg']//select[@placeholder='Select Action']")
	public WebElement dropdownparentelement_Action;
	
	@FindBy(how = How.XPATH, using = "//ul[@id='menu-comunicacao-sub-lg']//select[@placeholder='Select Territory Code']")
	public WebElement dropdownparentelement_TerritoryCode;

	@FindBy(xpath = ".//*[@id='menu-comunicacao-sub-lg']//button[contains(text(),'Search')]")
	public WebElement SearchSlider__Search_btn;

	// ************** Search using MS related info - page xpath's *****************
	
	@FindBy(xpath = "//select[@placeholder='Select Micro Service Name']")
	public WebElement dropdownparentelement_services;
	
	@FindBy(how = How.XPATH, using = ".//input[@ng-model='searchParams.microServiceID']")
	public WebElement SearchSlider_MicroServiceID_tbx;
	
	@FindBy(how = How.XPATH, using = ".//*[@ng-model='searchParams.microServiceName']")
	public WebElement dropdownparentelement_MicroServiceName;
	
	@FindBy(how = How.XPATH, using = ".//*[@ng-model='searchParams.microServiceStatus']")
	public WebElement dropdownparentelement_MicroServiceStatus;
	
	@FindBy(how = How.XPATH, using = ".//*[@ng-model='searchParams.microServiceStatusCode']")
	public WebElement dropdownparentelement_MicroServiceStatusCode;
	
	@FindBy(how = How.XPATH, using = ".//*[@ng-model='searchParams.microServiceAction']")
	public WebElement dropdownparentelement_MicroServiceAction;
	
	@FindBy(how = How.XPATH, using = ".//*[@ng-model='searchParams.microServiceStatusMessage']")
	public WebElement SearchSlider_MicroServiceStatusMessage_tbx;
	
	@FindBy(how = How.XPATH, using = ".//input[@ng-model='searchParams.microServiceCorrelationID']")
	public WebElement SearchSlider_MicroServiceCorrelationID_tbx;
	
	

	// ************** Search using FLAG related info - page xpath's
	// *****************

	@FindBy(xpath = ".//*[@placeholder='Select Flag Code OR Notify Code']")
	public WebElement dropdownparentelement_FlagCode;

	@FindBy(xpath = ".//*[@placeholder='Select Flag Type OR Notify Type']")
	public WebElement dropdownparentelement_FlagType;
	
	@FindBy(how=How.XPATH, using =".//input[@ng-model='searchParams.flagCorrelationID']")
	public WebElement SearchSlider_FlagCorrelationID_tbx;

	// ************** Close Search Result Page xpath *****************

	@FindBy(xpath = "//tab-heading[span[contains(text(),'Search')]]/a/img[1]")
	public WebElement closeSearchResultTab_img;

	// ************** Close Request Details Page xpath *****************

	@FindBy(xpath = "//tab-heading[span[contains(text(),'Request Details')]]/a/img[1]")
	public WebElement closeRequestTab_img;

	// ********************** Page method begins from here *********************

	public void waitforHomePageToLoad() {

		CommonMethods.WaitforElement(StatusManager_lbl);
		CommonMethods.WaitforElement(role_btn);

	}
	
	public void getAppVersionfromHomePage() {
		
		role_btn.click();
		Log.info("App Version in HomePage :" + AppVersion_lbl.getText());
		Navbar_lnk.click();
	}
	
	
	public void clickonUsernameLink() {
		
		role_btn.click();
		Log.info("Clicked on Username link");
		
	}
	
	public void clickonProfileLink() {
		
		Profile_lnk.click();
		Log.info("Clicked on Profile link");
	}

	public void selectTestRestoptions(String a1) {

		if (a1.contains("Status Submit Service")) {
			
			statusSubmitService_lnk.click();

		} else if (a1.equals("Log Notes Service")) {

			LogNotesService_lnk.click();

		} else if (a1.equals("Notify Service")) {

			// NotifyService_lnk.click();

		} else if (a1.equals("RMA Service")) {

			RMAService_lnk.click();

		} else if (a1.contains("Get Request Details(Correlation ID)")) {

			GetRequestByCorrelationID_lnk.click();

		} else if (a1.contains("Get Request Details (Public User ID)")) {

			GetRequestByPublicUserID_lnk.click();

		} else if (a1.contains("Publish Service")) {

			PublishService_lnk.click();

		}
		
	}

	public void clickonTestRestLink() {

		CommonMethods.WaitforElement(TestRest_lnk);
		TestRest_lnk.click();
	}

	public void clickonSearchLink() {

		CommonMethods.WaitforElement(SearchSliderIcon_lnk);
		SearchSliderIcon_lnk.click();
	}

	public void selectSeachtype(String type) {

		Select ss = new Select(dropdownparentelement_search);
		ss.selectByVisibleText(type);
	}
/*
	public void selectFlagCode(String flagcode) throws InterruptedException {

		Select ss1 = new Select(dropdownparentelement_FlagCode);
		Thread.sleep(1000);
		ss1.selectByVisibleText(flagcode);
	}

	public void selectFlagType(String flagtype) throws InterruptedException {

		Select ss1 = new Select(dropdownparentelement_FlagType);
		Thread.sleep(1000);
		ss1.selectByVisibleText(flagtype);
	}

	public void slectFlagSliderDropDownOptions(String Flag, String flagdropdownoptions) throws InterruptedException {

		if ("FLAG Code".contains(flagdropdownoptions)) {

			selectFlagCode(Flag);
			
		} else if ("FLAG Type".contains(flagdropdownoptions)) {

			selectFlagType(Flag);
		}
	}
	*/
	
	
	public void searchByMicroserviceName(String msname) throws InterruptedException {

		Select ss1 = new Select(dropdownparentelement_services);
		Thread.sleep(1000);
		ss1.selectByVisibleText(msname);
	}
	
	public void selectSearchByRequestoptions(String paramoptions,String paramValue) {
		
		if ("Customer Name".contains(paramoptions)) {

			SearchSlider_CustomerName_tbx.sendKeys(paramValue);
			Log.info("Entered "+ paramValue +" in the Customer Name textbox");
			Log.info("Entered Customer Name");
			
		} else if ("Public User Id".contains(paramoptions)) {

			SearchSlider_PublicUserID_tbx.sendKeys(paramValue);
			Log.info("Entered "+ paramValue +" in the Public User ID textbox");
			Log.info("Entered Public User ID");
			
		}else if ("Workgroup".contains(paramoptions)) {

			try {
				
				searchByWorkgroupName(paramValue);
				Log.info("selected Workgroup Name");
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
			
		}else if ("Status".contains(paramoptions)) {

			try {
				
				searchByRequestStatus(paramValue);
				Log.info("selected Request Status");
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
		}else if ("Assigned To".contains(paramoptions)) {

			SearchSlider_AssignedTo_tbx.sendKeys(paramValue);
			Log.info("Entered "+ paramValue +" in the Assigned To textbox");
			Log.info("Entered Assigned To");
			
		}else if ("Correlation Id".contains(paramoptions)) {

			SearchSlider_CorrelationID_tbx.sendKeys(paramValue);
			Log.info("Entered "+ paramValue +" in the Correlation ID textbox");
			Log.info("Entered Correlation Id");
			
		}else if ("Offering Type".contains(paramoptions)) {

			try {
				
				searchByOfferingType(paramValue);
				Log.info("selected Offering Type");
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
		}else if ("Action".contains(paramoptions)) {

			try {
				
				searchByAction(paramValue);
				Log.info("selected Action");
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
		}else if ("Territory Code".contains(paramoptions)) {

			try {
				
				searchByTerritoryCode(paramValue);
				Log.info("Selected Territory Code");
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
		}
	}
	
	
	public void selectSearchByMicroserviceoptions(String paramoptions,String paramValue) {
		
		if ("MicroService ID".contains(paramoptions)) {

			SearchSlider_MicroServiceID_tbx.sendKeys(paramValue);
			Log.info("Entered MicroService ID");
			
		}else if ("MicroService Name".contains(paramoptions)) {

			try {
				
				searchByMicroServiceName(paramValue);
				Log.info("selected MicroService Name");
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
		}else if ("MicroService Status".contains(paramoptions)) {

			try {
				
				searchByMicroServiceStatus(paramValue);
				Log.info("selected MicroService Status");
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
		}else if ("MicroService Status Code".contains(paramoptions)) {

			try {
				
				searchByMicroServiceStatusCode(paramValue);
				Log.info("selected MicroService Status Code");
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
		}else if ("MicroService Action".contains(paramoptions)) {

			try {
				
				searchByMicroServiceAction(paramValue);
				Log.info("selected MicroService Action");
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
		} else if ("Correlation ID".contains(paramoptions)) {

			SearchSlider_MicroServiceCorrelationID_tbx.sendKeys(paramValue);
			Log.info("Selected "+ paramValue +" in the Correlation ID textbox");
			Log.info("Entered Correlation ID");
			
		}
		
		
	}
	
	
	
	public void selectSearchByFlagoptions(String paramoptions,String paramValue) {
		
		
		if ("Flag Code".contains(paramoptions)) {

			try {
				
				searchByFlagCode(paramValue);
				Log.info("selected Flag Code");
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
		}else if ("Flag Type".contains(paramoptions)) {

			try {
				
				searchByFlagType(paramValue);
				Log.info("selected Flag Type");
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
		}else if ("Correlation ID".contains(paramoptions)) {

			SearchSlider_FlagCorrelationID_tbx.sendKeys(paramValue);
			Log.info("Selected "+ paramValue +" in the Correlation ID textbox");
			Log.info("Entered Correlation ID");
			
		}
		
	}
	
	
	public void searchByWorkgroupName(String wrkgrpname) throws InterruptedException {

		Select ss1 = new Select(dropdownparentelement_workgroups);
		Thread.sleep(1000);
		ss1.selectByVisibleText(wrkgrpname);
		Log.info("Selected "+ wrkgrpname +" from workgroup name dropdown");
		
	}
	
	public void searchByRequestStatus(String status) throws InterruptedException {

		Select ss1 = new Select(dropdownparentelement_Status);
		Thread.sleep(1000);
		ss1.selectByVisibleText(status);
		Log.info("Selected "+ status +" from status dropdown");
	}
	
	public void searchByOfferingType(String offeringtype) throws InterruptedException {

		Select ss1 = new Select(dropdownparentelement_OfferingType);
		Thread.sleep(1000);
		ss1.selectByVisibleText(offeringtype);
		Log.info("Selected "+ offeringtype +" from offering type dropdown");
	}
	
	public void searchByAction(String action) throws InterruptedException {

		Select ss1 = new Select(dropdownparentelement_Action);
		Thread.sleep(1000);
		ss1.selectByVisibleText(action);
		Log.info("Selected "+ action +" from action dropdown");
	}
	
	public void searchByTerritoryCode(String tcode) throws InterruptedException {

		Select ss1 = new Select(dropdownparentelement_TerritoryCode);
		Thread.sleep(1000);
		ss1.selectByVisibleText(tcode);
		Log.info("Selected "+ tcode +" from territory code dropdown");
	}
	
	public void searchByMicroServiceName(String msname) throws InterruptedException {

		Select ss1 = new Select(dropdownparentelement_MicroServiceName);
		Thread.sleep(1000);
		ss1.selectByVisibleText(msname);
		Log.info("Selected "+ msname +" from microservice name dropdown");
		
	}
	
	public void searchByMicroServiceStatus(String msStatus) throws InterruptedException {

		Select ss1 = new Select(dropdownparentelement_MicroServiceStatus);
		Thread.sleep(1000);
		ss1.selectByVisibleText(msStatus);
		Log.info("Selected "+ msStatus +" from microservice status dropdown");
	}
	
	public void searchByMicroServiceStatusCode(String msStatuscode) throws InterruptedException {

		Select ss1 = new Select(dropdownparentelement_MicroServiceStatusCode);
		Thread.sleep(1000);
		ss1.selectByVisibleText(msStatuscode);
		Log.info("Selected "+ msStatuscode +" from microservice status code dropdown");
	}
	
	public void searchByMicroServiceAction(String msAction) throws InterruptedException {

		Select ss1 = new Select(dropdownparentelement_MicroServiceAction);
		Thread.sleep(1000);
		ss1.selectByVisibleText(msAction);
		Log.info("Selected "+ msAction +" from Action dropdown");
	}

	
	public void searchByFlagCode(String flagcode) throws InterruptedException {

		Select ss1 = new Select(dropdownparentelement_FlagCode);
		Thread.sleep(1000);
		ss1.selectByVisibleText(flagcode);
		Log.info("Selected "+ flagcode +" from Flag code dropdown");
	}

	
	public void searchByFlagType(String flagtype) throws InterruptedException {

		Select ss1 = new Select(dropdownparentelement_FlagType);
		Thread.sleep(1000);
		ss1.selectByVisibleText(flagtype);
		Log.info("Selected "+ flagtype +" from Flag type dropdown");
	}

	
	
	
	
	public void clickonSearchbutton() {

		searchButton.click();
	}

	public void clickonViewEditIcon() throws InterruptedException {

		Thread.sleep(2000);
		if(SearchResultsError_lbl.isDisplayed()) {
			
			Assert.fail(SearchResultsError_lbl.getText());
			Log.error(SearchResultsError_lbl.getText());
			
		}else {
			
			ViewEditIcon_img.click();
			Thread.sleep(1000);
			Log.info("Clicked on view button");
		}
	}

	public void closeSearchResultsTab() {

		closeSearchResultTab_img.click();
		Log.info("Closed Search results tab");

	}

	public void closeRequestDetailsTab() {

		closeRequestTab_img.click();
		Log.info("Closed Request details tab");

	}

}
