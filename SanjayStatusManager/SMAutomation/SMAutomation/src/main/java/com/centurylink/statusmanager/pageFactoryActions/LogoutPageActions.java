package com.centurylink.statusmanager.pageFactoryActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import com.centurylink.statusmanager.utilities.CommonMethods;
import com.centurylink.statusmanager.utilities.SeleniumDriver;

public class LogoutPageActions {

	WebDriver driver;
	
	private final static org.slf4j.Logger Log = LoggerFactory.getLogger(LogoutPageActions.class);

	public LogoutPageActions(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(SeleniumDriver.getDriver(), this);

	}
	
	// ********************** Page xpath's begins from here *********************

	@FindBy(xpath = ".//a[@role='button']")
	public WebElement role_btn;

	@FindBy(xpath = "//a[contains(text(),' Sign Out')]")
	public WebElement SignOut_lnk;

	@FindBy(xpath = ".//*[@id='loginForm']/div[1]")
	public WebElement logout_lbl;

	// ********************** Page method begins from here *********************

	public void logoutfromApplication() throws InterruptedException {

		Thread.sleep(5000);

		System.out.println("Starting execution of after Suite method");
		Log.info("Starting execution of after Suite method");

		role_btn.click();
		Thread.sleep(1000);
		SignOut_lnk.click();
		Thread.sleep(5000);
		CommonMethods.iselementcurrentlyvisible(logout_lbl);

		if (CommonMethods.iselementcurrentlyvisible(logout_lbl) == true) {
			System.out.println("You have successfully logged out.");
			Log.info("You have successfully logged out.");

		}
	}
}
