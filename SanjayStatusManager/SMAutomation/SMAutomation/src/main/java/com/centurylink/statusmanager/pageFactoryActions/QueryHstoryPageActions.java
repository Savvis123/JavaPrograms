package com.centurylink.statusmanager.pageFactoryActions;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import com.centurylink.statusmanager.utilities.CommonMethods;
import com.centurylink.statusmanager.utilities.SeleniumDriver;
import com.centurylink.statusmanager.utilities.URLConfigs;

public class QueryHstoryPageActions {

	WebDriver driver;
	
	private final static org.slf4j.Logger Log = LoggerFactory.getLogger(QueryHstoryPageActions.class);

	HomePageActions homePageActions = new HomePageActions(driver);

	public QueryHstoryPageActions(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}

	@FindBy(xpath = ".//*[@ng-click='onClickTab(tab)']/span[contains(text(),'Query')]")
	public WebElement QueryHistoryTabTitle_lbl;

	//// (//span[@class='glyphicon glyphicon-edit'])[position()=1] === to get 1st
	//// position
	@FindBy(xpath = "(//span[@class='glyphicon glyphicon-edit'])[position()=last()]")
	public WebElement FocusButton;

	// .//*[@id='statusDetails']/ul/li[1]//h4/span

	@FindBy(xpath = ".//*[@id='statusDetails']/ul/li[1]//h4/span")
	public WebElement requestPageStatusCode_lbl;

	@FindBy(xpath = "//tab-heading[span[contains(text(),'Query History')]]/a/img[1]")
	public WebElement close_QueryHistoryTab_Button;

	public void clickonQueryHistoryLink() throws InterruptedException {

		homePageActions.QueryHistory_lnk.click();
		// Log.info("Clicked on Query History Link..");
		Thread.sleep(3000);

	}

	public void clickonViewMoreLink() {

		CommonMethods.scrollintoview(homePageActions.QueryHistoryViewMore_lnk);
		CommonMethods.scrollintoviewAndClickonWebElement(homePageActions.QueryHistoryViewMore_lnk);
		System.out.println("Clicked on View More link....");
	}

	public void query_history_all_history_search() throws InterruptedException {

		homePageActions.QueryHistory_lnk.click();
		Log.info("Clicked on Query History Link..");
		Thread.sleep(3000);

		CommonMethods.scrollintoview(homePageActions.QueryHistoryViewMore_lnk);
		CommonMethods.scrollintoviewAndClickonWebElement(homePageActions.QueryHistoryViewMore_lnk);

		System.out.println("Clicked on View More link....");
		Log.info("Clicked on View More link....");

	}

	public void validate_Query_History_tab() throws InterruptedException {

		QueryHistoryTabTitle_lbl.getText();
		String Expected_tab_title = "Query History";
		assertEquals(QueryHistoryTabTitle_lbl.getText(), Expected_tab_title);
		Thread.sleep(4000);
		FocusButton.click();
		 Log.info("Opening Request Details Page");

		CommonMethods.WaitforElement(requestPageStatusCode_lbl);

		Thread.sleep(4000);
		 Log.info("Request Details Page is visible");

		CommonMethods.captureScreenshot(
				URLConfigs.SCREENSHOT_PATH + "\\Query_History_result" + "_" + SeleniumDriver.timestamp() + ".png");

		homePageActions.closeRequestTab_img.click();
		close_QueryHistoryTab_Button.click();
		

	}

}
