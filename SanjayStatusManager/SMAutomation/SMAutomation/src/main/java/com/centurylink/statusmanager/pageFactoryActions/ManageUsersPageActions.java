package com.centurylink.statusmanager.pageFactoryActions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import com.centurylink.statusmanager.utilities.CommonMethods;
import com.centurylink.statusmanager.utilities.SeleniumDriver;
import com.centurylink.statusmanager.utilities.URLConfigs;

import junit.framework.Assert;

public class ManageUsersPageActions {
	
	WebDriver driver ;
	
	FileInputStream fis ;
	Properties prop = new Properties();
	
	private final static org.slf4j.Logger Log = LoggerFactory.getLogger(ManageUsersPageActions.class);
	
	public ManageUsersPageActions (WebDriver driver) {
		
		this.driver=driver ;
		PageFactory.initElements(SeleniumDriver.getDriver(), this);
	}
	
	@FindBy(how=How.XPATH, using =".//span[@ng-bind='tab.title' and contains(text(),'Manage Users')]")
	public WebElement ManageUsersTab_lbl ;
	
	@FindBy(xpath=".//div[@class='group-all-items userDetailWrap col-lg-6 hidden-sm hidden-xs']/label[contains(text(),'User Information')]/following-sibling::div[1]/div[1]/label[1]")
	public WebElement CUID_lbl ;
	
	@FindBy(xpath=".//div[@class='group-all-items userDetailWrap col-lg-6 hidden-sm hidden-xs']/label[contains(text(),'User Information')]/following-sibling::div[1]/div[2]/label[1]")
	public WebElement CUIDvalue_lbl ;
	
	
	@FindBy(how=How.XPATH, using =".//*[@ng-bind='tab.title' and contains(text(),'Manage Users')]//following-sibling::a")
	public WebElement closeManageUsersTab_img ;
	
	
//	String as= ".//div[@class='group-all-items userDetailWrap col-lg-6 hidden-sm hidden-xs']/label[contains(text(),'User Information')]/following-sibling::div[1]/div[1]/label[1]";
	
	String a = ".//div[@class='group-all-items userDetailWrap col-lg-6 hidden-sm hidden-xs']/label[contains(text(),'User Information')]/" ;
	
	
	
	
	public void verifyLandingPageforManageUsers() {
		
		String actualtitle = ManageUsersTab_lbl.getText() ;
		String expectedtitle = "Manage Users" ;
		
		if(expectedtitle.equals(actualtitle)) {
			
			Log.info("Landed in Manage Users tab.");
		}else {
			
			Assert.fail();
		}
	}
	
	
	public void validateCUID() throws InterruptedException {
		
		CommonMethods.WaitforElement(CUID_lbl);
		try {
			fis = new FileInputStream(URLConfigs.BASE_FILE_PATH) ;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String username = prop.getProperty("username") ;
		
		if(CUID_lbl.getText().trim().equals("CUID")) {
			
			if(CUIDvalue_lbl.getText().trim().equals(username)) {
				
				CommonMethods.captureScreenshot(URLConfigs.SCREENSHOT_PATH+ "\\Validate User's profile page" + "_" + SeleniumDriver.timestamp() + ".png");
				Log.info("CUID matched. User's profile is displayed.");
			}
		}
		
	}
	
	
	public void verifyandcloseManageUsertab() {
		
		String tabtitle = "Manage Users" ;
		String actualtabtitle = ManageUsersTab_lbl.getText().trim() ;
		
		if(tabtitle.equals(actualtabtitle)) {
			
			closeManageUsersTab_img.click();
		//	Assert.assertSame(tabtitle, actualtabtitle);
			Log.info("Closed Manage Users tab");
		}else{
			
			Assert.fail("Actual title = "+actualtabtitle);
		}
		
	}
	
	

}
