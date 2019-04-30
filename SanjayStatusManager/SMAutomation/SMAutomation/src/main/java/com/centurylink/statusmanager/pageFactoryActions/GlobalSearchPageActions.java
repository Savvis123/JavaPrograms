package com.centurylink.statusmanager.pageFactoryActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import com.centurylink.statusmanager.utilities.CommonMethods;
import com.centurylink.statusmanager.utilities.SeleniumDriver;
import com.centurylink.statusmanager.utilities.URLConfigs;

public class GlobalSearchPageActions {

	WebDriver driver;

	private final static org.slf4j.Logger Log = LoggerFactory.getLogger(GlobalSearchPageActions.class);
	
	public GlobalSearchPageActions(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(SeleniumDriver.getDriver(), this);

	}
	
	// ********************** Page xpath's begins from here *********************

	@FindBy(xpath = "//input[@id='inputText']")
	public WebElement Globalsearch_tbx;

	@FindBy(id = "search-btn")
	public WebElement Search_btn;

	@FindBy(id = "statusDetails")
	public WebElement relatedrequeststab_lbl;

	@FindBy(xpath = ".//*[@id='customerDetails']//strong[contains(text(),'Public UserID')]/../following-sibling::div")
	public WebElement PublicUserID_lbl;

	@FindBy(xpath = "//*[@id='statusDetails']//strong[contains(text(),'Correlation ID')]/../following-sibling::div")
	public WebElement CorrelationID_lbl;

	@FindBy(xpath = ".//*[@ ng-show='isOpen()']")
	public WebElement suggestionList;

	@FindBy(xpath = "//span[@ng-bind='tab.title' and contains(text(),'Request Details')]")
	public WebElement RequestDetailstab_lbl;

	@FindBy(xpath = ".//*[@id='customerDetails']//span")
	public WebElement CustomerName_lbl;

	@FindAll({ @FindBy(xpath = ".//div[@class='input-group']/ul/li") })
	public List<WebElement> solrseggestionlist;
	
	
//  **********************  Page method begins from here  *********************
	

	public void selectparamType(String ptype, String inputData) throws InterruptedException {

		if ("CorrelationID".equals(ptype)) {

			perform_Global_search_with_partial_CorrelarionID(inputData);

		} else if ("PublicUserID".equals(ptype)) {

			perform_Global_search_with_partial_PublicUserID(inputData);

		} else if ("MicroServiceID".equals(ptype)) {

			perform_Global_search_with_partial_MicroServiceID(inputData);

		} else if ("CustomerName".equals(ptype)) {

			perform_Global_search_with_partial_CustomerName(inputData);

		}

	}

	public void perform_Global_search_with_partial_CorrelarionID(String inputData) throws InterruptedException {

		CommonMethods.WaitforElement(Globalsearch_tbx);
		Globalsearch_tbx.clear();
		Globalsearch_tbx.sendKeys(inputData);
		Thread.sleep(3000);

		boolean isSuggestionDisplayed = CommonMethods.iselementcurrentlyvisible(suggestionList);

		System.out.println("isSuggestionDisplayed =" + isSuggestionDisplayed);

		if (isSuggestionDisplayed == true) {

			int count = solrseggestionlist.size();

			System.out.println("Number of suggestions listed = " + count);
			// Log.info("Number of suggestions listed = " + count);

			if (count == 0) {
				 Log.error("Please check the data provided");
				 Log.debug("Input given for Global search = " + inputData);
				SoftAssert sf = new SoftAssert();
				sf.fail("Please check the data used !!!!!!");

			} else {

				String data = SeleniumDriver.getDriver()
						.findElement(
								By.xpath(".//div[@class='input-group']/ul/li[a[starts-with(text(),'CORRELATIONID')]]"))
						.getText();

				 Log.info("List contains the data required for validating Global search scenario = " + data);

				for (int i = 1; i <= count; i++) {

					if (SeleniumDriver.getDriver()
							.findElement(By.xpath(".//div[@class='input-group']/ul/li[" + i + "]/a")).getText()
							.startsWith("CORRELATIONID")) {

						SeleniumDriver.getDriver()
								.findElement(By.xpath(
										".//ul[@ng-show='isOpen()']/li[" + i + "]/a[contains(text(),'CORRELATIONID')]"))
								.click();
						Search_btn.click();
						break;
					}

				}
				
			CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH +"\\validate global search on UI with partial CORRELATION ID" +"_"+SeleniumDriver.timestamp()+".png");

			}
		}else {
			
			  System.err.println("Global search has not returned any suggestion..");
			 Log.error("Global search has not returned any suggestion..");
		} 
	}

	public void perform_Global_search_with_partial_PublicUserID(String inputData) throws InterruptedException {

		CommonMethods.WaitforElement(Globalsearch_tbx);
		Globalsearch_tbx.clear();
		Globalsearch_tbx.sendKeys(inputData);
		Thread.sleep(3000);

		boolean isSuggestionDisplayed = CommonMethods.iselementcurrentlyvisible(suggestionList);

		System.out.println("isSuggestionDisplayed = " + isSuggestionDisplayed);

		if (isSuggestionDisplayed == true) {

			int count = solrseggestionlist.size();

			System.out.println("Number of suggestions listed = " + count);
			// Log.info("Number of suggestions listed = " + count);

			if (count == 0) {
				System.out.println("Please check the data provided");
				 Log.error("Please check the data provided");
				 Log.debug("Input given for Global search = " + inputData);
				SoftAssert sf = new SoftAssert();
				sf.fail("Please check the data used !!!!!!");

			} else {
				System.out.println("driver info = " + SeleniumDriver.getDriver());
				String data = SeleniumDriver.getDriver()
						.findElement(
								By.xpath(".//div[@class='input-group']/ul/li[a[starts-with(text(),'PUBLICUSERID')]]"))
						.getText();

				 Log.info("List contains the data required for validating Global search scenario = " + data);

				for (int i = 1; i <= count; i++) {

					if (SeleniumDriver.getDriver()
							.findElement(By.xpath(".//div[@class='input-group']/ul/li[" + i + "]/a")).getText()
							.startsWith("PUBLICUSERID")) {

						SeleniumDriver.getDriver()
								.findElement(By.xpath(
										".//ul[@ng-show='isOpen()']/li[" + i + "]/a[contains(text(),'PUBLICUSERID')]"))
								.click();
						Search_btn.click();
						break;
					}

				}
				CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH +"\\validate global search on UI with partial PublicUser ID" +"_"+SeleniumDriver.timestamp()+".png");

			}
		}else {
			
			  System.err.println("Global search has not returned any suggestion..");
			 Log.error("Global search has not returned any suggestion..");
		} 

	}

		
	

	public void perform_Global_search_with_partial_CustomerName(String inputData) throws InterruptedException {

		CommonMethods.WaitforElement(Globalsearch_tbx);
		Globalsearch_tbx.clear();
		Globalsearch_tbx.sendKeys(inputData);
		Thread.sleep(3000);

		boolean isSuggestionDisplayed = CommonMethods.iselementcurrentlyvisible(suggestionList);

		System.out.println("isSuggestionDisplayed =" + isSuggestionDisplayed);

		if (isSuggestionDisplayed == true) {

			int count = solrseggestionlist.size();

			System.out.println("Number of suggestions listed = " + count);
			 Log.info("Number of suggestions listed = " + count);

			if (count == 0) {
				 Log.error("Please check the data provided");
				 Log.debug("Input given for Global search = " + inputData);
			} else {

				String data = SeleniumDriver.getDriver()
						.findElement(
								By.xpath(".//div[@class='input-group']/ul/li[a[starts-with(text(),'CUSTOMERNM')]]"))
						.getText();

				 Log.info("List contains the data required for validating Global search scenario = " + data);

				for (int i = 1; i <= count; i++) {

					if (SeleniumDriver.getDriver()
							.findElement(By.xpath(".//div[@class='input-group']/ul/li[" + i + "]/a")).getText()
							.startsWith("CUSTOMERNM")) {

						SeleniumDriver.getDriver()
								.findElement(By.xpath(
										".//ul[@ng-show='isOpen()']/li[" + i + "]/a[contains(text(),'CUSTOMERNM')]"))
								.click();
						Search_btn.click();
						break;
					}

				}
				
				CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH +"\\validate global search on UI with partial CUSTOMER NAME" +"_"+SeleniumDriver.timestamp()+".png");
			
			}
			
		}else {
			
			  System.err.println("Global search has not returned any suggestion..");
			 Log.error("Global search has not returned any suggestion..");
		} 

	}



	public void perform_Global_search_with_partial_MicroServiceID(String inputData) throws InterruptedException {

		CommonMethods.WaitforElement(Globalsearch_tbx);
		Globalsearch_tbx.clear();
		Globalsearch_tbx.sendKeys(inputData);
		Thread.sleep(3000);

		boolean isSuggestionDisplayed = CommonMethods.iselementcurrentlyvisible(suggestionList);

		System.out.println("isSuggestionDisplayed =" + isSuggestionDisplayed);

		if (isSuggestionDisplayed == true) {

			int count = solrseggestionlist.size();

			System.out.println("Number of suggestions listed = " + count);
			// Log.info("Number of suggestions listed = " + count);

			if (count == 0) {
				// Log.error("Please check the data provided");
				// Log.debug("Input given for Global search = " + inputData);
				SoftAssert sf = new SoftAssert();
				sf.fail("Please check the data used !!!!!!");

			} else {

				String data = SeleniumDriver.getDriver()
						.findElement(
								By.xpath(".//div[@class='input-group']/ul/li[a[starts-with(text(),'MICROSERVICEID')]]"))
						.getText();

				// Log.info("List contains the data required for validating Global search
				// scenario = " + data);

				for (int i = 1; i <= count; i++) {

					if (SeleniumDriver.getDriver()
							.findElement(By.xpath(".//div[@class='input-group']/ul/li[" + i + "]/a")).getText()
							.startsWith("MICROSERVICEID")) {

						SeleniumDriver.getDriver().findElement(By
								.xpath(".//ul[@ng-show='isOpen()']/li[" + i + "]/a[contains(text(),'MICROSERVICEID')]"))
								.click();
						Search_btn.click();
						break;
					}

				}

				CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH +"\\validate global search on UI with partial MICROSERVICE ID" +"_"+SeleniumDriver.timestamp()+".png");
				
	}
		}else {
			
			  System.err.println("Global search has not returned any suggestion..");
			// Log.error("Global search has not returned any suggestion..");
		} 
	}
	

	public void validateRequestPage() throws InterruptedException {

		Thread.sleep(5000);

		String Request_tab_title = RequestDetailstab_lbl.getText().trim();

		System.out.println("tab title text = " + Request_tab_title);

		String split_tab_title_data[] = Request_tab_title.split(":");

		String get_custname_from_tab_title = split_tab_title_data[1].trim();

		String custName_from_request_page = CustomerName_lbl.getText().trim();

		String publicuserID_from_request_page = PublicUserID_lbl.getText();

		String correlationID_from_request_page = CorrelationID_lbl.getText();

		if (get_custname_from_tab_title.equals(custName_from_request_page)) {

			System.out.println("Tab title contains Customer Name");
			// Log.info("Tab title contains Customer Name");

		} else if (get_custname_from_tab_title.equals(publicuserID_from_request_page)) {

			System.out.println("Tab title contains PublicUserID");
			// Log.info("Tab title contains PublicUserID");

		} else if (get_custname_from_tab_title.equals(correlationID_from_request_page)) {

			System.out.println("Tab title contains CorrelationID");
			// Log.info("Tab title contains CorrelationID");

		} else {

			System.err.println("Tab title does not contains Customer Name/PublicUserID/CorrelationID ");
			// Log.warn("Tab title does not contains Customer
			// Name/PublicUserID/CorrelationID ");
		}

		/*CommonMethods.captureScreenshot(
				URLConfigs.SCREENSHOT_PATH + "\\validate global search on UI with partial CORRELATION ID" + "_"
						+ SeleniumDriver.timestamp() + ".png");*/
	}

}
